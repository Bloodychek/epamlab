package by.gsu.epamlab.comparators;

import java.util.Comparator;
import java.util.Map;

public class NumLenComparator implements Comparator<Map.Entry<Integer, Integer>> {
    @Override
    public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
        return o2.getValue() - o1.getValue();
    }
}