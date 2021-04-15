package by.gsu.epamlab;

import java.util.Objects;

public class Byn implements Comparable<Byn>{
    private int value;

    public Byn(int value){
        this.value = value;
    }

    public Byn(int rubs, int coins){
        this(rubs * 100 + coins);
    }

    public Byn(Byn byn){
        this(byn.value);
    }

    public Byn mul(Byn byn){
        value *= byn.value;
        return this;
    }

    public Byn div(Byn byn){
        value /= byn.value;
        return this;
    }

    public Byn add(Byn byn){
        value += byn.value;
        return this;
    }

    public Byn sub(Byn byn){
        value -= byn.value;
        return this;
    }

    public Byn mul(int number){
        value *= number;
        return this;
    }

    public Byn mul(double number){
        value *= number;
        return this;
    }

    @Override
    public String toString() {
        return String.format("%d.%02d", value / 100, value % 100);
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

    public int compareTo(Byn byn){
            return value - byn.value;
    }

    public Byn mul(double k, RoundMethod roundMethod, int d){
        int tenPow = (int) Math.pow(10, d);
        value = (int) roundMethod.round(value * k / tenPow, d) * tenPow;
        return this;
    }
    public Byn round(RoundMethod roundMethod, int d){
        value = (int) roundMethod.round(value, d);
        return this;
    }

}
