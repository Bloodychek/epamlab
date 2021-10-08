package by.gsu.asoilab;

import by.gsu.asoilab.Constants.Constants;
import by.gsu.asoilab.Models.Byn;
import by.gsu.asoilab.Models.Purchase;

import java.util.List;

public class PurchaseUtils {
    private Purchase purchase;

    public PurchaseUtils(Purchase purchase) {
        this.purchase = purchase;
    }

    public Purchase getPurchase() {
        return purchase;
    }

    public void printPurchase() {
        System.out.println(purchase);
    }

    public void printCost() {
        System.out.println(Constants.COST + purchase.getCost() + Constants.BYN);
    }

    public void printCostDiff(Purchase p) {
        Byn costDiff = purchase.getCost().sub(p.getCost());
        int diffCompare = purchase.getCost().compareTo(p.getCost());
        if (diffCompare > 0) {
            System.out.println(Constants.POSITIVE + costDiff);
        } else if (diffCompare < 0) {
            System.out.println(Constants.NEGATIVE + costDiff);
        } else if (diffCompare == 0) {
            System.out.println(Constants.EMPTY + costDiff);
        }
    }

    public void printlsSameCost(List<Purchase> purchases) {
        for (Purchase p : purchases) {
            if (purchase.getCost().equals(p.getCost())) {
                System.out.println(Constants.PURCHASE_SAME_COST + getPurchase());
            }
        }
    }
}
