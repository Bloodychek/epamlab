package by.gsu.epamlab;

import java.util.Scanner;

public class PercentDiscountPurchase extends Purchase{
    private double percent;
    private final static int COUNT = 15;

    public PercentDiscountPurchase(String name, int price, int number, double percent) {
        super(name, price, number);
        this.percent = percent;
    }

    public PercentDiscountPurchase() {
        this("", 0, 0, 0);
    }

    public PercentDiscountPurchase(Scanner sc) {
        this(sc.next(), sc.nextInt(), sc.nextInt(), sc.nextDouble());
    }

    @Override
    protected String fieldsToString(){
        return super.fieldsToString() + ";" + percent;
    }

    @Override
    public Byn getCost() {
        Byn byn = super.getCost();
        if (super.getNumber() > COUNT) {
            double coef = 1 - percent / 100;
            byn.mul(coef, RoundMethod.ROUND, 0);
        }
        return byn;
    }

    public double getDiscount() {
        return percent;
    }

    public void setDiscount(double discount) {
        this.percent = discount;
    }
}
