package by.gsu.epamlab.Beans;

import by.gsu.epamlab.Model.PricePurchase;
import by.gsu.epamlab.Model.Purchase;

import java.util.Scanner;

public class PurchaseFactory {
    public static Purchase getPurchaseFromFactory(Scanner sc) {

        String[] elements = sc.nextLine().split(Constants.DELIMITER);
        int count = elements.length;
        Purchase purchase;
        if (count == 3) {
            purchase = new Purchase(elements[0], Integer.parseInt(elements[1]), Integer.parseInt(elements[2]));
        } else {
            purchase = new PricePurchase(elements[0], Integer.parseInt(elements[1]), Integer.parseInt(elements[2]), Integer.parseInt(elements[3]));
        }
        return purchase;
    }
}