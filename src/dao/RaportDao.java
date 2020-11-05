/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import Exceptions.WrongRaportException;
import entities.Report;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Agata
 */
public class RaportDao {

 

    public static Vector<Report> MakeRaport(String login) throws WrongRaportException
    {
        
        Vector<Report> rekordy = new Vector();
        try {
            String command = "select user.name as user_name, product.name AS product_name, date FROM product_user JOIN user ON user.id=product_user.user_id JOIN product ON product.id=product_user.product_id WHERE user.name = ?";
            PreparedStatement stat = Database.getConnection().prepareStatement(command);
            stat.setString(1, login);
            ResultSet result = stat.executeQuery();
            
            while (result.next()) {
                    Report report = new Report();
                    report.setUser(result.getString(1));
                    report.setProduct(result.getString(2));
                    report.setDate(result.getDate(3));
                    rekordy.add(report);
            }
        }
        catch (SQLException ex)
        {
            Logger.getLogger(LoginDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rekordy;
    }

    
}
