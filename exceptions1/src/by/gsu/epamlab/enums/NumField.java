package by.gsu.epamlab.enums;

public enum NumField {
    PRICE(" in price"),
    NUMBER(" in number"),
    DISCOUNT(" in discount"),
    VALUE(" in value");

    public final String name;

    NumField(String name){
        this.name = name;
    }

    @Override
    public String toString(){
        return name;
    }
}


