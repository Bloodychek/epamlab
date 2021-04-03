package by.gsu.epamlab;

import java.util.Scanner;

public class PercentDiscountPurchase extends Purchase{
    private double discount;
    private final static int COUNT = 30;

    public PercentDiscountPurchase(String name, int price, int number, double discount) {
        super(name, price, number);
        this.discount = discount;
    }

    public PercentDiscountPurchase() {
        this("", 0, 0, 0);
    }

    public PercentDiscountPurchase(Scanner sc) {
        this(sc.next(), sc.nextInt(), sc.nextInt(), sc.nextDouble());
    }

    @Override
    protected String fieldsToString(){
        return super.fieldsToString() + ";" + discount;
    }

    @Override
    public Byn getCost(){
        if(super.getNumber() > COUNT){
            double coef = 1 - discount / 100;
            return super.getCost().mul(coef);
        }
        else
            return super.getCost();
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }
}
