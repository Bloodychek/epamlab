package by.gsu.asoilab;

import by.gsu.asoilab.Constants.Constants;
import by.gsu.asoilab.Models.Byn;
import by.gsu.asoilab.Models.Products;

public class DiscountProduct extends Products {
    private Byn discount;

    public DiscountProduct(String name, Byn price, Byn discount) {
        super(name, price);
        this.discount = discount;
    }

    public DiscountProduct(){
        this("", new Byn(0), new Byn(0));
    }

    public Byn getDiscount() {
        return discount;
    }

    @Override
    public String toString() {
        return fieldsToString() + Constants.DELIMITER + discount;
    }
}
