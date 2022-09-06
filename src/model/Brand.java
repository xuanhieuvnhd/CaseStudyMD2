package model;

import java.io.Serializable;

public class Brand implements Serializable {
    private String name;

    public Brand() {
    }


    public Brand(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return
                "Ten hang: " + name;
    }
}
