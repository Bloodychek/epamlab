package by.gsu.asoilab.Models;

import by.gsu.asoilab.Constants.Constants;
import by.gsu.asoilab.Priceable;
import by.gsu.asoilab.RoundMethod;

public class Purchase<T extends Priceable, N extends Number> {
    private T item;
    private N quantity;

    public Purchase(T item, N quantity) {
        this.item = item;
        this.quantity = quantity;
    }

    public T getItem() {
        return item;
    }

    public void setItem(T item) {
        this.item = item;
    }

    public N getQuantity() {
        return quantity;
    }

    public void setQuantity(N quantity) {
        this.quantity = quantity;
    }

    public Byn getCost() {
        return item.getPrice().mul(quantity.doubleValue(), RoundMethod.ROUND, 0);
    }

    @Override
    public String toString() {
        return item + Constants.DELIMITER + quantity + Constants.DELIMITER + getCost();
    }
}