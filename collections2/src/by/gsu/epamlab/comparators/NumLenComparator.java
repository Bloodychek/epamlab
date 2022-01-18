package by.gsu.epamlab.comparators;

import java.util.Comparator;
import java.util.Map;

public class NumLenComparator implements Comparator<Integer> {
    private Map<Integer, Integer> baseMap;

    public NumLenComparator(Map<Integer, Integer> baseMap) {
        this.baseMap = baseMap;
    }

    public int compare(Integer num0, Integer num1) {
        int diff = baseMap.get(num1) - baseMap.get(num0);
        if (diff != 0) {
            return diff;
        } else {
            return 1;
        }
    }
}
