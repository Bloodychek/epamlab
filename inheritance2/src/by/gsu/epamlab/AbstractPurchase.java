package by.gsu.epamlab;

public abstract class AbstractPurchase implements Comparable<AbstractPurchase> {
    private final Product product;
    private int number;

    public AbstractPurchase(int number, Product product){
        this.number = number;
        this.product = product;
    }

    public AbstractPurchase(){
        this(0, null);
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return fieldsToString() + ";" + getCost();
    }

    public Byn getCost(){
        Byn result = (product.getPrice().mul(number));
        result = calculate(result).round(RoundMethod.ROUND, 2);
        return result;
    }

    protected abstract Byn calculate(Byn result);

    @Override
    public int compareTo(AbstractPurchase o) {
        return o.getCost().compareTo(getCost());
    }

    protected String fieldsToString(){
        return product + ";" + number;
    }
}
