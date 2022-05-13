package com.cs210.nothingtoeat.model;

import java.io.Serializable;
import java.util.Objects;

public class Produce implements Serializable {
    private String type;

    public Produce(String type) {
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
        if (!(o instanceof Produce)) return false;
        Produce produce = (Produce) o;
        return Objects.equals(type, produce.type);
    }

    @Override
    public String toString() {
        return "Produce{" +
                "type='" + type + '\'' +
                '}';
    }
}
