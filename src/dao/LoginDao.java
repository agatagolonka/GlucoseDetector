package dao;

import Exceptions.WrongLoginException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jws.WebService;

/**
 *
 * @author maja
 */
@WebService()
public class LoginDao {

    public static String login;
    public static int id;

    public static boolean logging(String username, String password) throws WrongLoginException
    {
        try {
            String command = "SELECT * FROM user WHERE name = ? AND password = ?";
            PreparedStatement stat = Database.getConnection().prepareStatement(command);
            stat.setString(1, username);
            stat.setString(2, password);
            ResultSet result = stat.executeQuery();
            if (!result.next()) {
                throw new WrongLoginException("Podałeś niepoprawny login lub hasło!");
            } 
            else {
                login = username;
                id = result.getInt(1);

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

}
