import by.gsu.asoilab.DiscountProduct;
import by.gsu.asoilab.Models.Byn;
import by.gsu.asoilab.Models.Products;
import by.gsu.asoilab.Models.Purchase;
import by.gsu.asoilab.PurchaseUtils;
import by.gsu.asoilab.Service;

import java.util.ArrayList;
import java.util.List;

public class Runner {

    public static void main(String[] args) {
        Purchase p1 = new Purchase(new Products("Milk", new Byn(170)), 20);
        PurchaseUtils pu1 = new PurchaseUtils(p1);
        pu1.printPurchase();
        pu1.printCost();
        Purchase p2 = new Purchase(new Products("Sugar", new Byn(300)), 12.5);
        PurchaseUtils pu2 = new PurchaseUtils(p2);
        pu2.printCost();
        pu2.printCostDiff(p1);
        Purchase p3 = new Purchase(new DiscountProduct("Sugar", new Byn(280), new Byn(10)), 60);
        PurchaseUtils pu4 = new PurchaseUtils(new Purchase(new Service("gym", new Byn(7560), 5), 2.25));
        System.out.println(pu4.getPurchase());
        pu4.printCost();
        List<Purchase> purchases = new ArrayList<>();
        purchases.add(p1);
        purchases.add(p2);
        purchases.add(p3);
        pu2.printlsSameCost(purchases);
    }
}
