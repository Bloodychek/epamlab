package by.gsu.epamlab.model;

import by.gsu.epamlab.Constants;

public class PricePurchase extends Purchase {
    private Byn discount;

    public PricePurchase(String name, int price, int number, Byn discount) {
        super(name, price, number);
        this.discount = discount;
    }

    public PricePurchase(String name, int price, int number, int discount) {
        super(name, price, number);
        this.discount = new Byn(discount);
    }

    @Override
    protected String fieldsToString() {
        return super.fieldsToString() + Constants.DELIMITER + discount;
    }

    @Override
    public Byn getCost() {
        return super.getCost().sub(discount.mul(getNumber()));
    }
}
