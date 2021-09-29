package by.gsu.epamlab;

import java.util.Comparator;

public abstract class FirstComparator implements Comparator<Purchase> {
    @Override
    public int compare(Purchase o1, Purchase o2) {
        if(!(o1 instanceof PriceDiscountPurchase))
            return 0;
        return 0;
    }
}
