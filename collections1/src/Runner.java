import by.gsu.epamlab.Beans.Constants;
import by.gsu.epamlab.Beans.PurchaseFactory;
import by.gsu.epamlab.Beans.WeekDay;
import by.gsu.epamlab.Model.Byn;
import by.gsu.epamlab.Model.PricePurchase;
import by.gsu.epamlab.Model.Purchase;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class Runner {

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(new FileReader(Constants.FILE))) {
            Map<Purchase, WeekDay> firstPurchaseMap = new HashMap<>();
            Map<Purchase, WeekDay> lastPurchaseMap = new HashMap<>();
            List<PricePurchase> pricePurchases = new ArrayList<>();
            Map<WeekDay, List<Purchase>> dayPurchaseMap = new EnumMap<>(WeekDay.class);

            while (sc.hasNext()) {
                Purchase purchase = PurchaseFactory.getPurchaseFromFactory(sc);
                WeekDay weekDay = WeekDay.valueOf(sc.nextLine());
                firstPurchaseMap.putIfAbsent(purchase, weekDay);
                lastPurchaseMap.put(purchase, weekDay);
                dayPurchaseMap.putIfAbsent(weekDay, new ArrayList<>());
                dayPurchaseMap.get(weekDay).add(purchase);

                if(purchase instanceof PricePurchase){
                    pricePurchases.add((PricePurchase) purchase);
                }
            }

            Purchase firstBread = new Purchase(Constants.BREAD, 155, 0);
            Purchase secondBread = new Purchase(Constants.BREAD, 170, 0);

            System.out.println(Constants.FIRST_PURCHASE_MAP);
            printMap(firstPurchaseMap);

            System.out.println(Constants.LAST_PURCHASE_MAP);
            printMap(lastPurchaseMap);

            System.out.println(Constants.FIRST_FIND);
            System.out.println(findMap(firstPurchaseMap, firstBread));

            System.out.println(Constants.LAST_FIND);
            System.out.println(findMap(lastPurchaseMap, firstBread));

            System.out.println(Constants.LAST_FIND);
            System.out.println(findMap(lastPurchaseMap, secondBread));

            System.out.println(Constants.FIRST_FIND);
            System.out.println(findMap(firstPurchaseMap, secondBread));

            System.out.println(Constants.DELETE);
            deleteMap(firstPurchaseMap, Constants.MEAT, WeekDay.MONDAY);
            deleteMap(lastPurchaseMap, Constants.NO_NAME, WeekDay.FRIDAY);

            System.out.println(Constants.AFTER_DELETING);
            printMap(firstPurchaseMap);
            System.out.println(Constants.AFTER_DELETING);
            printMap(lastPurchaseMap);

            System.out.println(Constants.TOTAL_COST);
            System.out.println(getTotalCost(pricePurchases));

            System.out.println(Constants.ENUM_MAP);
            printMap(dayPurchaseMap);

            System.out.println(getTotalCost(pricePurchases));

            System.out.println(Constants.MONDAY + Constants.ARROW + findMap(dayPurchaseMap, WeekDay.MONDAY));
        } catch (FileNotFoundException e) {
            System.out.println(Constants.FILE_NOT_FOUND);
        }
    }

    private static <K, V> void printMap(Map<K, V> map) {
        for (Map.Entry<K, V> entry :
                map.entrySet()) {
            System.out.println(entry.getKey() + Constants.ARROW + entry.getValue());
        }
    }

    private static <K, V> String findMap(Map<K, V> map, K key) {
        return String.valueOf(map.get(key));
    }

    private static <K extends Purchase, V> void deleteMap(Map<K, V> map, String name, WeekDay weekDay) {
        for (Iterator<Map.Entry<K, V>> itr = map.entrySet().iterator(); itr.hasNext(); ) {
            Map.Entry<K, V> entry = itr.next();
            K key = entry.getKey();
            V value = entry.getValue();
            if (key.getName().equals(name) || value.equals(weekDay)) {
                itr.remove();
            }
        }
    }

    private static Byn getTotalCost(List<? extends Purchase> list){
        Byn totalCost = new Byn();
        for(Purchase purchase : list){
            totalCost = totalCost.add(purchase.getCost());
        }
        return totalCost;
    }
}