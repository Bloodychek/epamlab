package by.gsu.epamlab.models;

import by.gsu.epamlab.enums.NumField;
import by.gsu.epamlab.enums.RoundMethod;
import by.gsu.epamlab.exceptions.NonPositiveArgumentException;

import java.security.PublicKey;

public class Byn implements Comparable<Byn> {
    private int value;

    public Byn(int value) {
        this.value = value;
    }

    public Byn(Byn byn) {
        this(byn.value);
    }

    public Byn() {
        this(0);
    }

    public Byn mul(Byn byn) {
        return new Byn(value * byn.value);
    }

    public Byn div(Byn byn) {
        return new Byn(value / byn.value);
    }

    public Byn add(Byn byn) {
        return new Byn(value + byn.value);
    }

    public Byn sub(Byn byn) {
        return new Byn(value - byn.value);
    }

    public Byn mul(int number) {
        return new Byn(value * number);
    }

    public int getRubs() {
        return value / 100;
    }

    public int getCops() {
        return value % 100;
    }

    public Byn mul(double value, RoundMethod roundMethod, int d) {
        return new Byn(roundMethod.round(value * value, d));
    }

    public Byn round(RoundMethod roundMethod, int d) {
        return new Byn(roundMethod.round(value, d));
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!(obj instanceof Byn))
            return false;
        Byn byn = (Byn) obj;
        return Double.compare(byn.value, value) == 0;
    }

    @Override
    public String toString() {
        return String.format("%d.%02d", (value / 100), (value % 100));
    }

    @Override
    public int compareTo(Byn byn) {
        return value - byn.value;
    }
}
