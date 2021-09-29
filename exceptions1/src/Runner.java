import by.gsu.epamlab.FirstComparator;
import by.gsu.epamlab.PurchasesList;
import by.gsu.epamlab.SecondComparator;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Collections;
import java.util.Scanner;

public class Runner {

    public static void main(String[] args) {
        final String IN_CSV = "src/in.csv";
        final String ADDON_CSV = "src/addon.csv";

        PurchasesList purchasesList = new PurchasesList(IN_CSV);
        PurchasesList newPurchasesList = new PurchasesList(ADDON_CSV);

        purchasesList.formatPrint();
        purchasesList.insertPurchase(0, newPurchasesList.getPurchaseList().get(newPurchasesList.getPurchaseList().size()-1));
        purchasesList.insertPurchase(1000, newPurchasesList.getPurchaseList().get(0));
        purchasesList.insertPurchase(1, newPurchasesList.getPurchaseList().get(1));
        purchasesList.removePurchase(3);
        purchasesList.removePurchase(10);
        purchasesList.removePurchase(-5);
        purchasesList.formatPrint();
        purchasesList.Sorting();
        purchasesList.formatPrint();
        int rez1 = purchasesList.binarySearch(1);
        int rez2 = purchasesList.binarySearch(3);
        System.out.println(rez1 + ";" + rez2);
    }
}
