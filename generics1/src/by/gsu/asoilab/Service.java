package by.gsu.asoilab;

import by.gsu.asoilab.Constants.Constants;
import by.gsu.asoilab.Models.Byn;

public class Service implements Priceable {
    private String name;
    private Byn totalCost;
    private int number;

    public Service(String name, Byn totalCost, int number) {
        this.name = name;
        this.totalCost = totalCost;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public Byn getTotalCost() {
        return totalCost;
    }

    public int getNumber() {
        return number;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTotalCost(Byn totalCost) {
        this.totalCost = totalCost;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Byn getPrice(){
        return totalCost.mul(1.0 / number, RoundMethod.CEIL, 0);
    }

    @Override
    public String toString() {
        return name + Constants.DELIMITER + totalCost + Constants.DELIMITER + number + Constants.DELIMITER + getPrice();
    }
}
