package com.cs210.nothingtoeat.model;

import javafx.collections.ObservableList;

import java.io.*;
import java.util.ArrayList;
import java.io.IOException;

public class Stock {

    private ArrayList<Ingredient> ingredients;
    private ArrayList<Meat> meatList;
    private ArrayList<Produce> produceList;
    private ArrayList<Recipe> recipeList;

    private ObservableList<Ingredient> mAllIngredients;
    private ObservableList<Produce> mAllProduce;
    private ObservableList<Meat> mAllMeat;

    private static final String RECIPE_FILE = "RecipeList.dat";
    private static final String MEAT_FILE = "MeatList.dat";
    private static final String PRODUCE_FILE = "ProduceList.dat";
    private static final String INGREDIENT_FILE = "IngredientList.dat";

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

    protected void populateList(String fileName){
        try {
            File binaryFile = new File(fileName);
            if (binaryFile.exists()) {
                ObjectInputStream fileReader = new ObjectInputStream(new FileInputStream(binaryFile));
                if (fileName.equals(RECIPE_FILE)){
                    recipeList = (ArrayList<Recipe>) fileReader.readObject();
                }
                if (fileName.equals(MEAT_FILE)){
                    meatList = (ArrayList<Meat>) fileReader.readObject();
                    mAllMeat = (ObservableList<Meat>) meatList;
                }
                if (fileName.equals(PRODUCE_FILE)){
                    produceList = (ArrayList<Produce>) fileReader.readObject();
                    mAllProduce = (ObservableList<Produce>) produceList;
                }
                if (fileName.equals(INGREDIENT_FILE)){
                    ingredients = (ArrayList<Ingredient>) fileReader.readObject();
                    mAllIngredients = (ObservableList<Ingredient>) ingredients;
                }
                fileReader.close();
            }

        } catch (FileNotFoundException e) {
            System.out.println("File not found: ");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Unknown IO exception: ");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("Object is not filling the list.");
            e.printStackTrace();
        }
    }

    public ObservableList<Ingredient> getAllIngredients(){return mAllIngredients;}
    public ObservableList<Meat> getAllMeat(){return mAllMeat;}
    public ObservableList<Produce> getAllProduce(){return mAllProduce;}

    public void populateStock(){
        populateList(RECIPE_FILE);
        populateList(MEAT_FILE);
        populateList(PRODUCE_FILE);
        populateList(INGREDIENT_FILE);
    }

    private void saveList(String fileName){
        try{
            File binaryFile = new File(fileName);
            ObjectOutputStream fileWriter = new ObjectOutputStream(new FileOutputStream(binaryFile));
            if (fileName.equals(RECIPE_FILE)){
                fileWriter.writeObject(recipeList);
            }
            if (fileName.equals(MEAT_FILE)){
                fileWriter.writeObject(meatList);
            }
            if (fileName.equals(PRODUCE_FILE)){
                fileWriter.writeObject(produceList);
            }
            if (fileName.equals(INGREDIENT_FILE)){
                fileWriter.writeObject(ingredients);
            }
            fileWriter.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: ");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Unexpected IO error: ");
            e.printStackTrace();
        }
    }

    public void saveStock(){
        saveList(RECIPE_FILE);
        saveList(MEAT_FILE);
        saveList(PRODUCE_FILE);
        saveList(INGREDIENT_FILE);
    }


    public boolean addToStock(Ingredient ingredient){
        if (!ingredients.contains(ingredient)) {
            ingredients.add(ingredient);
            System.out.println("Added Ingredient: " + ingredient);
            saveStock();
            System.out.println("Stock Saved");

         for(Ingredient i : ingredients )
                System.out.println(i);
            return true;
        }
        return false;
    }

    public boolean addToStock(Meat meat){
        if (!meatList.contains(meat)) {
            meatList.add(meat);
            System.out.println("Added Meat: " + meat);
            saveStock();
            System.out.println("Stock Saved");
            for(Meat i : meatList )
                System.out.println(i);

            return true;

        }
        return false;
    }

    public boolean addToStock(Produce produce){
        if (!produceList.contains(produce)) {
            produceList.add(produce);
            System.out.println("Added produce: " + produce);
            saveStock();
            System.out.println("Stock Saved");

            for(Produce i : produceList )
                System.out.println(i);
            return true;

        }
        return false;
    }

    public boolean removeFromStock(Ingredient ingredient){
        if (!ingredients.isEmpty()) {
            ingredients.remove(ingredient);
            saveStock();
            System.out.println("Stock Saved");
        }
        return false;
    }

    public boolean removeFromStock(Meat meat){
        if (!meatList.isEmpty()) {
            meatList.remove(meat);
            saveStock();
            System.out.println("Stock Saved");
        }
        return false;
    }

    public boolean removeFromStock(Produce produce){
        if (!produceList.isEmpty()) {
            produceList.remove(produce);
            saveStock();
            System.out.println("Stock Saved");
        }
        return false;
    }

    public boolean addRecipe(Recipe recipe){
        if (!recipeList.contains(recipe)) {
            recipeList.add(recipe);
            saveStock();
            System.out.println("Stock Saved");
            return true;
        }
        return false;
    }

    public boolean removeRecipe(Recipe recipe){
        if (!recipeList.isEmpty()) {
            recipeList.remove(recipe);
            saveStock();
            System.out.println("Stock Saved");
            return true;
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
            //raw
            if (preparation.equalsIgnoreCase("raw")) {
                //when you want to make a salad or uncooked prep
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
