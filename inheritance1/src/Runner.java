import by.gsu.epamlab.Purchase;
import by.gsu.epamlab.PurchasesFactory;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Locale;
import java.util.Scanner;

public class Runner {

    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(new FileReader("src/in.txt"));
            sc.useLocale(Locale.ENGLISH);
            final int PURCHASE = 6;
            Purchase[] purchases = new Purchase[PURCHASE];
            Purchase purchasesMax = new Purchase();

            int id = 0;
            for (int i = 0; i < PURCHASE; ++i) {
                Purchase purchase = PurchasesFactory.getPurchasesFromFactory(sc);
                purchases[i] = purchase;

                if(purchases[i].getCost().compareTo(purchasesMax.getCost()) > 0){
                    purchasesMax = purchases[i];
                }

                System.out.println(purchases[i]);
                if (purchases[i].equals(purchases[0])){
                    id++;
                }
            }

            System.out.println("Max cost = " + purchasesMax);

            if(id == purchases.length){
                System.out.println(true);
            }
            else {
                System.out.println(false);
            }

        } catch (FileNotFoundException e) {
            System.err.println("Input file is not found");
        }
    }
}
