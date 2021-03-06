package com.cs210.nothingtoeat.view;

import com.cs210.nothingtoeat.controller.Controller;
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
import javafx.scene.text.Font;


public class addToStockView extends Scene {

    //declare all buttons/drop-downs, ect
    public static final int FONT_SIZE = 25;

    //list for Meat CB
    ObservableList<String> meatOptions = FXCollections.observableArrayList("Select Type", "Beef", "Pork", "Poultry", "Fish", "Shell Fish", "Exotic");
    ComboBox<String> meatCB = new ComboBox(meatOptions);

    //TODO List for produce type for produceType CB
    ObservableList<String> produceType = FXCollections.observableArrayList("Select Type", "Fruit", "Vegetable", "herbs");
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
    private Label produceTypeErr = new Label(" this item has not been added");
    private Label produceTypeRequiredErr = new Label("Type is required,");

    private Produce selectedProduce;
    private ObservableList<Produce> produceObservableList;
    private ObservableList<Ingredient> ingredientsObservableList;
    private ObservableList<Meat> meatObservableList;

    private Button addButton = new Button("Add");
    private Button returnButton = new Button("Return to Menu");

    private Controller controller = Controller.getInstance();
    private Stock stock = Stock.getInstance();

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
        meatCB.getSelectionModel().selectFirst();
        meatHB.getChildren().add(meatCB);
        addToStockVB.getChildren().add(meatHB);

        HBox produceHB = new HBox();
        produceHB.setSpacing(37);
        produceLabel.setFont(new Font("Arial", FONT_SIZE));
        produceHB.getChildren().add(produceLabel);
        produceHB.getChildren().add(produceTF);
        produceTypeCB.getSelectionModel().selectFirst();
        produceHB.getChildren().add(produceTypeCB);
        addToStockVB.getChildren().add(produceHB);

//        HBox errHB = new HBox();
//        errHB.getChildren().add(produceTypeRequiredErr);
//        errHB.getChildren().add(produceTypeErr);
//        produceTypeErr.setTextFill(Color.RED);
//        produceTypeErr.setVisible(false);
//        produceTypeRequiredErr.setTextFill(Color.RED);
//        produceTypeRequiredErr.setVisible(false);
//        addToStockVB.getChildren().add(errHB);

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


        HBox buttonHB = new HBox();
        buttonHB.setSpacing(280);
        buttonHB.getChildren().add(addButton);
        buttonHB.getChildren().add(returnButton);
        addToStockVB.getChildren().add(buttonHB);


        // addToStockVB.getChildren().add(addButton);
        addButton.setOnAction(event -> add());
        returnButton.setOnAction(event -> returnToMenu());

        pane.add(addToStockVB, 1, 1);


        this.setRoot(pane);
    }

    //thinking user should be able to add from each field at once, or separately
    //TODO the "add" button needs to call this event
    private void add() {
        // produceTypeErr.setVisible(false);
        //produceTypeRequiredErr.setVisible(false);
        String name, type;

        if (!(meatCB.getSelectionModel().getSelectedItem() == "Select Type")) {
            type = meatCB.getSelectionModel().getSelectedItem();
            Meat m = new Meat(type);
            //check for dupes
            stock.addToStock(m);
        }
        if (!(produceType.isEmpty())) {
            type = produceTypeCB.getSelectionModel().getSelectedItem();
            //  if(type == null)
            //  produceTypeErr.setVisible(true);
            //produceTypeRequiredErr.setVisible(true);
            //if not null runs this code, get an error because Type is null so need to check for this
            // produceTypeErr.setVisible(type.isEmpty());
            name = produceTF.getText();
            if (!(type.equals("Select Type"))) {
                Produce p = new Produce((type), name);
                stock.addToStock(p);
            }
            //if typeCB was not selected it == null, we want to set a visible error message under the typeCB
            //when the user selects "add" we do not want to clear this field, because it was not added, include in err message

        }
        if (!(dairyTF.getText() == "")) {
            name = dairyTF.getText();
            Ingredient i = new Ingredient("Dairy", name);
            stock.addToStock(i);
        }
        if (!(seasoningTF.getText() == "")) {
            name = seasoningTF.getText();
            Ingredient i = new Ingredient("Seasoning", name);
            stock.addToStock(i);
        }
        if (!(pantryTF.getText() == "")) {
            name = pantryTF.getText();
            Ingredient i = new Ingredient("Pantry", name);
            stock.addToStock(i);
        }

        //clear fields
        Stock.getInstance().saveStock();
        clearInputs();
    }


    private void clearInputs() {

        produceTF.clear();
        dairyTF.clear();
        seasoningTF.clear();
        pantryTF.clear();

        produceTypeCB.getSelectionModel().selectFirst();
        meatCB.getSelectionModel().selectFirst();
    }


    private void returnToMenu() {
        ViewNavigator.loadScene("Nothing To Eat", new MainScene());


    }
}//class
