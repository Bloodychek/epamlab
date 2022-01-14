package by.gsu.epamlab;

public class Segment implements Comparable<Segment> {
    private int len;
    private int num;

    public Segment(int len) {
        this.len = len;
        num = 1;
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

    public int compareTo(Segment o) {
        return len - o.len;
    }
}
