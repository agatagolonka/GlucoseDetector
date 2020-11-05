package dao;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Database {

    private static Connection connection = null;

    public static Connection getConnection()
    {      
        try
        {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            String url = "jdbc:mysql://localhost:3306/glucose";
            String userName = "root";
            String password = "123";
            connection = DriverManager.getConnection(url, userName, password);
        }
        catch (Exception ex)
        {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        return connection;
    }

}
