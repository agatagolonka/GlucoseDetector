/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package GUI;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

/**
 *
 * @author maja
 */
public class ChartFrame extends JFrame implements Runnable, ActionListener{


   XYSeries series1;
   XYSeries series2;

   JFreeChart lineGraph;
   BufferStrategy buffer;

   BufferedImage chart;
   Graphics graphics = null;
   XYPlot plot;

   private double gStezenieAktualne = 80.0; // aktualny poziom glukozy w krwi - trzeba jakiś podać
   private double iStezenieAktualne = 0.0; // aktualny poziom insuliny w krwi - trzeba jakiś podać
   private double gZmianaStezenia; // jednostkowa (w danym skoku czasu) zmiana poziomu glukozy w krwi
   private double iZmianaStezenia; // jednostkowa (w danym skoku czasu) zmiana poziomu insuliny w krwi
   private double gPodana = 0; // podana glukoza, np. posiłek
   private double iPodana = 0; // podana insulina, np. zastrzyk

   // Poniżej są różne stałe:

   public static final double wsp = 0.01666; // współczynnik przeliczający parametry z jednostki czasu godzina na minuta

   public static final double a = 2.0 * wsp; // parametr
   public static final double b = 0.5 * wsp; // parametr
   public static final double v = 0.05 * wsp; // parametr
   public static final double w = 1.0 * wsp; // parametr
   public static final double f = 80.0; // progowy poziom glukozy w krwi, powyżej następuje uwolnienie insuliny

   private boolean stopped = true;
   private boolean paused = false;

   private Canvas canvas;
   private JPanel buttonPanel;
   private JPanel mainPanel;
   private JButton pauseButton;
   private JButton stopButton;

   private boolean stop = false;
   private boolean pause = false;

   private SimulationPanel simPanel;

   public ChartFrame(SimulationPanel simPanel)
   {
        initComponents();
        series1 = new XYSeries("glukoza");
        series2 = new XYSeries("insulina");
        this.setSize(700, 600);
        this.setVisible(true);
        this.setTitle("Wykres - aktualny poziom insuliny i glukozy we krwi");
        pauseButton.setIcon(new ImageIcon("src/images/Aqua-Pause-icon.png"));
        stopButton.setIcon(new ImageIcon("src/images/Aqua-Stop-icon.png"));

        this.simPanel = simPanel;
        this.setResizable(false);

   }

   private void initComponents()
   {
       
        mainPanel = new JPanel();
        buttonPanel = new JPanel();
        pauseButton = new JButton("Pauza");
        pauseButton.addActionListener(this);
        pauseButton.setActionCommand("pause");

        stopButton = new JButton("Stop");
        stopButton.addActionListener(this);
        stopButton.setActionCommand("stop");
        
        buttonPanel.add(pauseButton);
        buttonPanel.add(stopButton);
        

        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS));

        canvas = new Canvas();
        canvas.setSize(new Dimension(700,470));
        mainPanel.add(canvas);
        mainPanel.add(buttonPanel);
        this.add(mainPanel);
   }

   public void updateChart(int iteration, double glucose, double insulin)
    {
         series1.add(iteration,glucose);
         series2.add(iteration,insulin);

        // Tworzenie kolekcji serii zawierajacej serie "series"
        XYSeriesCollection xySeriesCollection = new XYSeriesCollection(series1);
        xySeriesCollection.addSeries(series2);

        lineGraph = ChartFactory.createXYLineChart
                    ("",  // Title
                      "minuta",           // X-Axis label
                      "ml/g",           // Y-Axis label
                      xySeriesCollection,          // seria danych
                      PlotOrientation.VERTICAL,        //Plot orientation
                      true,                //show legend
                      true,                // Show tooltips
                      false               //url show
                    );

        plot = (XYPlot) lineGraph.getPlot();
        NumberAxis xAxis = (NumberAxis) plot.getDomainAxis();
        NumberAxis yAxis = (NumberAxis) plot.getRangeAxis();
    }

    public void startSymulation() throws InterruptedException//symulacja
    {        
        canvas.createBufferStrategy(2);
        buffer = canvas.getBufferStrategy();

        int i = 0;  //iteracja
            while(!stop)
            {

                if (gStezenieAktualne < f) {
                        // gdy stężenie jest poniżej progu uwalniania insuliny
                        gZmianaStezenia = ((-(v*gStezenieAktualne*iStezenieAktualne)) + w*(f-gStezenieAktualne) + gPodana);
                } else {
                        // gdy stężenie jest powyżej progu uwalniania insiliny
                        gZmianaStezenia = ((-(v*gStezenieAktualne*iStezenieAktualne)) + gPodana);
                }


                // zmiana poziomu insuliny w krwi w ciągu danej minuty
                if (gStezenieAktualne <= f) {
                        // gdy stężenie glukozy jest poniżej progu uwalniania insuliny
                        iZmianaStezenia = (-(a*iStezenieAktualne)) + iPodana;
                } else {
                        // gdy stężenie glukozy jest powyżej progu uwalniania insuliny
                        iZmianaStezenia = (-(a*iStezenieAktualne)) + iPodana + b*(gStezenieAktualne-f);
                }

                // obliczenie nowego poziomu aktualnego glukozy i insuliny po upłynięciu minuty
                gStezenieAktualne = gStezenieAktualne + gZmianaStezenia;
                iStezenieAktualne = iStezenieAktualne + iZmianaStezenia;

                updateChart(i,gStezenieAktualne,iStezenieAktualne);
                chart = lineGraph.createBufferedImage(700,490);
                drawStuff();

                if(gPodana != 0)
                    gPodana = 0;
                if(iPodana != 0)
                    iPodana = 0;

                i++;

                Thread.sleep(1000);

                while(pause)
                {
                    Thread.sleep(500);
                }

            } // koniec pętli obliczającej poziom glukozy i insuliny

    }

    public void run() {
        try {
            startSymulation();
        } catch (InterruptedException ex) {
            Logger.getLogger(ChartFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void drawStuff()//wyrysowanie uzyskanych wartości
    {
        graphics = buffer.getDrawGraphics();
        graphics.drawImage(chart, 0, 0, this);
        buffer.show();
        Toolkit.getDefaultToolkit().sync();
    }

    public double getgPodana() {
        return gPodana;
    }

    public void setgPodana(double gPodana) {
        this.gPodana = gPodana;
    }

    public double getiPodana() {
        return iPodana;
    }

    public void setiPodana(double iPodana) {
        this.iPodana = iPodana;
    }

    public void actionPerformed(ActionEvent e) {

        String command = e.getActionCommand();

        if(command.equals("stop"))
        {
            stop = true;
            this.setVisible(false);
            simPanel.jButton5.setEnabled(false);

        }
        else if(command.equals("pause"))
        {
            if(pause){
                pause = false;
                pauseButton.setIcon(new ImageIcon("src/images/Aqua-Pause-icon.png"));

            }

            else{
                pause = true;
                pauseButton.setIcon(new ImageIcon("src/images/Aqua-Play-icon.png"));
        }
        }
    }

    
}
