package com.cs210.nothingtoeat.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.*;
import java.util.ArrayList;
import java.io.IOException;

public class Stock {

    private ObservableList<Ingredient> mAllIngredients;
    private ObservableList<Produce> mAllProduce;
    private ObservableList<Meat> mAllMeat;
    private ObservableList<Recipe> mAllRecipes;

    private static final String RECIPE_FILE = "RecipeList.dat";
    private static final String MEAT_FILE = "MeatList.dat";
    private static final String PRODUCE_FILE = "ProduceList.dat";
    private static final String INGREDIENT_FILE = "IngredientList.dat";

    private static Stock stockInstance = null;

    private Stock(){
        mAllRecipes = FXCollections.observableArrayList();
        mAllMeat = FXCollections.observableArrayList();
        mAllProduce = FXCollections.observableArrayList();
        mAllIngredients = FXCollections.observableArrayList();
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
                    Recipe[] temp = (Recipe[]) fileReader.readObject();
                    mAllRecipes.addAll(temp);
                }
                if (fileName.equals(MEAT_FILE)){
                    Meat[] temp = (Meat[]) fileReader.readObject();
                    mAllMeat.addAll(temp);
                }
                if (fileName.equals(PRODUCE_FILE)){
                    Produce[] temp = (Produce[]) fileReader.readObject();
                    mAllProduce.addAll(temp);
                }
                if (fileName.equals(INGREDIENT_FILE)){
                    Ingredient[] temp = (Ingredient[]) fileReader.readObject();
                    mAllIngredients.addAll(temp);
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

    public ObservableList<Ingredient> getAllIngredients(){
        populateList(INGREDIENT_FILE);
        for (Ingredient i : mAllIngredients){

        }
        return mAllIngredients;}
    public ObservableList<Meat> getAllMeat(){
        populateList(MEAT_FILE);
        return mAllMeat;}
    public ObservableList<Produce> getAllProduce(){
        populateList(PRODUCE_FILE);
        return mAllProduce;}

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
                Recipe[] temp = new Recipe[mAllRecipes.size()];
                for (int i = 0; i < temp.length; i++) {
                    temp[i] = mAllRecipes.get(i);
                }
                fileWriter.writeObject(temp);
            }
            if (fileName.equals(MEAT_FILE)){
                Meat[] temp = new Meat[mAllMeat.size()];
                for (int i = 0; i < temp.length; i++) {
                    temp[i] = mAllMeat.get(i);
                }
                fileWriter.writeObject(temp);
            }
            if (fileName.equals(PRODUCE_FILE)){
                Produce[] temp = new Produce[mAllProduce.size()];
                for (int i = 0; i < temp.length; i++) {
                    temp[i] = mAllProduce.get(i);
                }
                fileWriter.writeObject(temp);
            }
            if (fileName.equals(INGREDIENT_FILE)){
                Ingredient[] temp = new Ingredient[mAllIngredients.size()];
                for (int i = 0; i < temp.length; i++) {
                    temp[i] = mAllIngredients.get(i);
                }
                fileWriter.writeObject(temp);
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
        if (!mAllIngredients.contains(ingredient)) {
            mAllIngredients.add(ingredient);
            System.out.println("Added Ingredient: " + ingredient);
            saveStock();
            System.out.println("Stock Saved");

         for(Ingredient i : mAllIngredients )
                System.out.println(i);
            return true;
        }
        return false;
    }

    public boolean addToStock(Meat meat){
        if (!mAllMeat.contains(meat)) {
            mAllMeat.add(meat);
            System.out.println("Added Meat: " + meat);
            saveStock();
            System.out.println("Stock Saved");
            for(Meat i : mAllMeat )
                System.out.println(i);

            return true;

        }
        return false;
    }

    public boolean addToStock(Produce produce){
        if (!mAllProduce.contains(produce)) {
            mAllProduce.add(produce);
            System.out.println("Added produce: " + produce);
            saveStock();
            System.out.println("Stock Saved");

            for(Produce i : mAllProduce )
                System.out.println(i);
            return true;

        }
        return false;
    }

    public boolean removeFromStock(Ingredient ingredient){
        if (!mAllIngredients.isEmpty()) {
            mAllIngredients.remove(ingredient);
            saveStock();
            System.out.println("Stock Saved");
        }
        return false;
    }

    public boolean removeFromStock(Meat meat){
        if (!mAllMeat.isEmpty()) {
            mAllMeat.remove(meat);
            saveStock();
            System.out.println("Stock Saved");
        }
        return false;
    }

    public boolean removeFromStock(Produce produce){
        if (!mAllProduce.isEmpty()) {
            mAllProduce.remove(produce);
            saveStock();
            System.out.println("Stock Saved");
        }
        return false;
    }

    public boolean addRecipe(Recipe recipe){
        if (!mAllRecipes.contains(recipe)) {
            mAllRecipes.add(recipe);
            saveStock();
            System.out.println("Stock Saved");
            return true;
        }
        return false;
    }

    public boolean removeRecipe(Recipe recipe){
        if (!mAllRecipes.isEmpty()) {
            mAllRecipes.remove(recipe);
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


}
