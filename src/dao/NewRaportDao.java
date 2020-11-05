/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import Exceptions.WrongRaportException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Agata
 */
public class NewRaportDao {
   
 public static void makingNew(int id_prod) throws WrongRaportException {
        try {
            //Sprawdź czy istnieje użytkownik o podanym loginie
                //Jeśli nie ma kolizji nazw, dodaj nowego pracownika

                System.out.println(id_prod);
                System.out.println(LoginDao.id);

                String command = "INSERT INTO product_user (product_id,user_id,date) values (?,?, now())";
                PreparedStatement stat = Database.getConnection().prepareStatement(command);
                stat.setInt(1, id_prod);
                stat.setInt(2, LoginDao.id);
                stat.executeUpdate();
                stat.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(RegistrationDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
