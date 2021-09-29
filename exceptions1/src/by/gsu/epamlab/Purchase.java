package by.gsu.epamlab;

public class Purchase implements Comparable<Purchase> {
    private String name;
    private Byn price;
    private int number;
    private double cost;

    public Purchase(String name, int price, int number, double cost) {
        this.name = name;
        this.price = new Byn(price);
        this.number = number;
        this.cost = cost;
    }

    public Purchase() {
        this("", 0, 0, 0);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Byn getPrice() {
        return price;
    }

    public void setPrice(Byn price) {
        this.price = price;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    protected String fieldsToString(){
        return name + ";" + price + ";" + number + ";" + cost;
    }

    @Override
    public String toString(){
        return fieldsToString() + ";" + totalCost();
    }

    public Byn totalCost(){
        Byn byn = new Byn(price);
        return byn.mul(number);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!(obj instanceof Purchase))
            return false;
        Purchase purchase = (Purchase) obj;
        return getName().equals(purchase.getName())
                && getPrice().equals(purchase.getPrice());
    }

    public int compareTo(Purchase purchase){
        return number - purchase.number;
    }

}
