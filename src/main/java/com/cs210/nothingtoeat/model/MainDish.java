package com.cs210.nothingtoeat.model;

import java.util.ArrayList;


public class MainDish extends Dish {

    private Meat meat; //chicken, beef, fish

    MainDish(String name, ArrayList<Ingredient> ingredients, Meat meatType){
        super(name, ingredients);
        this.meat = meatType;
    }

    public Meat getMeat() {
        return meat;
    }

    public void setMeat(Meat meat) {
        this.meat = meat;
    }

}
