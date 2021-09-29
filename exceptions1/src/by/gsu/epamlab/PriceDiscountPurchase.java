package by.gsu.epamlab;

import java.util.Scanner;

public class PriceDiscountPurchase extends Purchase{
    private Byn discount;

    public PriceDiscountPurchase(String name, int price, int number, Byn discount, double cost) {
        super(name, price, number, cost);
        this.discount = discount;
    }

    public PriceDiscountPurchase(String name, int price, int number, int discount, double cost){
        super(name, price, number, cost);
        this.discount = new Byn(discount);
    }

    public PriceDiscountPurchase(){
        this("", 0, 0, 0, 0.0);
    }

    public PriceDiscountPurchase(Scanner sc){
        this(sc.next(), sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt());
    }

    public Byn getDiscount() {
        return discount;
    }

    public void setDiscount(Byn discount) {
        this.discount = discount;
    }

    @Override
    public Byn totalCost(){
        return super.totalCost().sub(new Byn(discount).mul(getNumber()));
    }

    @Override
    protected String fieldsToString(){
        return super.fieldsToString() + ";" + discount;
    }
}
