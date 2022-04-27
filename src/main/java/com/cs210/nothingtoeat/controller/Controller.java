package com.cs210.nothingtoeat.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class Controller {

    //our controller theInstance
    private static Controller theInstance;

    //will need our observable lists

    //private constructor
    private Controller(){}

    //getter
    public static Controller getInstance()
    {
        if(theInstance == null)
        {
            theInstance = new Controller();
            //TODO connect theInstance to our observableLists and their Model.populate()
        }

        return theInstance;

    }

    //TODO getters for our observable lists

    //TODO a void save method to write to txt/binary file
    public void saveData(){}


    /*commented out what is different from 112 example
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }*/
}