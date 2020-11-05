/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package entities;

import dao.EFoodCategory;

/**
 *
 * @author maja
 */
public class Product {

    private int id;
    private String name;
    private int carbo;
    private int fat;
    private int protein;
    private int ig;
    private int kcal;
    private EFoodCategory category;

    

    public int getCarbo() {
        return carbo;
    }

    public void setCarbo(int carbo) {
        this.carbo = carbo;
    }

    public EFoodCategory getCategory() {
        return category;
    }

    public void setCategory(EFoodCategory category) {
        this.category = category;
    }

    public void setCategory(String category) {
        for(EFoodCategory c : EFoodCategory.values())
        {
            if(c.getLabel().equals(category))
            {
                this.category = c;
            }
        }
    }

    public int getFat() {
        return fat;
    }

    public void setFat(int fat) {
        this.fat = fat;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIg() {
        return ig;
    }

    public void setIg(int ig) {
        this.ig = ig;
    }

    public int getKcal() {
        return kcal;
    }

    public void setKcal(int kcal) {
        this.kcal = kcal;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getProtein() {
        return protein;
    }

    public void setProtein(int protein) {
        this.protein = protein;
    }

    @Override
    public String toString() {
        return name;
    }

    


}
