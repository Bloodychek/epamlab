package by.gsu.epamlab;

public class TransportPurchase extends AbstractPurchase{
    private Byn transportationCosts;

    public TransportPurchase(int number, Product product, Byn transportationCosts) {
        super(number, product);
        this.transportationCosts = transportationCosts;
    }

    public TransportPurchase(int number, Product product, int transportationCosts) {
        super(number, product);
        this.transportationCosts = new Byn(transportationCosts);
    }

    public TransportPurchase(){
        this(0, null, null);
    }

    @Override
    public Byn calculate(Byn result) {
        return result.mul(transportationCosts);
    }

    @Override
    protected String fieldsToString() {
        return super.fieldsToString() + ";" + transportationCosts;
    }

    public Byn getTransportationCosts() {
        return transportationCosts;
    }

    public void setTransportationCosts(Byn transportationCosts) {
        this.transportationCosts = transportationCosts;
    }
}
