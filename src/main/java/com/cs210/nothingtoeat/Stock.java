package com.cs210.nothingtoeat;
import java.util.*;

public class Stock {

    private ArrayList<Ingredient> ingredients;
    private ArrayList<Meat> meatList;
    private ArrayList<Produce> produceList;

    private static Stock stockInstance = null;

    private Stock(){
        ingredients = null;
        meatList = null;
        produceList = null;
    }

    public static Stock getInstance(){
        if (stockInstance == null)
            stockInstance = new Stock();
        return  stockInstance;
    }

    public boolean addToStock(Ingredient ingredient){
        if (!ingredients.isEmpty() && !ingredients.contains(ingredient)) {
            ingredients.add(ingredient);
            return true;
        }
        return false;
    }

    public boolean addToStock(Meat meat){
        if (!meatList.isEmpty() && !meatList.contains(meat)) {
            meatList.add(meat);
            return true;
        }
        return false;
    }

    public boolean addToStock(Produce produce){
        if (!produceList.isEmpty() && !produceList.contains(produce)) {
            produceList.add(produce);
            return true;
        }
        return false;
    }

    public boolean removeFromStock(Ingredient ingredient){
        if (!ingredients.isEmpty()) {
            ingredients.remove(ingredient);
        }
        return false;
    }

    public boolean removeFromStock(Meat meat){
        if (!meatList.isEmpty()) {
            meatList.remove(meat);
        }
        return false;
    }

    public boolean removeFromStock(Produce produce){
        if (!produceList.isEmpty()) {
            produceList.remove(produce);
        }
        return false;
    }

    public ArrayList<Ingredient> getIngredients() {
        return ingredients;
    }

    public ArrayList<Meat> getMeatList() {
        return meatList;
    }

    public ArrayList<Produce> getProduceList() {
        return produceList;
    }
}
