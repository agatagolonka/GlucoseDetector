/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

/**
 *
 * @author maja
 */
public enum EFoodCategory {

    NABIAL((short) 1, "nabiał"),
    OWOCE((short) 2, "owoce"),
    MIESO((short)3, "mięso"),
    FASTFOOD((short)4,"fast food"),
    SLODYCZE((short)5, "słodycze"),
    ALKOHOL((short)6, "alkohol"),
    PIECZYWO((short)7, "pieczywo"),
    WARZYWA((short)8, "warzywa"),
    RYBY((short)9, "ryby"),
    MACZNE((short)10, "mączne"),
    CIASTA((short)11, "ciasta"),
    NAPOJE((short)12, "napoje");



    private String label;
    private short id;

    EFoodCategory(short id, String label)
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
