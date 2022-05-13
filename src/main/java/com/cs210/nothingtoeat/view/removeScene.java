package com.cs210.nothingtoeat.view;

import com.cs210.nothingtoeat.model.Ingredient;
import com.cs210.nothingtoeat.model.Meat;
import com.cs210.nothingtoeat.model.Produce;
import com.cs210.nothingtoeat.model.Stock;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;

public class removeScene extends Scene{

    //buttons and private fields
    //label/instruction
    Label selectLabel = new Label("Please select the item type to remove");
    //observableList with type that can be removed (produce, meat, dairy, pantry, seasoning)
    ObservableList<String> types = FXCollections.observableArrayList("Select Category", "Meat", "Produce", "Dairy", "Seasoning", "Pantry");
    // comboBox with types
    ComboBox<String> typeCB = new ComboBox<>(types);

    private ObservableList<Ingredient> ingredientList;
    private ObservableList<Meat> meatList;
    private ObservableList<Produce> produceList;

    private Ingredient selectedIngredient;
    private Meat selectedMeat;
    private Produce selectedProduce;

    private ListView<Ingredient> mIngredientListView = new ListView<>();
    private ListView<Meat>  mMeatListView= new ListView<>();
    private ListView<Produce> mProduceListView = new ListView<>();

    //scene method
    public  removeScene(){
        super(new GridPane(), MainScene.WIDTH, MainScene.HEIGHT);
        GridPane pane = new GridPane();
    //todo controller for each list - getAllPanty, getAllMeat, getAllIndgredients...which are to be defined in the contoller class and return the mList neccesary
        //need to set default selection for CB
        typeCB.getSelectionModel().selectFirst();
        //believe we need a listener
       //typeCB.getSelectionModel().selectedItemProperty().addListener((observableValue, oldValue, newValue) -> updateSelectedFood(newValue));
        typeCB.getSelectionModel().selectedItemProperty().addListener((observableValue, oldValue, newValue) -> typeDisplay());
        //need to getSelectionModel to get the choice
        mIngredientListView.setPrefWidth(MainScene.WIDTH/2);
        mProduceListView.setPrefWidth(MainScene.WIDTH/2);
        mMeatListView.setPrefWidth(MainScene.WIDTH/2);

        ingredientList = Stock.getInstance().getAllIngredients();
        mIngredientListView.setItems(ingredientList);

        pane.add(typeCB,2,2);
        pane.add(mIngredientListView, 2,3);
        pane.add(mMeatListView,2,3);
        pane.add(mProduceListView,2,3);


        this.setRoot(pane);
    }

//  private void updateSelectedFood(Object newValue) {
//      if(newValue instanceof Ingredient){
//          Ingredient o = (Ingredient) newValue;
//          selectedIngredient =o;
//      }
//      else if(newValue instanceof Produce){
//          Produce o = (Produce) newValue;
//      }
//      else{
//          Meat o = (Meat) newValue;
//      }
//
//
//  }

    private void typeDisplay() {
      String list = typeCB.getSelectionModel().getSelectedItem();
      Stock.getInstance().populateStock();

      if(list.equals("Meat"))
      {
          mMeatListView.setItems(Stock.getInstance().getAllMeat());


      }
      if(list.equals("Produce"))
      {
          mProduceListView.setItems(Stock.getInstance().getAllProduce());
      }
      else{
          //mIngredientListView.setItems(Stock.getInstance().getAllIngredients());

      }

    }

    private void removeStockItem()
    {
        //if selected type is produce
            //removeFromStock(produce)
        //if selected type is meat
            //removeFromStock(meat)
        //else
            //removeFromStock(ingredient)

        //OR simply removeFromStock(slectedItem) and given the item type the compiler knows which removeFromStock() to use?
    }
}
