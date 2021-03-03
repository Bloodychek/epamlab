package by.gsu.epamlab;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        BusinessTrip[] businessTrips = {
                new BusinessTrip(5,"nikita",5),
                new BusinessTrip(1,"kirill",2),
                null,
                new BusinessTrip(8,"evgeniy",9),
                new BusinessTrip(2,"stas",4),
                new BusinessTrip()
        };

        for (BusinessTrip b: businessTrips) {
            if(b != null){
                b.show();
            }
        }
        BusinessTrip maxTrip = new BusinessTrip();
        for (BusinessTrip j:
             businessTrips) {
            if(j != null && maxTrip.getTotal() < j.getTotal()) {
                maxTrip = j;
            }
        }
        maxTrip.show();

        businessTrips[4].setTransportationExpenses(55);

        System.out.println(businessTrips[0].getCount_day());
        System.out.println( businessTrips[1].getCount_day());

        for (BusinessTrip trip: businessTrips) {
            System.out.println(trip);
        }
    }
}
