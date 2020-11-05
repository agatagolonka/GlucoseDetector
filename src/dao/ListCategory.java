/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

/**
 *
 * @author Agata
 */
public class ListCategory {


    private String label;
    private short id;

    ListCategory(){
        
    }

    ListCategory(short id, String label)
    {
        this.label = label;
        this.id = id;
    }

    public short getId() {
        return id;
    }

    public void setId(short id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }



}
