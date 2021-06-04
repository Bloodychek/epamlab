package by.gsu.epamlab;

public class Byn implements Comparable<Byn>{
    private final int kopecks;

    public Byn(int kopecks){
        this.kopecks = kopecks;
    }

    public Byn(){
        this(0);
    }

    @Override
    public String toString() {
        return String.format("%d.%02d", kopecks / 100, kopecks % 100);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null)
            return false;
        if (!(o instanceof Byn))
            return false;
        Byn byn = (Byn) o;
        if (kopecks != byn.kopecks)
            return false;
        return true;
    }

    public int compareTo(Byn byn){
        return kopecks - byn.kopecks;
    }

    public Byn(int rubs, int coins){
        this(rubs * 100 + coins);
    }

    public Byn(Byn byn){
        this(byn.kopecks);
    }

    public Byn add(Byn byn){

        return new Byn(kopecks + byn.kopecks);
    }

    public Byn sub(Byn byn){
        return new Byn(kopecks - byn.kopecks);
    }

    public Byn mul(int number){
        return new Byn(kopecks * number);
    }

    public Byn round(RoundMethod roundMethod, int d){
        return new Byn(roundMethod.round(kopecks, d));
    }
}
