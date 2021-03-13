package by.gsu.epamlab;

public class Purchase implements Comparable<Purchase>{
    public final static String NAME = "Pan";
    public final static int PRICE = 120;
    private int number;
    private double percent;
    private WeekDay weekDay;

    public Purchase(){

    }

    public Purchase(int number, double percent, WeekDay weekDay) {
        this.number = number;
        this.percent = percent;
        this.weekDay = weekDay;
    }

    public Purchase(int number, double percent, int weekDay) {
        this.number = number;
        this.percent = percent;
        this.weekDay = WeekDay.values()[weekDay];
    }

    public WeekDay getWeekDay() {
        return weekDay;
    }

    public void setWeekDay(WeekDay weekDay) {
        this.weekDay = weekDay;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public double getPercent() {
        return percent;
    }

    public void setPercent(int discount) {
        this.percent = discount;
    }

    @Override
    public int compareTo(Purchase purchase) {
        return number - purchase.number;
    }

    @Override
    public String toString() {
        return number + ";" + percent + ";" + weekDay + ";" + Utils.moneyToString(getCost());
    }

    public int getCost(){
        return (int)Math.round(PRICE * number * (100 - percent) / 100);
    }
}
