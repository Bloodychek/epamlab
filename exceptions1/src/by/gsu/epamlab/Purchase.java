package by.gsu.epamlab;

import java.util.Scanner;

public class Purchase {
    private String name;
    private int number;
    private Byn price;
    private Byn discount;

    public Purchase() {
        this(null, 0, new Byn(0));
    }

    public Purchase(String name, int number, Byn price) {
        this.name = name;
        this.number = number;
        this.price = price;
    }

    public Purchase(Scanner sc) {
        this.name = sc.next();
        this.price = new Byn(sc.nextInt());
        this.number = sc.nextInt();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Byn getPrice() {
        return price;
    }

    public void setPrice(Byn price) {
        this.price = price;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Byn getDiscount() {
        return discount;
    }

    protected String fieldsToString() {
        return name + ";" + price + ";" + number;
    }

    public Byn totalCost() {
        Byn byn = new Byn(price);
        return byn.mul(number);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this)
            return true;
        if (obj == null)
            return false;
        if (!(obj instanceof Purchase))
            return false;
        Purchase objPurchase = (Purchase)obj;
        return name.equals(objPurchase.name)
                && price.equals(objPurchase.price);
    }

    @Override
    public String toString() {
        return fieldsToString() + ";" + totalCost();
    }

}