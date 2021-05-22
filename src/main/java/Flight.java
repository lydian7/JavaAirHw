import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class Flight {

    private ArrayList<CabinCrewMember> crew;
    private ArrayList<Passenger> passengers;
    private Plane plane;
    private String flightNumber;
    private String destination;
    private String departureAirport;
    private LocalDateTime departureTime;
    private HashMap<String, Passenger> seatMap;
    private ArrayList<String> seatNumbers;
    private Boolean seatMapCheck;

    public Flight(ArrayList<CabinCrewMember> crew, Plane plane, String flightNumber, String destination, String departureAirport, LocalDateTime departureTime) {
        this.plane = plane;
        this.flightNumber = flightNumber;
        this.destination = destination;
        this.departureAirport = departureAirport;
        this.departureTime = departureTime;
        this.crew = crew;
        this.passengers = new ArrayList<>();
        this.seatMap = new HashMap<>();
        this.seatNumbers = new ArrayList<>();
        this.seatMapCheck = false;
    }

    public Plane getPlane() {
        return plane;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public String getDestination() {
        return destination;
    }

    public String getDepartureAirport() {
        return departureAirport;
    }

    public LocalDateTime getDepartureTime() {
        return departureTime;
    }

    public int getNumberOfSeats(){
        return plane.getCapacity();
    }

    public void addPassenger(Passenger passenger) {
        if (!seatMapCheck) {
            createSeatPlan();
        }

        if(getPassengerCount() < getNumberOfSeats()){
            passenger.setFlightNo(getFlightNumber());
            passenger.setSeatNo(getRandomSeatNo());
            seatNumbers.remove(passenger.getSeatNo());
            seatMap.put(passenger.getSeatNo(), passenger);
            this.passengers.add(passenger);
        }
    }

    public ArrayList<Passenger> getPassengers(){
        return passengers;
    }

    public int getPassengerCount(){
        return passengers.size();
    }

    public ArrayList<CabinCrewMember> getCrew(){
        return crew;
    }

    public void createSeatPlan(){
        String[] letters = {"A", "B", "C", "D", "F", "G"};
        int totalSeats = plane.getCapacity();
        for(int i = 1; i<=totalSeats/letters.length; i++){
            for(int k =0; k < letters.length; k++){
                this.seatNumbers.add(i+letters[k]);
                this.seatMap.put(i+letters[k], null);
            }
        }
        this.seatMapCheck = true;
    }

    public String getRandomSeatNo(){
        int index = (int)(Math.random() * seatNumbers.size());
        return seatNumbers.get(index);
    }

    public boolean checkIfSeatExists(String seatNumber){
        return seatMap.containsKey(seatNumber);
    }

    public boolean checkForDoubleBookings(){
        String check = null;
        boolean doubleBooked = false;
        for(Passenger passenger : seatMap.values()){
            if(passenger.getName() == check){
                doubleBooked = true;
            }
            check = passenger.getName();
        }
        return doubleBooked;
    }


}
