package by.gsu.epamlab;

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
        return new Byn(value * byn.value);
    }

    public Byn div(Byn byn){
       return new Byn(value / byn.value);
    }

    public Byn add(Byn byn){
        return new Byn(value + byn.value);
    }

    public Byn sub(Byn byn){
        return new Byn(value - byn.value);
    }

    public Byn mul(int number){
        return new Byn(value * number);
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

    public Byn mul(double value, RoundMethod roundMethod, int d) {
        return new Byn(roundMethod.round(value * value, d));
    }

    public Byn round(RoundMethod roundMethod, int d){
        return new Byn(roundMethod.round(value, d));
    }
}
