package by.gsu.epamlab;

public class PercentPurchase extends AbstractPurchase{
    private double percentDiscount;
    private final static int COUNT = 15;

    public PercentPurchase(int number, Product product, double percentDiscount) {
        super(number, product);
        this.percentDiscount = percentDiscount;
    }

    public PercentPurchase() {
        this(0, null, 0.0);
    }

    @Override
    public Byn calculate(Byn result) {
        if(getNumber() > COUNT){
            result = result.mul(1 - (int)percentDiscount / 100);
        }
        return result;
    }

    @Override
    protected String fieldsToString() {
        return super.fieldsToString() + ";" + percentDiscount;
    }

    public double getPercentDiscount() {
        return percentDiscount;
    }

    public void setPercentDiscount(double percentDiscount) {
        this.percentDiscount = percentDiscount;
    }
}
