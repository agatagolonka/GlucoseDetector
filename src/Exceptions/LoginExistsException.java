/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Exceptions;

/**
 *
 * @author maja
 */
public class LoginExistsException extends Exception {

    public LoginExistsException() {
    }


    public LoginExistsException(String msg) {
        super(msg);
    }
}
