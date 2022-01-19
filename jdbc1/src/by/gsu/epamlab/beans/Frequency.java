package by.gsu.epamlab.beans;

import by.gsu.epamlab.beans.Constants;

public class Frequency {
    private int len;
    private int num;

    public Frequency(int len, int num) {
        this.len = len;
        this.num = num;
    }

    public int getLen() {
        return len;
    }

    public void setLen(int len) {
        this.len = len;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return len + Constants.DELIMITER + num;
    }
}
