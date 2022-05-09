package com.cs210.nothingtoeat.model;

import java.io.IOException;
import java.util.ArrayList;

public class Stock {

    private ArrayList<Ingredient> ingredients;
    private ArrayList<Meat> meatList;
    private ArrayList<Produce> produceList;
    private ArrayList<Recipe> recipeList;

    private static final String FILE_NAME = "RecipeList.dat";

    private static Stock stockInstance = null;

    private Stock(){
        ingredients = new ArrayList<>();
        meatList = new ArrayList<>();
        produceList = new ArrayList<>();
        recipeList = new ArrayList<>();
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

    public boolean addRecipe(Recipe recipe){
        if (!recipeList.contains(recipe)) {
            return recipeList.add(recipe);
        }
        return false;
    }

    public boolean removeRecipe(Recipe recipe){
        if (!recipeList.isEmpty()) {
            return recipeList.remove(recipe);
        }
        return false;
    }

    public Recipe generateRecipe(Dish dish, String preparation){
        Recipe recipe = new Recipe();
        recipe.setPreparation(preparation);
        //check if dish is a main dish or side dish
        if (dish instanceof MainDish mainDish) {
            //generate for chicken
            if (mainDish.getMeat().getType().equalsIgnoreCase("chicken")) {
                //grilled chicken
                if (preparation.equalsIgnoreCase("Grilled")) {
                    //chicken needs to grill to an internal temp of
                }
                //baked chicken
                if (preparation.equalsIgnoreCase("baked")) {
                    //chicken needs to bake for ____ min at a temp of____
                }
                //chicken soup
                if (preparation.equalsIgnoreCase("boiled")) {
                    //chicken needs to boil for _____ min on med/high flame
                }
                //fried chicken
                if (preparation.equalsIgnoreCase("fried")) {
                    //chicken needs to be fried for ____ min at a temp of ____
                }
            }
            //generate for beef
            if (mainDish.getMeat().getType().equalsIgnoreCase("Beef")) {
                //grilled beef
                if (preparation.equalsIgnoreCase("Grilled")) {
                    //beef needs to grill to an internal temp of
                }
                //baked beef
                if (preparation.equalsIgnoreCase("baked")) {
                    //beef needs to bake for ____ min at a temp of____
                }
                //beef soup
                if (preparation.equalsIgnoreCase("boiled")) {
                    //beef needs to boil for _____ min on med/high flame
                }
                //fried beef
                if (preparation.equalsIgnoreCase("fried")) {
                    //beef needs to be fried for ____ min at a temp of ____
                }
            }
            //generate for fish
            if (mainDish.getMeat().getType() == "Fish") {
                //grilled fish
                if (preparation.equalsIgnoreCase("Grilled")) {
                    //fish needs to grill to an internal temp of
                }
                //baked fish
                if (preparation.equalsIgnoreCase("baked")) {
                    //fish needs to bake for ____ min at a temp of____
                }
                //fish soup
                if (preparation.equalsIgnoreCase("boiled")) {
                    //fish needs to boil for _____ min on med/high flame
                }
                //fried fish
                if (preparation.equalsIgnoreCase("fried")) {
                    //fish needs to be fried for ____ min at a temp of ____
                }
            }
        } else if (dish instanceof SideDish sideDish) {
            //grilled
            if (preparation.equalsIgnoreCase("Grilled")) {
                //produce needs to grill to an internal temp of
            }
            //baked
            if (preparation.equalsIgnoreCase("baked")) {
                //produce needs to bake for ____ min at a temp of____
            }
            //boiled
            if (preparation.equalsIgnoreCase("boiled")) {
                //chicken needs to boil for _____ min on med/high flame
            }
            //fried
            if (preparation.equalsIgnoreCase("fried")) {
                //most produce needs to be fried for ____ min at a temp of ____
            }
        }
        //

        //generate for chicken
        return recipe;
    }

    public String generateShoppingList(Recipe recipe){
        return "TODO SHOPPING LIST";
    }

    public ArrayList<Recipe> getRecipeList() {
        return recipeList;
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
