package by.gsu.epamlab.exceptions;

public class WrongDate extends IllegalArgumentException {
    public WrongDate(String s) {
        super(s);
    }

    @Override
    public String toString() {
        return getMessage();
    }
}
