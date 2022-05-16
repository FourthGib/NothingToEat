package com.cs210.nothingtoeat.view;

import com.cs210.nothingtoeat.model.Ingredient;
import com.cs210.nothingtoeat.model.Meat;
import com.cs210.nothingtoeat.model.Produce;
import com.cs210.nothingtoeat.model.Stock;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;

//unable to do one LV becuase a LV of Stock would also include the recipes
public class removeScene extends Scene {

    //buttons and private fields
    //label/instruction
    Label selectLabel = new Label("Please select the item type to remove");
    //observableList with type that can be removed (produce, meat, dairy, pantry, seasoning)
    ObservableList<String> types = FXCollections.observableArrayList("Select Category", "Meat", "Produce", "Other");
    // comboBox with types
    ComboBox<String> typeCB = new ComboBox<>(types);

    private ObservableList<Ingredient> ingredientList;
    private ObservableList<Meat> meatList;
    private ObservableList<Produce> produceList;

    private Ingredient selectedIngredient;
    private Meat selectedMeat;
    private Produce selectedProduce;

    private ListView<Ingredient> mIngredientListView = new ListView<>();
    private ListView<Meat> mMeatListView = new ListView<>();
    private ListView<Produce> mProduceListView = new ListView<>();

    Button removeButton = new Button("Remove");
    Button returnButton = new Button("Return");

    //scene method
    public removeScene() {

        super(new GridPane(), MainScene.WIDTH, MainScene.HEIGHT);
        GridPane pane = new GridPane();

        RowConstraints row1 = new RowConstraints();
        row1.setPrefHeight(25);
        pane.getRowConstraints().add(row1);
        ColumnConstraints colC = new ColumnConstraints();
        colC.setHalignment(HPos.CENTER);
        pane.getColumnConstraints().add(colC);
        pane.setAlignment(Pos.CENTER);

        VBox removeVB = new VBox();
        removeVB.setSpacing(15);

        mIngredientListView.getSelectionModel().selectedItemProperty().addListener((observableValue, oldValue, newValue) -> updateSelectedFood(newValue));
        mMeatListView.getSelectionModel().selectedItemProperty().addListener((observableValue, oldValue, newValue) -> updateSelectedFood(newValue));
        mProduceListView.getSelectionModel().selectedItemProperty().addListener((observableValue, oldValue, newValue) -> updateSelectedFood(newValue));

        mIngredientListView.setPrefWidth(MainScene.WIDTH);
        mProduceListView.setPrefWidth(MainScene.WIDTH);
        mMeatListView.setPrefWidth(MainScene.WIDTH);



        mIngredientListView.setItems(Stock.getInstance().getAllIngredients());
        mProduceListView.setItems(Stock.getInstance().getAllProduce());
        mMeatListView.setItems(Stock.getInstance().getAllMeat());

        removeVB.getChildren().add(mIngredientListView);
        removeVB.getChildren().add(mMeatListView);
        removeVB.getChildren().add(mProduceListView);

        HBox buttonsHB = new HBox();
        buttonsHB.setSpacing(15);
        buttonsHB.getChildren().add(removeButton);
        buttonsHB.getChildren().add(returnButton);

        removeButton.setOnAction(event -> removeStockItem());
        returnButton.setOnAction(event -> returnToMain());

        pane.add(removeVB, 1, 1);
        pane.add(buttonsHB,1,2);



        this.setRoot(pane);
    }

    private void returnToMain() {
        //TODO need to clear LV's

        ViewNavigator.loadScene("Nothing To Eat", new MainScene());
    }

    private void updateSelectedFood(Object newValue) {
        if (newValue instanceof Ingredient) {
            Ingredient o = (Ingredient) newValue;
            selectedIngredient = o;

        } else if (newValue instanceof Produce) {
            Produce o = (Produce) newValue;
            selectedProduce = o;
        } else if (newValue instanceof Meat) {
            Meat o = (Meat) newValue;
            selectedMeat = o;
        }

    }

//    private void typeDisplay() {
//        String list = typeCB.getSelectionModel().getSelectedItem();
//        Stock.getInstance().populateStock();
//        //TODO...each time they select it is shows the full list again...
//        //TODO...add method for all foods are doubling up, can enter one of each category but when displaying it shows several
//
//        if (list.equals("Meat")) {
//            mMeatListView.setItems(Stock.getInstance().getAllMeat());
//        } else if (list.equals("Produce")) {
//            mProduceListView.setItems(Stock.getInstance().getAllProduce());
//        } else {
//            mIngredientListView.setItems(Stock.getInstance().getAllIngredients());
//        }
//    }

    private void removeStockItem() {
        //should be based on selected
        if (selectedProduce == null && selectedIngredient == null && selectedMeat == null)
            return;

        //if selected type is produce
       else if (selectedProduce != null) {
            //removeFromStock(produce)
            Stock.getInstance().removeFromStock(selectedProduce);
        }
        //if selected type is meat
        else if (selectedMeat != null) {
            //removeFromStock(meat)
            Stock.getInstance().removeFromStock(selectedMeat);
        }
        //else
        else if (selectedIngredient != null) {
            //removeFromStock(ingredient)
            Stock.getInstance().removeFromStock(selectedIngredient);
        }

       updateDisplay();


        //OR simply removeFromStock(slectedItem) and given the item type the compiler knows which removeFromStock() to use?


    }

    private void updateDisplay() {
        mProduceListView.refresh();
        mIngredientListView.refresh();
        mMeatListView.refresh();
    }
}
