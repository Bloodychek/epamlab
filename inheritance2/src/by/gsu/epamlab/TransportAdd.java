package by.gsu.epamlab;

public class TransportAdd extends AbstractPurchase{
    private int transportationCosts;

    public TransportAdd(int number, Product product, int transportationCosts) {
        super(number, product);
        this.transportationCosts = transportationCosts;
    }

    public TransportAdd(){
        this(0, null, 0);
    }

    @Override
    public Byn calculate(Byn result) {
        return result.mul(transportationCosts);
    }

    @Override
    protected String fieldsToString() {
        return super.fieldsToString() + ";" + transportationCosts;
    }

    public int getTransportationCosts() {
        return transportationCosts;
    }

    public void setTransportationCosts(int transportationCosts) {
        this.transportationCosts = transportationCosts;
    }
}
