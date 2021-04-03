package by.gsu.epamlab;

import java.util.Scanner;

public class PurchasesFactory {
    private enum PurchaseKind{
        PURCHASE,
        PRICE_DISCOUNT_PURCHASE,
        PERCENT_DISCOUNT_PURCHASE
    }

    public static Purchase getPurchasesFromFactory(Scanner sc){
        String id = sc.next();
        PurchaseKind kind = PurchaseKind.valueOf(id);
        switch (kind){
            case PURCHASE:
                return new Purchase(sc);
            case PRICE_DISCOUNT_PURCHASE:
                return new PriceDiscountPurchase(sc);
            case PERCENT_DISCOUNT_PURCHASE:
                return new PercentDiscountPurchase(sc);
            default:
                throw new IllegalArgumentException();
        }
    }
}
