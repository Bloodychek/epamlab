package by.gsu.epamlab.exceptions;

import by.gsu.epamlab.beans.Constants;

public class CsvLineException extends Exception{
    private final String line;

    public CsvLineException(String line) {
        this.line = line;
    }

    public CsvLineException(Exception e, String line){
        super(e);
        this.line = line;
    }

    @Override
    public String toString() {
        return line + Constants.DELIMITER;
    }
}
