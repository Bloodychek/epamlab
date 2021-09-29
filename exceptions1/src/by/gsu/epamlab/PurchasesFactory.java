package by.gsu.epamlab;

import java.util.Scanner;

public class PurchasesFactory {
    private static String[] arrStr;
    private static String newName;
    private static int newPrice;
    private static int newNumber;
    private static int newDiscount;
    public static Purchase purchase(String str) throws PurchaseException, CheckStringExceptions, NullExceptions {
        arrStr = str.split(";");
        if(arrStr.length < 3 && arrStr.length > 4) throw new PurchaseException("Lenght of string more 4 or less 3");
        try{

            try{
                String newName = arrStr[0];
            } catch (NumberFormatException e){
                throw new CheckStringExceptions("Name is not valid");
            }

            if(!newName.equals("")){
                try {
                    throw new NullExceptions("Price consist null number or number less null");
                } catch (NumberFormatException e) {
                    e.getMessage();
                }
            }

            try{
                int newPrice = Integer.parseInt(arrStr[1]);
            } catch (NumberFormatException e){
                throw new CheckStringExceptions("Price is not valid");
            }

            if(newPrice <= 0){
                try {
                    throw new NullExceptions("Price consist null number or number less null");
                } catch (NumberFormatException e) {
                    e.getMessage();
                }
            }

            try{
                int newNumber = Integer.parseInt(arrStr[2]);
            } catch (NumberFormatException e){
                throw new CheckStringExceptions("Number is not valid");
            }

            if(newNumber <= 0){
                try {
                    throw new NullExceptions("Number consist null number or number less null");
                } catch (NumberFormatException e) {
                    e.getMessage();
                }
            }

            if(arrStr.length == 3){
                return new PriceDiscountPurchase();
            }

            else if(arrStr.length == 4){
                try {
                    int newDiscount = Integer.parseInt(arrStr[3]);
                } catch (NumberFormatException e){
                    throw new CheckStringExceptions("discount is not valid");
                }
                return new Purchase();
            }
            else throw new PurchaseException("One or more parameters of string do not contain the correct information");
        } catch (NumberFormatException e ) {
            return null;
        }
    }
}
