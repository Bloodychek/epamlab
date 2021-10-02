import by.gsu.epamlab.*;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Runner {

    public static void main(String[] args){
        final String in = args[0];
        final String addon = args[1];
        PurchasesList purchasesList = new PurchasesList(in);
        purchasesList.printTable();
        PurchasesList extralist = new PurchasesList(addon);
        System.out.println(Constants.AFTER_CREATION);
        purchasesList.insertPurchase(0, extralist.getLastPurchase());
        purchasesList.insertPurchase(1000, extralist.getPurchaseList().get(0));
        purchasesList.insertPurchase(2, extralist.getPurchaseList().get(2));
        purchasesList.removePurchase(3);
        purchasesList.removePurchase(10);
        purchasesList.removePurchase(-5);
        System.out.println(Constants.BEFORE_SORTING);
        purchasesList.printTable();
        Comparator<Purchase> comparator = PurchasesList.createComparator(args[2]);
        purchasesList.sort(comparator);
        System.out.println(Constants.AFTER_SORTING);
        purchasesList.printTable();
        System.out.println(Constants.SEARCH_RESULT);
        purchasesList.binarySearch(purchasesList.getPurchase(1), comparator);
        purchasesList.binarySearch(purchasesList.getPurchase(3), comparator);
    }
}
