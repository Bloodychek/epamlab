package by.gsu.epamlab;

public class BusinessTrip {

    private final static int RATE = 120;
    private int count_day;
    private String account;
    private int transportationExpenses;

    public BusinessTrip(){}

    public BusinessTrip(int count_day, String account, int transportationExpenses){
        this.count_day = count_day;
        this.account = account;
        this.transportationExpenses = transportationExpenses;
    }

    public int getCount_day() {
        return count_day;
    }

    public void setCount_day(int count_day) {
        this.count_day = count_day;
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
        return count_day * RATE + transportationExpenses;
    }

    public void show()
    {
        System.out.println("RATE = " + RATE);
        System.out.println("account = " + account);
        System.out.println("transportationExpenses = " + transportationExpenses);
        System.out.println("count_day = " + count_day);
        System.out.println("total = " + rounding(getTotal()));
    }

    public String rounding(int money)
    {
        return String.format("%d.%2d", money/100, money%100);
    }

    @Override
    public String toString() {
        return  "account = " + account + ";" +
                " transportationExpenses = " + transportationExpenses + ";" +
                " count_day = " + count_day + ";" +
                " total = " + rounding(getTotal());
    }
}
