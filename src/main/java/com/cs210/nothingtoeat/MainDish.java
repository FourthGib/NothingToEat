package com.cs210.nothingtoeat;
import java.util.*;

public class MainDish extends Dish {

    private Meat meatType;

    MainDish(String name, ArrayList<Ingredient> ingredients, Meat meatType){
        super(name, ingredients);
        this.meatType = meatType;
    }

    public Meat getMeatType() {
        return meatType;
    }

    public void setMeatType(Meat meatType) {
        this.meatType = meatType;
    }
}
