package by.gsu.epamlab;

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

        for (BusinessTrip trip: businessTrips) {
            if(trip != null){
                trip.show();
            }
        }

        BusinessTrip maxTrip = new BusinessTrip();
        for (BusinessTrip trip:
             businessTrips) {
            if(trip != null && maxTrip.getTotal() < trip.getTotal()) {
                maxTrip = trip;
            }
        }
        System.out.println("Trip with maximum cost:");
        maxTrip.show();

        businessTrips[businessTrips.length - 1].setTransportationExpenses(55);

        System.out.println("Duration = " + (businessTrips[0].getCount_day() + businessTrips[1].getCount_day()));

        for (BusinessTrip trip: businessTrips) {
            System.out.println(trip);
        }
    }
}
