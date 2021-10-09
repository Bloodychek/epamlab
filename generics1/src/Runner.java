import by.gsu.asoilab.Constants.Constants;
import by.gsu.asoilab.DiscountProduct;
import by.gsu.asoilab.Models.Byn;
import by.gsu.asoilab.Models.Product;
import by.gsu.asoilab.Models.Purchase;
import by.gsu.asoilab.Priceable;
import by.gsu.asoilab.PurchaseUtils;
import by.gsu.asoilab.Service;

import java.util.ArrayList;
import java.util.List;

public class Runner {

    public static void main(String[] args) {
        Purchase p1 = new Purchase(new Product(Constants.MILK, new Byn(170)), 20);
        PurchaseUtils pu1 = new PurchaseUtils(p1);
        pu1.printPurchase();
        pu1.printCost();
        Purchase p2 = new Purchase(new Product(Constants.SUGAR, new Byn(300)), 12.5);
        PurchaseUtils pu2 = new PurchaseUtils(p2);
        pu2.printCost();
        pu2.printCostDiff(p1);
        Purchase p3 = new Purchase(new DiscountProduct(Constants.SUGAR, new Byn(280), new Byn(10)), 60);
        PurchaseUtils pu4 = new PurchaseUtils(new Purchase(new Service(Constants.GYM, new Byn(7560), 5), 2.25));
        Priceable priceable = pu4.getPurchase().getItem();
        System.out.println(priceable);
        pu4.printCost();
        pu2.printlsSameCost(p1, p3, pu4.getPurchase());
    }
}
