import by.gsu.epamlab.*;

import java.util.Arrays;

public class Runner {

    public static void main(String[] args) {
        final Product product = new Product("Milk", new Byn(100));

        AbstractPurchase[] abstractPurchases = {
                new UnitPurchase(5, product, 0),
                new UnitPurchase(166, product, 3),
                new PercentPurchase(10, product, 66.6),
                new PercentPurchase(6666, product, 66.6),
                new TransportPurchase(77, product, 43544),
                new TransportPurchase(2, product, 76)
        };

        printArray(abstractPurchases);

        Arrays.sort(abstractPurchases);

        printArray(abstractPurchases);

        System.out.println(abstractPurchases[abstractPurchases.length - 1].getCost());

        int id = Arrays.binarySearch(abstractPurchases, new UnitPurchase(5, product, 0));
        if(id == 5){
            System.out.println("Required purchase is found: " + abstractPurchases[id]);
        }
        else{
            System.out.println("Required purchase is not found");
        }
    }

    private static void printArray(AbstractPurchase[] abstratPurchases){
        for (AbstractPurchase abs:
             abstratPurchases) {
            System.out.println(abs);
        }
    }
}
