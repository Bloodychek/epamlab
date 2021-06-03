package by.gsu.epamlab;

public class Product {
    private final String name;
    private final Byn price;

    public Product(String name, Byn price){
        this.name = name;
        this.price = price;
    }

    public Product(){
        this("", new Byn(0));
    }

    public Product(String name, int price){
        this(name, new Byn(price));
    }

    public String getName() {
        return name;
    }

    public Byn getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return name + ";" + price;
    }
}
