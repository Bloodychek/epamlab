import by.gsu.epamlab.*;

import java.util.Arrays;

public class Runner {

    public static void main(String[] args) {
        final Product product = new Product("Milk", new Byn(100));

        AbstractPurchase[] purchases = {
                new UnitPurchase(5, product, 0),
                new UnitPurchase(166, product, 3),
                new PercentPurchase(10, product, 66.6),
                new PercentPurchase(6666, product, 66.6),
                new TransportPurchase(77, product, 43544),
                new TransportPurchase(2, product, 76)
        };

        printArray(purchases);

        Arrays.sort(purchases);

        printArray(purchases);

        System.out.println(purchases[purchases.length - 1].getCost());

        int pos = Arrays.binarySearch(purchases, new UnitPurchase(5, product, 0));
        System.out.println("Purchase with cost in 5 BYN is " + (pos < 0 ? "not found" : purchases[pos]));
    }

    private static void printArray(AbstractPurchase[] purchases){
        for (AbstractPurchase abs:
                purchases) {
            System.out.println(abs);
        }
    }
}
