package by.gsu.epamlab;

import java.util.Scanner;

import by.gsu.epamlab.Byn;
import by.gsu.epamlab.PriceDiscountPurchase;
import by.gsu.epamlab.Purchase;

public class PurchasesFactory {
    public static Purchase getPurchaseFromFactory(String line) throws CsvLineException {
        String[] str = line.split(Constants.DELIMITER);

        if (str.length > Constants.PRICE_DISCOUNT_PURCHASE_COUNT || str.length < Constants.PURCHASE_COUNT) {
            throw new CsvLineException(Constants.WRONG_NUMBER_ELEMENTS);
        }

        try {
            String name = str[0];
            Byn price = new Byn(Integer.parseInt(str[1]));
            int number = Integer.parseInt(str[2]);

            if (name.length() == 0) {
                throw new CsvLineException(Constants.EMPTY_NAME);
            }

            if (number <= 0) {
                throw new NonPositiveNumberException(number + Constants.IN_NUMBER);
            }

            if (Integer.parseInt(str[1]) <= 0) {
                throw new NonPositivePriceException(price + Constants.IN_PRICE);
            }

            if (str.length == 3) {
                return new Purchase(name, number, price);
            } else {
                Byn discount;
                try {
                    discount = new Byn(Integer.parseInt(str[3]));
                    if(Integer.parseInt(str[3]) <= 0){
                        throw new NonPositiveDiscountException(discount + Constants.IN_DISCOUNT);
                    }
                } catch (NumberFormatException e) {
                    throw new CsvLineException(Constants.WRONG_NUMBER_ARGUMENTS);
                }
                return new PriceDiscountPurchase(name, price, number, discount);
            }
        } catch (ArrayIndexOutOfBoundsException | NumberFormatException e) {
            throw new CsvLineException(Constants.INCORRECT_ARGUMENT);
        }
    }
}
