package by.gsu.epamlab;

public class UnitPurchase extends AbstractPurchase {
    private Byn priceDiscount;

    public UnitPurchase(int number, Product product, Byn priceDiscount) {
        super(number, product);
        this.priceDiscount = priceDiscount;
    }

    public UnitPurchase(int number, Product product, int priceDiscount) {
        super(number, product);
        this.priceDiscount = new Byn(priceDiscount);
    }

    public UnitPurchase(){
        this(0, null, null);
    }

    @Override
    public Byn calculate(Byn result) {
        return result.sub(priceDiscount.mul(getNumber()));
    }

    @Override
    protected String fieldsToString() {
        return super.fieldsToString() + ";" + priceDiscount;
    }

    public Byn getPriceDiscount() {
        return priceDiscount;
    }

    public void setPriceDiscount(Byn priceDiscount) {
        this.priceDiscount = priceDiscount;
    }
}
