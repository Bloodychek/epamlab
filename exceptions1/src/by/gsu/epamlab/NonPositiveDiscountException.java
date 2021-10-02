package by.gsu.epamlab;

public class NonPositiveDiscountException extends IllegalArgumentException {
    private final String value;

    public NonPositiveDiscountException(String value){
        this.value = value;
    }

    @Override
    public String toString(){
        return Constants.NON_POSITIVE_VALUE + value;
    }
}
