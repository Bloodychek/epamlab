package by.gsu.epamlab;

public class BusinessTrip {

    private final static int RATE = 120;
    private int dayCount;
    private String account;
    private int transportationExpenses;

    public BusinessTrip(){}

    public BusinessTrip(int count_day, String account, int transportationExpenses){
        this.dayCount = count_day;
        this.account = account;
        this.transportationExpenses = transportationExpenses;
    }

    public int getCount_day() {
        return dayCount;
    }

    public void setCount_day(int count_day) {
        this.dayCount = count_day;
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
        System.out.println("RATE = " + RATE);
        System.out.println("account = " + account);
        System.out.println("transportationExpenses = " + transportationExpenses);
        System.out.println("count_day = " + dayCount);
        System.out.println("total = " + moneyToString(getTotal()));
    }

    public String moneyToString(int money)
    {
        return String.format("%d.%02d", money/100, money%100);
    }

    @Override
    public String toString() {
        return  "account = " + account + "; transportationExpenses = " + moneyToString(transportationExpenses) + "; " +
                "count_day = " + moneyToString(dayCount) + "; total = " + moneyToString(getTotal());
    }
}
