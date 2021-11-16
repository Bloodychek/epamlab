import by.gsu.epamlab.Constants;
import by.gsu.epamlab.beans.EntryChecker;
import by.gsu.epamlab.beans.PurchaseFactory;
import by.gsu.epamlab.beans.WeekDay;
import by.gsu.epamlab.model.Byn;
import by.gsu.epamlab.model.PricePurchase;
import by.gsu.epamlab.model.Purchase;

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
                firstPurchaseMap.put(purchase, weekDay);

                lastPurchaseMap.put(purchase, weekDay);
                if (dayPurchaseMap.get(weekDay) == null) {
                    dayPurchaseMap.put(weekDay, new ArrayList<>());
                }
                dayPurchaseMap.get(weekDay).add(purchase);

                if (purchase instanceof PricePurchase) {
                    pricePurchases.add((PricePurchase) purchase);
                }
            }

            Purchase firstBread = new Purchase(Constants.BREAD, 155, 0);
            Purchase secondBread = new Purchase(Constants.BREAD, 170, 0);

            printMap(firstPurchaseMap, Constants.FIRST_PURCHASE_MAP);

            printMap(lastPurchaseMap, Constants.LAST_PURCHASE_MAP);

            findAndShow(firstPurchaseMap, firstBread, Constants.FIRST_FIND);

            findAndShow(lastPurchaseMap, firstBread, Constants.LAST_FIND);

            findAndShow(lastPurchaseMap, secondBread, Constants.LAST_FIND);

            System.out.println(Constants.DELETE);

            removeEntries(firstPurchaseMap, new EntryChecker<Purchase, WeekDay>() {
                @Override
                public boolean check(Map.Entry<Purchase, WeekDay> entry) {
                    return entry.getKey().equals(firstBread);
                }
            });

            removeEntries(lastPurchaseMap, new EntryChecker<Purchase, WeekDay>() {
                @Override
                public boolean check(Map.Entry<Purchase, WeekDay> entry) {
                    return entry.getValue().equals(WeekDay.FRIDAY);
                }
            });

            removeEntries(dayPurchaseMap, new EntryChecker<WeekDay, List<Purchase>>() {
                @Override
                public boolean check(Map.Entry<WeekDay, List<Purchase>> entry) {
                    boolean flag = false;
                    for (Purchase purchase :
                            entry.getValue()) {
                        if (purchase.getName().equals("milk")) {
                            flag = true;
                            break;
                        }
                    }
                    return flag;
                }
            });

            printMap(firstPurchaseMap, Constants.AFTER_DELETING);

            printMap(lastPurchaseMap, Constants.AFTER_DELETING);

            printMap(dayPurchaseMap, Constants.ENUM_MAP);

            System.out.println(Constants.TOTAL_COST);
            System.out.println(getTotalCost(pricePurchases));

            for (Map.Entry<WeekDay, List<Purchase>> entry :
                    dayPurchaseMap.entrySet()) {
                System.out.println(entry.getKey() + Constants.ARROW + getTotalCost(entry.getValue()));
            }

            findAndShow(dayPurchaseMap, WeekDay.MONDAY, Constants.PURCHASE_IN_MONDAY);
        } catch (FileNotFoundException e) {
            System.out.println(Constants.FILE_NOT_FOUND);
        }
    }

    private static <K, V> void printMap(Map<K, V> map, String message) {
        System.out.println(message);
        for (Map.Entry<K, V> entry :
                map.entrySet()) {
            System.out.println(entry.getKey() + Constants.ARROW + entry.getValue());
        }
    }

    private static <K, V> void findAndShow(Map<K, V> map, K key, String header) {
        System.out.println(header);
        V value = map.get(key);
        System.out.println(value != null ? value : Constants.VALUE_NOT_FOUND);
    }

    private static <K, V> void removeEntries(Map<K, V> map, EntryChecker<K, V> entryChecker) {
        for (Iterator<Map.Entry<K, V>> itr = map.entrySet().iterator(); itr.hasNext(); ) {
            Map.Entry<K, V> entry = itr.next();
            if (entryChecker.check(entry)) {
                itr.remove();
            }
        }
    }

    private static Byn getTotalCost(List<? extends Purchase> purchase) {
        Byn totalCost = new Byn();
        for (Purchase pur : purchase) {
            totalCost = totalCost.add(pur.getCost());
        }
        return totalCost;
    }
}