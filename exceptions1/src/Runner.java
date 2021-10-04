import by.gsu.epamlab.beans.Constants;
import by.gsu.epamlab.beans.PurchasesList;
import by.gsu.epamlab.comparators.PurchaseComparatorBuilder;
import by.gsu.epamlab.models.Purchase;

public class Runner {

    public static void main(String[] args){
        if (args.length == 3)
        {
            final String in = args[0];
            final String addon = args[1];
            PurchaseComparatorBuilder.buildPurchaseComparator(args[2]);
            PurchasesList purchasesList = new PurchasesList(in);
            System.out.println(Constants.AFTER_CREATION);
            printTable(purchasesList);
            PurchasesList extralist = new PurchasesList(addon);
            purchasesList.insertPurchase(0, extralist.getLastPurchase());
            purchasesList.insertPurchase(1000, extralist.getPurchaseList().get(0));
            purchasesList.insertPurchase(2, extralist.getPurchaseList().get(2));
            deleteElement(purchasesList, 3);
            deleteElement(purchasesList, 10);
            deleteElement(purchasesList, -5);
            System.out.println(Constants.BEFORE_SORTING);
            printTable(purchasesList);
            purchasesList.sort();
            System.out.println(Constants.AFTER_SORTING);
            printTable(purchasesList);
            System.out.println(Constants.SEARCH_RESULT);
            printSearch(purchasesList, extralist.getPurchase(1));
            printSearch(purchasesList, extralist.getPurchase(3));
        }
        else {
            System.out.println(Constants.INCORRECT_AMOUNT_ARGUMENTS);
        }
    }

    private static void printTable(PurchasesList purchases){
        purchases.printTable();
    }

    private static void deleteElement(PurchasesList purchases, int index){
        purchases.removePurchase(index);
    }

    private static void printSearch(PurchasesList purchases, Purchase purchase){
        System.out.println(purchases.searchPurchase(purchase));
    }
}
