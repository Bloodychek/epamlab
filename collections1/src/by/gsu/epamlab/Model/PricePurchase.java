package by.gsu.epamlab.Model;

import by.gsu.epamlab.Beans.Constants;
import by.gsu.epamlab.Model.Byn;
import by.gsu.epamlab.Model.Purchase;

import java.util.Scanner;

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

    public PricePurchase() {
        this("", 0, 0, null);
    }

    public PricePurchase(Scanner sc) {
        this(sc.next(), sc.nextInt(), sc.nextInt(), new Byn(sc.nextInt()));
    }

    public Byn getDiscount() {
        return discount;
    }

    public void setDiscount(Byn discount) {
        this.discount = discount;
    }

    @Override
    protected String fieldsToString() {
        return super.fieldsToString() + Constants.DELIMITER + discount;
    }

    @Override
    public Byn getCost() {
        return super.getCost().sub(new Byn(discount).mul(getNumber()));
    }
}
