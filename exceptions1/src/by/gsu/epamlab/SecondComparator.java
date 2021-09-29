package by.gsu.epamlab;

import java.util.Comparator;

public abstract class SecondComparator implements Comparator<Purchase> {
    @Override
    public int compare(Purchase o1, Purchase o2) {
        if(o1.getClass() == o2.getClass()){
            return 1;
        }
        return 0;
    }
}
