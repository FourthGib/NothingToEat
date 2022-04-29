package com.cs210.nothingtoeat.view;

import com.cs210.nothingtoeat.controller.Controller;
import com.cs210.nothingtoeat.model.Ingredient;
import com.cs210.nothingtoeat.model.Meat;
import com.cs210.nothingtoeat.model.Produce;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;



public class addToStockView extends Scene {

    //declare all buttons/drop-downs, ect
    public static final int FONT_SIZE = 25;

    //list for Meat CB
    ObservableList<String> meatOptions =  FXCollections.observableArrayList( "Beef", "Pork","Poultry", "Fish", "Shell Fish", "Exotic");
    ComboBox<String> meatCB = new ComboBox(meatOptions);

    //TODO List for produce type for produceType CB
    ObservableList<String> produceType = FXCollections.observableArrayList("Fruit", "Vegetable", "herbs");
    //TODO - "Type" should be the default
    private ComboBox<String> produceTypeCB = new ComboBox<>(produceType);
    private TextField produceTF = new TextField();
    private TextField dairyTF = new TextField();
    private TextField seasoningTF = new TextField();
    private TextField pantryTF = new TextField();
    private Label meatLabel = new Label("Meat");
    private Label produceLabel = new Label("Produce");
    private Label dairyLabel = new Label("Dairy");
    private Label seasonLabel = new Label("Seasoning");
    private Label pantryLabel = new Label("Pantry");

    private Produce selectedProduce;
    private ObservableList<Produce> produceList;
    private ObservableList<Ingredient> ingredientsList;
    private ObservableList<Meat> meatList;

    private Button addButton = new Button("Add");

    private Controller controller = Controller.getInstance();

    public addToStockView() {
        super(new GridPane(), MainScene.WIDTH, MainScene.HEIGHT);
        GridPane pane = new GridPane();

        RowConstraints row1 = new RowConstraints();
        row1.setPrefHeight(25);
        pane.getRowConstraints().add(row1);
        ColumnConstraints colC = new ColumnConstraints();
        colC.setHalignment(HPos.CENTER);
        pane.getColumnConstraints().add(colC);
        pane.setAlignment(Pos.CENTER);

        VBox addToStockVB = new VBox();
        addToStockVB.setSpacing(30);

        HBox meatHB = new HBox();
        meatHB.setSpacing(75);
        meatLabel.setFont(new Font("Arial", FONT_SIZE));
        meatHB.getChildren().add(meatLabel);
        meatHB.getChildren().add(meatCB);
        addToStockVB.getChildren().add(meatHB);

        HBox produceHB = new HBox();
        produceHB.setSpacing(37);
        produceLabel.setFont(new Font("Arial", FONT_SIZE));
        produceHB.getChildren().add(produceLabel);
        produceHB.getChildren().add(produceTF);
        produceHB.getChildren().add(produceTypeCB);
        addToStockVB.getChildren().add(produceHB);

        HBox dairyHB = new HBox();
        dairyHB.setSpacing(74);
        dairyLabel.setFont(new Font("Arial", FONT_SIZE));
        dairyHB.getChildren().add(dairyLabel);
        dairyHB.getChildren().add(dairyTF);
        addToStockVB.getChildren().add(dairyHB);

        HBox seasoningHB = new HBox();
        seasoningHB.setSpacing(15);
        seasonLabel.setFont(new Font("Arial", FONT_SIZE));
        seasoningHB.getChildren().add(seasonLabel);
        seasoningHB.getChildren().add(seasoningTF);
        addToStockVB.getChildren().add(seasoningHB);

        HBox pantryHB = new HBox();
        pantryHB.setSpacing(63);
        pantryLabel.setFont(new Font("Arial", FONT_SIZE));
        pantryHB.getChildren().add(pantryLabel);
        pantryHB.getChildren().add(pantryTF);
        addToStockVB.getChildren().add(pantryHB);

        addToStockVB.getChildren().add(addButton);
        addButton.setOnAction(event-> add());

        pane.add(addToStockVB,1,1);

        this.setRoot(pane);
    }
    //thinking user should be able to add from each field at once, or separately
    //TODO the "add" button needs to call this event
    private void add()
    {
        String name, type;

       if(meatCB != null)
       {
           type = meatCB.getSelectionModel().getSelectedItem();
           Meat m = new Meat(type);
           //check for dupes
           if(!(meatList.contains(m)) )
                meatList.add(m);
       }
      if(produceType != null)
      {
          type = produceTypeCB.getSelectionModel().getSelectedItem();
          Produce p = new Produce((type));
          if(!(produceList.contains(p)))
            produceList.add(p);
      }
      if(dairyTF != null)
      {
          name = dairyTF.getText();
          Ingredient i = new Ingredient("Dairy", name);
          if(!(ingredientsList.contains(i)))
            ingredientsList.add(i);
      }
      if(seasoningTF != null)
      {
          name = seasoningTF.getText();
          Ingredient i = new Ingredient("Seasoning", name);
          if(!(ingredientsList.contains(i)))
            ingredientsList.add(i);
      }
        if(pantryTF != null)
        {
            name = pantryTF.getText();
            Ingredient i = new Ingredient("Pantry", name);
            if(!(ingredientsList.contains(i)))
                ingredientsList.add(i);
        }

        //clear fields
        clearInputs();

    }


    private void clearInputs(){
        //TODO default for meatCB?
        produceTF.clear();
        dairyTF.clear();
        seasoningTF.clear();
        pantryTF.clear();
    }

}//class
