package by.gsu.asoilab;

import by.gsu.asoilab.Constants.Constants;
import by.gsu.asoilab.Models.Byn;
import by.gsu.asoilab.Models.Purchase;

import java.util.List;

public class PurchaseUtils<T extends Priceable, N extends Number> {
    private Purchase<T, N> purchase;

    public PurchaseUtils(Purchase<T, N> purchase){
        this.purchase = purchase;
    }

    public Purchase<T, N> getPurchase() {
        return purchase;
    }
    public void printPurchase() {
        System.out.println(purchase);
    }

    public void printCost() {
        System.out.println(Constants.COST + purchase.getCost() + Constants.BYN);
    }

    public void printCostDiff(Purchase<? extends Priceable, ? extends Number> p) {
        Byn greaterCost = new Byn();
        Byn lesserCost = new Byn();
        int diffCompare = purchase.getCost().compareTo(p.getCost());
        String costDiff = Constants.EMPTY;
        if (diffCompare > 0) {
            greaterCost = purchase.getCost();
            lesserCost = p.getCost();
            costDiff += Constants.POSITIVE;
        } else if (diffCompare < 0) {
            greaterCost = p.getCost();
            lesserCost = purchase.getCost();
            costDiff += Constants.NEGATIVE;
        }
        costDiff += greaterCost.sub(lesserCost) + Constants.BYN;
        System.out.println(costDiff);
    }

    public void printlsSameCost(Purchase<?, ?>... purchases) {
        boolean flag = false;
        for (Purchase<? extends Priceable, ? extends Number> p : purchases) {
            if (purchase.getCost().equals(p.getCost())) {
                System.out.println(Constants.PURCHASE_SAME_COST + getPurchase());
                flag = true;
                break;
            }
        }
        System.out.println(flag);
    }
}
