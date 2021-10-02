package by.gsu.epamlab;

public class CsvLineException extends Throwable{
    private String line;

    public CsvLineException(String line) {
        this.line = line;
    }

    @Override
    public String toString() {
        return line;
    }
}
