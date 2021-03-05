package by.gsu.epamlab;

public class BusinessTrip {

    private final static int RATE = 120;
    private int dayCount;
    private String account;
    private int transportationExpenses;

    public BusinessTrip(){}

    public BusinessTrip(int dayCount, String account, int transportationExpenses){
        this.dayCount = dayCount;
        this.account = account;
        this.transportationExpenses = transportationExpenses;
    }

    public int getDayCount() {
        return dayCount;
    }

    public void setDayCount(int dayCount) {
        this.dayCount = dayCount;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public int getTransportationExpenses() {
        return transportationExpenses;
    }

    public void setTransportationExpenses(int transportationExpenses) {
        this.transportationExpenses = transportationExpenses;
    }

    public int getTotal()
    {
        return dayCount * RATE + transportationExpenses;
    }

    public void show()
    {
        System.out.println("RATE = " + moneyToString(RATE));
        System.out.println("account = " + account);
        System.out.println("transportationExpenses = " + moneyToString(transportationExpenses));
        System.out.println("dayCount = " + dayCount);
        System.out.println("total = " + moneyToString(getTotal()));
    }

    public String moneyToString(int money)
    {
        return String.format("%d.%02d", money/100, money%100);
    }

    @Override
    public String toString() {
        return  account + ";" + moneyToString(transportationExpenses) + ";" +
                moneyToString(dayCount) + ";" + moneyToString(getTotal());
    }
}
