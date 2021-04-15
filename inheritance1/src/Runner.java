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
            final int PURCHASE_NUMBER = 6;
            Purchase[] purchases = new Purchase[PURCHASE_NUMBER];
            Purchase purchasesMax = new Purchase();

            int id = 0;
            boolean areEqual = true;
            for (int i = 0; i < PURCHASE_NUMBER; i++) {
                Purchase purchase = PurchasesFactory.getPurchasesFromFactory(sc);
                purchases[i] = purchase;

                if(purchases[i].getCost().compareTo(purchasesMax.getCost()) > 0){
                    purchasesMax = purchases[i];
                }

                System.out.println(purchases[i]);

                if(areEqual){
                    areEqual = purchases[i].equals(purchases[0]);
                }
            }

            System.out.println(areEqual);

            System.out.println("Max cost = " + purchasesMax);



        } catch (FileNotFoundException e) {
            System.err.println("Input file is not found");
        }
    }
}
