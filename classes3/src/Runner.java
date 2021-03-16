import by.gsu.epamlab.Purchase;
import by.gsu.epamlab.Utils;
import by.gsu.epamlab.WeekDay;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

public class Runner {

    public static void main(String[] args) {
        try(Scanner sc = new Scanner(new FileReader("src/in.txt"))) {
            sc.useLocale(Locale.ENGLISH);
            final int PURCHASES_NUMBER = sc.nextInt();
            Purchase[] purchases = new Purchase[PURCHASES_NUMBER];

            for(int i = 0; i < PURCHASES_NUMBER; i++){
                int number = sc.nextInt();
                double percent = sc.nextDouble();
                int numberOfDay = sc.nextInt();
                purchases[i] = new Purchase(number, percent, numberOfDay);
            }

            printArray(purchases);

                int max = 0;
                double average = 0;
                int sum = 0;
                int cost = 0;
                WeekDay weekDay = null;
                for (Purchase purchase : purchases) {
                    int costs = purchase.getCost();
                    sum += costs;
                    if(costs > max){
                        max = costs;
                        weekDay = purchase.getWeekDay();
                    }
                    if(purchase.getWeekDay() == WeekDay.MONDAY){
                        cost += costs;
                    }
                }
            if(purchases.length > 0)
            {
                average = sum *100.0 / purchases.length / 10000;
            }

            System.out.println("Mean cost = " + average);
            System.out.println("The total cost on Monday = " + Utils.moneyToString(cost));
            System.out.println("The day with the maximum cost purchase is " + weekDay);

            Arrays.sort(purchases);
            System.out.println("sorted");
            printArray(purchases);

            int id = Arrays.binarySearch(purchases, new Purchase(5, 0, 0));
            if(id >= 0){
                System.out.println("Required purchase is found: " + purchases[id]);
            }
            else{
                System.out.println("Required purchase is not found");
            }


        } catch (FileNotFoundException e) {
            System.err.println("Input file is not found");
        }
    }

    private static void printArray(Purchase[] purchases){
        System.out.println(Purchase.NAME + ";" + Utils.moneyToString(Purchase.PRICE));
        for (Purchase purchase : purchases) {
            System.out.println(purchase);
        }
    }
}
