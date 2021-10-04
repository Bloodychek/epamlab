package by.gsu.epamlab.models;

import by.gsu.epamlab.beans.Constants;
import by.gsu.epamlab.enums.NumField;
import by.gsu.epamlab.exceptions.NonPositiveArgumentException;
import by.gsu.epamlab.exceptions.WrongDate;

import java.util.Scanner;

public class PriceDiscountPurchase extends Purchase {
    private Byn discount;

    public PriceDiscountPurchase(String name, Byn price, int number, Byn discount) {
        super(name, price, number);
        setDiscount(discount);
    }

    public PriceDiscountPurchase(String name, int price, int number, int discount) {
        this(name, new Byn(price), number, new Byn(discount));
    }

    public PriceDiscountPurchase() {
        this("", null, 0, null);
    }

    public Byn getDiscount() {
        return discount;
    }

    public final void setDiscount(Byn discount) {
        this.discount = discount;
    }

    @Override
    public Byn totalCost() {
        return super.totalCost().sub(new Byn(discount).mul(getNumber()));
    }

    @Override
    public String fieldsToString() {
        return super.fieldsToString() + Constants.DELIMITER + discount;
    }
}
