package com.cs210.nothingtoeat.model;

import java.io.Serializable;

public class Ingredient implements Serializable {
    private String type; //dairy, seasoning, pantry
    private String name;

    public Ingredient(String type, String name) {
        this.type = type;
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
