package by.gsu.epamlab;

import java.util.Comparator;

public class FirstComparator implements Comparator<Purchase> {
    @Override
    public int compare(Purchase o1, Purchase o2) {
        if (o1.getName().equals(o2.getName())) {
            boolean purchase1 = o1 instanceof PriceDiscountPurchase;
            boolean purchase2 = o2 instanceof PriceDiscountPurchase;

            if (purchase1 && purchase2 || !purchase1 && !purchase2) {
                return o1.totalCost().compareTo(o2.totalCost());
            } else if (purchase1) {
                return 1;
            } else {
                return -1;
            }
        }
        return o1.getName().compareTo(o2.getName());
    }
}