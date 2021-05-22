import java.util.ArrayList;

public class FlightManager{

    private Flight flight;
    private ArrayList<Passenger> passengers;
    private ArrayList<CabinCrewMember> crew;
    private Plane plane;

    public FlightManager(Flight flight) {
        this.flight = flight;
        this.passengers = flight.getPassengers();
        this.plane = flight.getPlane();
        this.crew = flight.getCrew();
    }

    public double getTotalBaggageAllowance(){
        return plane.getWeight() / 2;
    }

    public double getBaggageWeightReservedPerPassenger(){
        return getTotalBaggageAllowance() / flight.getPlane().getCapacity();
    }

    public int getBaggageWeightBookedPassengers(){
        int total = 0;
        for(Passenger passenger : passengers){
            total += passenger.getBagsTotalWeight();
        }
        return total;
    }

    public double getRemainingWeightforFlight(){
        return getTotalBaggageAllowance() - getBaggageWeightBookedPassengers();
    }

}
