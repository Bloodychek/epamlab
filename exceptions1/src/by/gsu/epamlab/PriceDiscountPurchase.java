package by.gsu.epamlab;

import java.util.Scanner;

public class PriceDiscountPurchase  extends Purchase {
    private Byn discount;

    public PriceDiscountPurchase(String name, Byn price, int number, Byn discount) {
        super(name, number, price);
        this.discount = discount;
    }

    public PriceDiscountPurchase() {
        this("", null, 0, null);
    }

    public Byn getDiscount() {
        return discount;
    }

    public PriceDiscountPurchase(Scanner sc) {
        super(sc);
        this.discount = new Byn(sc.nextInt());
    }

    @Override
    public Byn totalCost() {
        return super.totalCost().sub(new Byn(discount).mul(getNumber()));
    }

    @Override
    protected String fieldsToString() {
        return super.fieldsToString() +";"+ discount;
    }
}
