package by.gsu.epamlab;

public class Subject {
    private String name;
    Material material;
    private Double volume;

    public Subject(){

    }

    public Subject(String name, Material material, Double volume) {
        this.name = name;
        this.material = material;
        this.volume = volume;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public Double getVolume() {
        return volume;
    }

    public void setVolume(Double volume) {
        this.volume = volume;
    }

    public Double getMass()
    {
        return material.getDENSITY() * volume;
    }

    @Override
    public String toString() {
        return name + ";" + material + ";" +  volume;
    }
}
