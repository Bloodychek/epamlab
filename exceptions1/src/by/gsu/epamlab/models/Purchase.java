package by.gsu.epamlab.models;

import by.gsu.epamlab.beans.Constants;
import by.gsu.epamlab.enums.NumField;
import by.gsu.epamlab.exceptions.NonPositiveArgumentException;

import java.util.Scanner;

public class Purchase {
    private String name;
    private int number;
    private Byn price;
    private Byn discount;

    public Purchase(String name, Byn price, int number) {
        setName(name);
        setPrice(price);
        setNumber(number);
    }

    public Purchase(String name, int price, int number) {
        this(name, new Byn(price), number);
    }

    public Purchase() {
        this("", new Byn(0), 0);
    }

    public Purchase(Scanner sc) {
        this.name = sc.next();
        this.number = sc.nextInt();
        this.price = new Byn(sc.nextInt());
    }

    public String getName() {
        return name;
    }

    public final void setName(String name) {
        this.name = name;
    }

    public Byn getPrice() {
        return price;
    }

    public final void setPrice(Byn price) {
        this.price = price;
    }

    public int getNumber() {
        return number;
    }

    public final void setNumber(int number) {
        this.number = number;
    }

    public Byn getDiscount() {
        return discount;
    }

    public String fieldsToString() {
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
        Purchase objPurchase = (Purchase) obj;
        return name.equals(objPurchase.name)
                && price.equals(objPurchase.price);
    }

    @Override
    public String toString() {
        return fieldsToString() + Constants.DELIMITER + totalCost();
    }

}