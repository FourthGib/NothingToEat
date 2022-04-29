package com.cs210.nothingtoeat.view;

import com.cs210.nothingtoeat.controller.Controller;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.FontWeight;



public class addToStockView extends Scene {

    //declare all buttons/drop-downs, ect

    //list for Meat CB
    ObservableList<String> meatOptions =  FXCollections.observableArrayList( "Beef", "Pork","Poultry", "Fish", "Shell Fish", "Exotic");
    ComboBox<String> meatCB = new ComboBox(meatOptions);

    //TODO List for produce type for produceType CB


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



        HBox addToStockHB = new HBox();
        addToStockHB.setSpacing(15);
        addToStockHB.getChildren().add(new Label("Meat"));
        addToStockHB.getChildren().add(meatCB);
        addToStockHB.getChildren().add(new Label("Produce"));

        addToStockHB.getChildren().add(new Label("Dairy"));

        addToStockHB.getChildren().add(new Label("Seasoning"));

        addToStockHB.getChildren().add(new Label("Pantry"));

        pane.add(addToStockHB,1,1);

        this.setRoot(pane);
    }
}
