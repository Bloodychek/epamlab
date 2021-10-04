package by.gsu.epamlab.comparators;

import by.gsu.epamlab.beans.Constants;
import by.gsu.epamlab.models.Purchase;

import java.util.Comparator;

public class PurchaseComparatorBuilder {
    private static Comparator<Purchase> purchaseComparator;
    private PurchaseComparatorBuilder() {
    }
    public static Comparator<Purchase> getPurchaseComparator() {
        return purchaseComparator;
    }

    public static void buildPurchaseComparator(String comparatorName) {
        if(purchaseComparator != null) {
            return;
        }
        String fullName = Constants.COMPARATORS_PATH + comparatorName;
        try {
            Class classComparator = Class.forName(fullName);
            purchaseComparator = (Comparator<Purchase>)classComparator.newInstance();
        } catch (Exception e) {
            purchaseComparator = new FirstComparator();
        }
    }
}

