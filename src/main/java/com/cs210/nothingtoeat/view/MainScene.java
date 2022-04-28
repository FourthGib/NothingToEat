package com.cs210.nothingtoeat.view;

//import com.example.food.controller.Controller;
//import com.example.food.model.Food;
//import com.example.food.model.Meat;
//import com.example.food.model.Pantry;
//import com.example.food.model.Recipe;
import com.cs210.nothingtoeat.controller.Controller;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.CubicCurve;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class MainScene extends Scene {
    //TODO all our private variables whihc include the size of the frame, any image, textField,
    // label, box ListView, Button...
    public static final int WIDTH = 600;
    public static final int HEIGHT = 700;
    public static final double BUTTON_WIDTH = 155;
    public static final double BUTTON_HEIGHT = 55;
    public static final FontWeight BOLD_FONT = FontWeight.BOLD;

    private Label title = new Label("\tNothing to Eat!");

    //main page button selection
    private Button addToStock = new Button("Add to Stock");
    private Button removeFromStock = new Button("Remove from Stock");
    private Button generateFromStock = new Button("Generate from Stock");
    private Button generateShoppingList = new Button("Generate Shopping List");
    private Button addRecipe = new Button("Add Recipe");
    private Button viewMyStock = new Button("View My Stock");



    //note, when asked to import, imported ours not Java's Controller class
    private Controller mController = Controller.getInstance();

    public MainScene(){
        super(new GridPane(), WIDTH, HEIGHT);
        GridPane pane = new GridPane();

        //center what appears on the grid with Row and Column Constraints
        RowConstraints row1 = new RowConstraints();
        row1.setPrefHeight(25);
        pane.getRowConstraints().add(row1);
        ColumnConstraints colC = new ColumnConstraints();
        colC.setHalignment(HPos.CENTER);
        pane.getColumnConstraints().add(colC);
        pane.setAlignment(Pos.CENTER);

        //6 buttons - addToStock, removeFromStock, generateFromStock, generateShoppingList, addRecipe, myStock
        //stored in a VBox all with the same WIDTH and HEIGHT
        //TODO: find way to make title bold, larger and centered


        addToStock.setPrefWidth(BUTTON_WIDTH);
        addToStock.setPrefHeight(BUTTON_HEIGHT);
        addToStock.setStyle("-fx-background-color: #fdf0ca; -fx-border-color: BLACK ");

        removeFromStock.setPrefWidth(BUTTON_WIDTH);
        removeFromStock.setPrefHeight(BUTTON_HEIGHT);
        removeFromStock.setStyle("-fx-background-color: #f6ccca; -fx-border-color: BLACK");

        generateFromStock.setPrefWidth(BUTTON_WIDTH);
        generateFromStock.setPrefHeight(BUTTON_HEIGHT);
        generateFromStock.setStyle("-fx-background-color: #d8e6fa; -fx-border-color: BLACK");

        generateShoppingList.setPrefWidth(BUTTON_WIDTH);
        generateShoppingList.setPrefHeight(BUTTON_HEIGHT);
        generateShoppingList.setStyle("-fx-background-color: #d3e6d2; -fx-border-color: BLACK");

        addRecipe.setPrefHeight(BUTTON_HEIGHT);
        addRecipe.setPrefWidth(BUTTON_WIDTH);
        addRecipe.setStyle("-fx-background-color: #dfd3e5; -fx-border-color: BLACK");

        viewMyStock.setPrefWidth(BUTTON_WIDTH);
        viewMyStock.setPrefHeight(BUTTON_HEIGHT);
        viewMyStock.setStyle("-fx-background-color: #fde4ca; -fx-border-color: BLACK");

        VBox mainButtonSelectionHB = new VBox();
        mainButtonSelectionHB.setSpacing(15);
        mainButtonSelectionHB.getChildren().add(title);
        mainButtonSelectionHB.getChildren().add(addToStock);
        mainButtonSelectionHB.getChildren().add(removeFromStock);
        mainButtonSelectionHB.getChildren().add(generateFromStock);
        mainButtonSelectionHB.getChildren().add(generateShoppingList);
        mainButtonSelectionHB.getChildren().add(addRecipe);
        mainButtonSelectionHB.getChildren().add(viewMyStock);
        //oddly if we change the 1,1 to 0,0 is removes our button sizes
        pane.add(mainButtonSelectionHB, 1,1);


        //dont remove
        this.setRoot(pane);
    }
}
