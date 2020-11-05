/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import Exceptions.FoodExistException;
import Exceptions.WrongFoodException;
import entities.Product;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Agata
 */

public class FoodDao {

    public static String food;

    public static boolean search(String name) throws WrongFoodException
    {
        try {
            String command = "SELECT * FROM product WHERE name = ?";
            PreparedStatement stat = Database.getConnection().prepareStatement(command);
            stat.setString(1, name);
            ResultSet result = stat.executeQuery();
            if (!result.next()) {
                throw new WrongFoodException("Nie ma takiego jedzenia");
            }
            else {
                food = name;
            }

            result.close();
            stat.close();
        }
        catch (SQLException ex)
        {
            Logger.getLogger(LoginDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }

    public static List<Product> getAllByCategory(EFoodCategory category) throws WrongFoodException
    {
        List<Product> productList = new ArrayList<Product>();
        try {
            String command = "SELECT * FROM product WHERE category = ?";
            PreparedStatement stat = Database.getConnection().prepareStatement(command);
            stat.setString(1, category.getLabel());
            ResultSet result = stat.executeQuery();

             while(result.next())
             {
                Product product = new Product();
                product.setId(result.getInt(1));
                product.setName(result.getString(2));
                product.setCarbo(result.getInt(3));
                product.setProtein(result.getInt(4));
                product.setFat(result.getInt(5));
                product.setKcal(result.getInt(6));
                product.setIg(result.getInt(7));
                product.setCategory(result.getString(8));

                productList.add(product);
             }

            result.close();
            stat.close();

        }
        catch (SQLException ex)
        {
            Logger.getLogger(LoginDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return  productList;

    }

        public static List<Product> getAllCategory(ListCategory category) throws WrongFoodException
    {
        List<Product> productList = new ArrayList<Product>();
        try {
            String command = "SELECT * FROM product WHERE category = ?";
            PreparedStatement stat = Database.getConnection().prepareStatement(command);
            stat.setString(1, category.getLabel());
            ResultSet result = stat.executeQuery();

             while(result.next())
             {
                Product product = new Product();
                product.setCategory(result.getString(8));

                productList.add(product);
             }

            result.close();
            stat.close();

        }
        catch (SQLException ex)
        {
            Logger.getLogger(LoginDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return  productList;

    }

        public static List<Product> getCategory(ListCategory category) throws WrongFoodException
    {
        List<Product> productList = new ArrayList<Product>();
        try {
            String command = "SELECT * FROM product WHERE category = UNIQUE";
            PreparedStatement stat = Database.getConnection().prepareStatement(command);
            ResultSet result = stat.executeQuery();

             while(result.next())
             {
                Product product = new Product();
                product.setCategory(result.getString(8));

                productList.add(product);
             }

            result.close();
            stat.close();

        }
        catch (SQLException ex)
        {
            Logger.getLogger(LoginDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return  productList;

    }

     public static void addNew(String name, String carbo, String protein, String fat, String kcal, String IG,String category) throws FoodExistException {
        try {
            //Sprawdź czy istnieje dane jedzenie
            if (FoodExists(name)) {
               throw new FoodExistException("Taki pokarm już istnieje w bazie");
            } else {
                //Jeśli nie ma kolizji nazw, dodaj nowego produkt
                String command = "INSERT INTO product (name,carbo,protein,fat,kcal,IG,category) VALUES (?,?,?,?,?,?,?);";
                PreparedStatement stat = Database.getConnection().prepareStatement(command);
                stat.setString(1, name);
                stat.setInt(2, Integer.parseInt(carbo));
                stat.setInt(3, Integer.parseInt(protein));
                stat.setInt(4, Integer.parseInt(fat));
                stat.setInt(5, Integer.parseInt(kcal));
                stat.setInt(6, Integer.parseInt(IG));
                stat.setString(7, category);
                stat.executeUpdate();
                stat.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(FoodDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static boolean FoodExists(String name) throws SQLException
    {
        String command = "SELECT name FROM product WHERE name = ?";
        PreparedStatement stat = Database.getConnection().prepareStatement(command);

        stat.setString(1, name);

        ResultSet rs = stat.executeQuery();

        /* Metoda rs.next() przesuwa się o jeden element w zbiorze rekordów
         * wyniku zapytania. Zwraca wartość false po ostatnim rekordzie. Metodę
         * tę trzeba wykonać, aby przejść do pierwszego elementu w zbiorze.
        */

        boolean result = false;
        if( rs.next() == true )
        {
            result = true;
        }

        stat.close();
        rs.close();

        return result;
    }
}

