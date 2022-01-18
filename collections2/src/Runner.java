import by.gsu.epamlab.beans.Constants;
import by.gsu.epamlab.comparators.NumLenComparator;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class Runner {

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(new FileReader(Constants.FILE_NAME))) {
            Map<Integer, Integer> numLenMap = new HashMap<>();
            while (sc.hasNext()) {
                String line = sc.nextLine();
                String[] elements = line.trim().split(Constants.REGEX);
                int len = getLen(elements);

                Integer value = numLenMap.get(len);
                if (value == null) {
                    value = 0;
                }
                numLenMap.put(len, value + 1);

            }

            SortedMap<Integer, Integer> sortedMapNumLen = new TreeMap<Integer, Integer>(new NumLenComparator(numLenMap));
            sortedMapNumLen.putAll(numLenMap);

            printCollection(sortedMapNumLen.entrySet());

        } catch (FileNotFoundException e) {
            System.out.println(Constants.FILE_NOT_FOUND);
        }
    }

    private static int getLen(String[] elements) {
        double firstTerm = Double.parseDouble(elements[1]) - Double.parseDouble(elements[3]);
        double secondTerm = Double.parseDouble(elements[2]) - Double.parseDouble(elements[4]);
        return (int) Math.round(Math.sqrt(firstTerm * firstTerm + secondTerm * secondTerm));
    }

    private static void printCollection(Collection<Map.Entry<Integer, Integer>> entrySet) {
        for (Map.Entry<Integer, Integer> pair : entrySet) {
            System.out.println(pair.getKey() + Constants.DELIMITER + pair.getValue());
        }
    }
}