package by.gsu.epamlab;

public class Utils {

    public static String moneyToString(int value){
        return String.format("%d.%02d", value/100, value%100);
    }
}
