package by.gsu.epamlab.beans;

import by.gsu.epamlab.comparators.PurchaseComparatorBuilder;
import by.gsu.epamlab.exceptions.*;
import by.gsu.epamlab.models.Byn;
import by.gsu.epamlab.models.Purchase;
import by.gsu.epamlab.comparators.FirstComparator;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class PurchasesList {
    private List<Purchase> purchaseList;

    public PurchasesList() {
        purchaseList = new ArrayList<>();
    }

    private boolean isSorted = false;

    public PurchasesList(String fileName) {
        final String PACKAGE = "src/";
        final String EXT = ".csv";
        final String FILE_PATH = PACKAGE + fileName + EXT;
        try (Scanner sc = new Scanner(new FileReader(FILE_PATH))) {
            purchaseList = new ArrayList<>();
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                try {
                    purchaseList.add(PurchasesFactory.getPurchaseFromFactory(line));
                } catch (CsvLineException e) {
                    System.err.println(line + Constants.ARROW + e);
                }
            }
        } catch (IOException e) {
            System.out.println(e);
            purchaseList = new ArrayList<>();
        }
    }

    public boolean isIndexCorrect(int index) {
        boolean isCorrect = true;
        if (index > purchaseList.size() || index < 0){
            isCorrect = false;
        }
        return isCorrect;
    }

    public List<Purchase> getPurchaseList() {
        return purchaseList;
    }

    public void setPurchase(List<Purchase> purchaseList) {
        this.purchaseList = purchaseList;
    }

    public Purchase getLastPurchase() {
        return purchaseList.get(purchaseList.size() - 1);
    }

    public Purchase getPurchase(int index) {
        return purchaseList.get(index);
    }

    public void removePurchase(int index) {
        if (isIndexCorrect(index)) {
            purchaseList.remove(index);
        }
        isSorted = false;
    }

    public void insertPurchase(int index, Purchase id) {
        if (isIndexCorrect(index)) {
            purchaseList.add(index, id);
        }
        isSorted = false;
    }

    public Byn getTotalCost() {
        Byn totalCost = new Byn();
        for (Purchase purchase : purchaseList) {
            totalCost = totalCost.add(purchase.totalCost());
        }
        return totalCost;
    }

    public void printTable() {
        Formatter formatter = new Formatter();
        System.out.println(formatter.format(Constants.TABLE_HEAD));

        for (Purchase purchase : purchaseList) {
            if (purchase.getDiscount() == null) {
                formatter = new Formatter();
                System.out.println(formatter.format(Constants.TABLE_ROW1, purchase.getName(),
                        purchase.getPrice(), purchase.getNumber(), Constants.EMPTY, purchase.totalCost()));
            } else {
                formatter = new Formatter();
                System.out.println(formatter.format(Constants.TABLE_ROW2, purchase.getName(),
                        purchase.getPrice().toString(), purchase.getNumber(), purchase.getDiscount(),
                        purchase.totalCost()));
            }
        }
        formatter = new Formatter();
        System.out.println(formatter.format(Constants.TOTAL_COST + getTotalCost()));
    }

    public void sort() {
        purchaseList.sort(PurchaseComparatorBuilder.getPurchaseComparator());
        isSorted = true;
    }

    public String searchPurchase(Purchase purchase) {
        if (!isSorted) {
            sort();
        }
        int index = Collections.binarySearch(purchaseList, purchase, PurchaseComparatorBuilder.getPurchaseComparator());
        return Constants.PURCHASE + purchase.fieldsToString() + (index < 0 ? Constants.IS_FOUND : Constants.POSITION + index);
    }
}
