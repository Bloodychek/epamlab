package by.gsu.epamlab;

import java.util.Objects;

public class Byn {
    private int kopecks;

    public Byn(int kopecks){
        this.kopecks = kopecks;
    }

    public Byn(Byn byn){
        this(byn.kopecks);
    }

    public Byn(){

    }

    public Byn mul(Byn byn){
        kopecks *= byn.kopecks;
        return this;
    }

    public Byn div(Byn byn){
        kopecks /= byn.kopecks;
        return this;
    }

    public Byn add(Byn byn){
        kopecks += byn.kopecks;
        return this;
    }

    public Byn sub(Byn byn){
        kopecks -= byn.kopecks;
        return this;
    }

    public Byn mul(int number){
        kopecks *= number;
        return this;
    }

    public Byn mul(double number){
        kopecks *= number;
        return this;
    }

    @Override
    public String toString() {
        return String.format("%d.%02d", kopecks / 100, kopecks % 100);
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

    public int compareTo(Byn byn){
            return kopecks - byn.kopecks;
    }
}
