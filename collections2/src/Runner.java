import by.gsu.epamlab.beans.Constants;
import by.gsu.epamlab.beans.NumLen;
import by.gsu.epamlab.comparators.NumLenComparator;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class Runner {

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(new FileReader(Constants.FILE_NAME))) {
            List<NumLen> numLenList = new ArrayList<>();
            while (sc.hasNext()) {
                String line = sc.nextLine();
                String[] elements = line.trim().split(Constants.REGEX);
                NumLen numLen = new NumLen(getLen(elements));

                int index = Collections.binarySearch(numLenList, numLen);
                if (index >= 0) {
                    numLenList.get(index).incNum();
                } else {
                    numLenList.add(-index - 1, numLen);
                }
            }

            numLenList.sort(new NumLenComparator());

            printList(numLenList);

        } catch (FileNotFoundException e) {
            System.out.println(Constants.FILE_NOT_FOUND);
        }
    }

    private static int getLen(String[] elements) {
        double firstTerm = Double.parseDouble(elements[1]) - Double.parseDouble(elements[3]);
        double secondTerm = Double.parseDouble(elements[2]) - Double.parseDouble(elements[4]);
        return (int) Math.round(Math.sqrt(firstTerm * firstTerm + secondTerm * secondTerm));
    }

    private static void printList(List<NumLen> numLenList) {
        for (NumLen len :
                numLenList) {
            System.out.println(len);
        }
    }
}