package by.gsu.asoilab.Models;

import by.gsu.asoilab.Constants.Constants;
import by.gsu.asoilab.Priceable;
import by.gsu.asoilab.RoundMethod;

public class Purchase{
    private Priceable item;
    private Number quantity;

    public Purchase(Priceable item, Number quantity){
        this.item = item;
        this.quantity = quantity;
    }

    public Priceable getItem() {
        return item;
    }

    public void setItem(Priceable item) {
        this.item = item;
    }

    public Number getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public Byn getCost(){
        return item.getPrice().mul(quantity.doubleValue(), RoundMethod.ROUND, 0);
    }

    @Override
    public String toString() {
        return item + Constants.DELIMITER + quantity + Constants.DELIMITER + getCost();
    }
}