package by.gsu.asoilab.Models;

import by.gsu.asoilab.Constants.Constants;
import by.gsu.asoilab.Price;

public class Products implements Price {
    private String name;
    private Byn price;

    public Products(String name, Byn price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public Byn getPrice() {
        return price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(Byn price) {
        this.price = price;
    }

    protected String fieldsToString(){
        return  name + Constants.DELIMITER + price;
    }

    @Override
    public String toString() {
        return fieldsToString();
    }
}
