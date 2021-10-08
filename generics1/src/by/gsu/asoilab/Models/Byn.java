package by.gsu.asoilab.Models;

import by.gsu.asoilab.Constants.Constants;
import by.gsu.asoilab.RoundMethod;

public class Byn implements Comparable<Byn> {
    private int kopecks;

    public Byn(int value) {
        this.kopecks = value;
    }

    public Byn(Byn byn) {
        this(byn.kopecks);
    }

    public Byn() {
        this(0);
    }

    public Byn mul(Byn byn) {
        return new Byn(kopecks * byn.kopecks);
    }

    public Byn div(Byn byn) {
        return new Byn(kopecks / byn.kopecks);
    }

    public Byn add(Byn byn) {
        return new Byn(kopecks + byn.kopecks);
    }

    public Byn sub(Byn byn) {
        return new Byn(kopecks - byn.kopecks);
    }

    public Byn mul(int number) {
        return new Byn(kopecks * number);
    }

    public int getRubs() {
        return kopecks / 100;
    }

    public int getCops() {
        return kopecks % 100;
    }

    public Byn mul(double value, RoundMethod roundMethod, int d) {
        return new Byn(roundMethod.round(kopecks * value, d));
    }

    public Byn div(double value, RoundMethod roundMethod, int d) {
        return new Byn(roundMethod.round(kopecks / value, d));
    }

    public Byn round(RoundMethod roundMethod, int d) {
        return new Byn(roundMethod.round(kopecks, d));
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!(obj instanceof Byn))
            return false;
        Byn byn = (Byn) obj;
        return Double.compare(byn.kopecks, kopecks) == 0;
    }

    @Override
    public String toString() {
        return String.format(Constants.FORMAT, (kopecks / 100), (kopecks % 100));
    }

    @Override
    public int compareTo(Byn byn) {
        return kopecks - byn.kopecks;
    }
}