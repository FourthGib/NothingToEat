package com.cs210.nothingtoeat.model;

import java.io.Serializable;
import java.util.Objects;

public class Produce implements Serializable {

    private String name;
    private String type;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Produce(String type, String name) {
        this.type = type;
        this.name = name;
    }

    public String getType() {
        return type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, name);
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Produce)) return false;
        Produce produce = (Produce) o;
        return type.equals(produce.type) && name.equals(produce.name);
    }

    @Override
    public String toString() {
        return "Produce{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
