package com.cs210.nothingtoeat;

public class Meat {
    private String type;    //chicken, beef, fish

    public Meat(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Meat)) return false;
        Meat meat = (Meat) o;
        return type.equals(meat.type);
    }
}
