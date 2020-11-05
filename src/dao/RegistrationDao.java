package dao;

import Exceptions.LoginExistsException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class RegistrationDao {

    public static void register(String login, String password) throws LoginExistsException {
        try {
            //Sprawdź czy istnieje użytkownik o podanym loginie
            if (loginExists(login)) {
                throw new LoginExistsException("Użytkownik o takim loginie juz istnieje w bazie.");
            } else {
                //Jeśli nie ma kolizji nazw, dodaj nowego pracownika
                String command = "INSERT INTO user (name,password) VALUES (?,?);";
                PreparedStatement stat = Database.getConnection().prepareStatement(command);
                stat.setString(1, login);
                stat.setString(2, password);
                stat.executeUpdate();
                stat.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(RegistrationDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void unregister(String login)
    {
        try {
            String command = "DELETE FROM user WHERE name = ?";
            PreparedStatement stat = Database.getConnection().prepareStatement(command);
            stat.setString(1, login);
            stat.executeUpdate();
            stat.close();
        } catch (SQLException ex) {
            Logger.getLogger(RegistrationDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static boolean loginExists(String login) throws SQLException
    {
        String command = "SELECT name FROM user WHERE name = ?";
        PreparedStatement stat = Database.getConnection().prepareStatement(command);

        stat.setString(1, login);

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
