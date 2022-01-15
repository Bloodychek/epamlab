package by.gsu.epamlab;

public class NumLen implements Comparable<NumLen> {
    private final int len;
    private int num;

    public NumLen(int len) {
        this.len = len;
        num = 1;
    }

    public int getLen() {
        return len;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public void incNum() {
        num++;
    }

    @Override
    public String toString() {
        return len + Constants.DELIMITER + num;
    }

    public int compareTo(NumLen numLen) {
        return len - numLen.len;
    }
}
