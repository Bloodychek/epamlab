package by.gsu.epamlab.Beans;

public enum WeekDay {
    SUNDAY,
    MONDAY,
    TUESDAY,
    WEDNESDAY,
    THURSDAY,
    FRIDAY,
    SATURDAY;

    @Override
    public String toString() {
        return this.name();
    }
}