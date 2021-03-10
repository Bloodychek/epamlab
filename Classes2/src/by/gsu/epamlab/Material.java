package by.gsu.epamlab;

public class Material {
    private String name;
    private final double DENSITY;

    public Material(){
        this(null, 0);
    }

    public Material(String name, double DENSITY) {
        this.name = name;
        this.DENSITY = DENSITY;
    }

    public String getName() {
        return name;
    }

    public double getDENSITY() {
        return DENSITY;
    }

    @Override
    public String toString() {
        return name + ";" + DENSITY;
    }
}
