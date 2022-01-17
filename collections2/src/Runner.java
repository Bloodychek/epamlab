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

                int num = 0;
                if (numLenMap.get(len) != null) {
                    num = numLenMap.get(len) + 1;
                    numLenMap.put(len, num);
                } else {
                    num = 1;
                    numLenMap.put(len, num);
                }
            }

            List<Map.Entry<Integer, Integer>> numLen = new ArrayList<>(numLenMap.entrySet());
            Collections.sort(numLen, new NumLenComparator());

            printList(numLen);

        } catch (FileNotFoundException e) {
            System.out.println(Constants.FILE_NOT_FOUND);
        }
    }

    private static int getLen(String[] elements) {
        double firstTerm = Double.parseDouble(elements[1]) - Double.parseDouble(elements[3]);
        double secondTerm = Double.parseDouble(elements[2]) - Double.parseDouble(elements[4]);
        return (int) Math.round(Math.sqrt(firstTerm * firstTerm + secondTerm * secondTerm));
    }

    private static void printList(List<Map.Entry<Integer, Integer>> numLenList) {
        for (Map.Entry<Integer, Integer> len :
                numLenList) {
            System.out.println(len.getKey() + Constants.DELIMITER + len.getValue());
        }
    }
}