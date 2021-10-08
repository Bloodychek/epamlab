package by.gsu.asoilab.Models;

import by.gsu.asoilab.Constants.Constants;
import by.gsu.asoilab.Price;
import by.gsu.asoilab.RoundMethod;

public class Purchase{
    private Price item;
    private double quantity;

    public Purchase(Price item, double quantity){
        this.item = item;
        this.quantity = quantity;
    }

    public Price getItem() {
        return item;
    }

    public void setItem(Price item) {
        this.item = item;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public Byn getCost(){
        return item.getPrice().mul(quantity, RoundMethod.ROUND, 2);
    }

    @Override
    public String toString() {
        return item + Constants.DELIMITER + quantity;
    }
}