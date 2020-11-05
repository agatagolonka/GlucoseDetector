/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Exceptions;

/**
 *
 * @author Agata
 */
public class FoodExistException  extends Exception {

    public FoodExistException(){

    }

    public FoodExistException(String msg){
        super(msg);
    }

}
