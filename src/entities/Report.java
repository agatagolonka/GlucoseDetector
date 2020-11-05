/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package entities;

import java.util.Date;

/**
 *
 * @author Agata
 */
public class Report {

    private int id;
    private String product;
    private String user;
    private Date date;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

   

    

}
