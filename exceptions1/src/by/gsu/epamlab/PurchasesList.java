package by.gsu.epamlab;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class PurchasesList {
    private List<Purchase> purchaseList;

    public List<Purchase> getPurchaseList() {
        return purchaseList;
    }

    public void setPurchaseList(List<Purchase> purchaseList) {
        this.purchaseList = purchaseList;
    }

    public PurchasesList() {
        purchaseList = new ArrayList<>();
    }

    public PurchasesList(String fileName) {
        purchaseList = new ArrayList<>();
        String str = "";
        try (Scanner sc = new Scanner(new FileReader(fileName))) {
            while (sc.hasNextLine()) {
                str = sc.nextLine();
                Purchase purchase = PurchasesFactory.purchase(str);
                if (purchase != null) {
                    purchaseList.add(purchase);
                }
            }
        } catch (FileNotFoundException | PurchaseException | CheckStringExceptions | NullExceptions e) {
            System.out.println(e.getMessage());
        }
    }

    public void removePurchase(int index) {
        purchaseList.remove(index);
    }

    public void insertPurchase(int index, Purchase id) {
        if (index != -1) {
            purchaseList.add(index, id);
        }
    }

    public void totalCost() {
        for (Purchase index :
                purchaseList) {
            index.totalCost();
        }
    }

    public void formatPrint() {
        Formatter formatter = new Formatter();
        for (Purchase index :
                purchaseList) {
            formatter.format("%s, %d.%02, %d.%02, %d.%02", index.getName(), index.getPrice(), index.getNumber(), index.totalCost());
        }
    }

    public void Sorting() {
        Collections.sort(purchaseList);
    }

    public int binarySearch(int pos) {
        pos = Collections.binarySearch(purchaseList, new Purchase(null, 0, 5, 0));
        return pos;
    }


}
