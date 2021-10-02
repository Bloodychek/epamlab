package by.gsu.epamlab;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class PurchasesList {
    private List<Purchase> purchaseList;

    public PurchasesList() {
        purchaseList = new ArrayList<>();
    }

    public PurchasesList(String fileName) {
        try (Scanner sc = new Scanner(new FileReader(fileName))) {
            purchaseList = new ArrayList<>();
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                try {
                    purchaseList.add(PurchasesFactory.getPurchaseFromFactory(line));
                } catch (NullPointerException | NonPositivePriceException | NonPositiveNumberException | NonPositiveDiscountException | CsvLineException e) {
                    System.err.println(line + Constants.ARROW + e);
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println(Constants.FILE_NOT_FOUND);
        }
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
        if (index >= 0 && index < purchaseList.size() - 1) {
            purchaseList.remove(index);
        }
    }

    public void insertPurchase(int index, Purchase id) {
        if (index >= 0 && index < purchaseList.size() - 1) {
            purchaseList.add(index, id);
        }
    }

    public Byn getTotalCost() {
        Byn totalCost = new Byn(0);
        for (Purchase purchase : purchaseList) {
            totalCost = totalCost.add(purchase.totalCost());
        }
        return totalCost;
    }

    public void printTable() {
        Formatter formatter = new Formatter();
        System.out.println(formatter.format("%-14s%-10s%-9s%-11s%-8s", " Name", "Price", "Number", "Discount", "Cost"));

        for (Purchase purchase : purchaseList) {
            if (purchase.getDiscount() == null) {
                formatter = new Formatter();
                System.out.println(formatter.format("|%-12s|%-8s|%-8d|-%8s|%-8s|", purchase.getName(),
                        purchase.getPrice(), purchase.getNumber(), " ", purchase.totalCost()));
            } else {
                formatter = new Formatter();
                System.out.println(formatter.format("|%-12s|%-8s|%-8d|%-9s|%-8s|", purchase.getName(),
                        purchase.getPrice().toString(), purchase.getNumber(), purchase.getDiscount(),
                        purchase.totalCost()));
            }
        }
        formatter = new Formatter();
        System.out.println(formatter.format("Total cost " + getTotalCost()));
    }

    public static Comparator<Purchase> createComparator(String name){
        String fullName = Constants.COMPARATORS_PATH + name;
        Comparator<Purchase> comparator = new FirstComparator();
        try {
            Class classComparator = Class.forName(fullName);
            comparator = (Comparator<Purchase>)classComparator.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return comparator;
    }

    public void sort(Comparator<Purchase> comparator) {
        purchaseList.sort(comparator);
    }

    public void binarySearch(Purchase purchase, Comparator<Purchase> comparator) {
        int index = Collections.binarySearch(purchaseList, purchase, comparator);
        System.out.println(Constants.PURCHASE + purchase.fieldsToString()
                + (index < 0 ? Constants.IS_FOUND : Constants.POSITION + index));
    }
}
