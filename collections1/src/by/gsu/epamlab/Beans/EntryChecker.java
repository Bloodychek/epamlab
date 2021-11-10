package by.gsu.epamlab.Beans;

import by.gsu.epamlab.Model.Purchase;

import java.util.Map;

public interface EntryChecker<K, V> {
    boolean check(Map.Entry<K, V>  entry);
}
