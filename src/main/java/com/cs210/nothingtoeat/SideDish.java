package com.cs210.nothingtoeat;
import java.util.*;

public class SideDish extends Dish{

    private Produce produceType;

    SideDish(String name, ArrayList<Ingredient> ingredients, Produce produceType){
        super(name, ingredients);
        this.produceType = produceType;
    }

    public Produce getProduceType() {
        return produceType;
    }

    public void setProduceType(Produce produceType) {
        this.produceType = produceType;
    }
}
