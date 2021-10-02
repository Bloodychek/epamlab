package by.gsu.epamlab;

public class NonPositivePriceException extends IllegalArgumentException {
    private final String value;

    public NonPositivePriceException(String value){
        this.value = value;
    }

    @Override
    public String toString(){
        return Constants.NON_POSITIVE_VALUE + value;
    }
}
