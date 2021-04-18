package by.gsu.epamlab;

import java.util.Scanner;

public class PriceDiscountPurchase extends Purchase{
    private Byn discount;

    public PriceDiscountPurchase(String name, int price, int number, Byn discount) {
        super(name, price, number);
        this.discount = discount;
    }

    public PriceDiscountPurchase(String name, int price, int number, int discount){
        super(name, price, number);
        this.discount = new Byn(discount);
    }

    public PriceDiscountPurchase() {
        this("", 0, 0, null);
    }

    public PriceDiscountPurchase(Scanner sc) {
        this(sc.next(), sc.nextInt(), sc.nextInt(), new Byn(sc.nextInt()));
    }

    @Override
    protected String fieldsToString(){
        return super.fieldsToString() + ";" + discount;
    }

    @Override
    public Byn getCost(){
        return super.getCost().sub(new Byn(discount).mul(getNumber()));
    }

    public Byn getDiscount() {
        return discount;
    }

    public void setDiscount(Byn discount) {
        this.discount = discount;
    }
}
