package by.gsu.epamlab;

public class NonPositiveNumberException extends IllegalArgumentException {
    private final String value;

    public NonPositiveNumberException(String value){
        this.value = value;
    }

    @Override
    public String toString(){
        return Constants.NON_POSITIVE_VALUE + value;
    }
}
