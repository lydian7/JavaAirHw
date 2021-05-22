import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class FlightTest {

    Passenger passenger;
    Passenger passenger2;
    Passenger passenger3;
    Passenger passenger4;
    Passenger passenger5;
    Passenger passenger6;
    Passenger passenger7;
    Passenger passenger8;
    Passenger passenger9;
    Passenger passenger10;
    Passenger passenger11;
    Passenger passenger12;
    Passenger passenger13;
    Flight flight;
    Pilot pilot;
    CabinCrewMember flightAttendant1;
    CabinCrewMember flightAttendant2;
    CabinCrewMember flightAttendant3;
    CabinCrewMember flightAttendant4;
    CabinCrewMember coPilot;
    ArrayList<CabinCrewMember> flightCrew;
    Plane plane;
    FlightManager flightManager;
    LocalDateTime departureTime;

    @Before
    public void before(){
        passenger = new Passenger("Wesley Snipes", 1);
        passenger2 = new Passenger("Christopher Lambert", 3);
        passenger3 = new Passenger("Scooby", 0);
        passenger4 = new Passenger("Daytona", 0);
        passenger5 = new Passenger("Zoolander", 0);
        passenger6 = new Passenger("Howard the duck", 0);
        passenger7 = new Passenger("Peter Parker", 0);
        passenger8 = new Passenger("Dracula", 0);
        passenger9 = new Passenger("Francie", 0);
        passenger10 = new Passenger("Jocie", 0);
        passenger11 = new Passenger("Billy Madison", 0);
        passenger12 = new Passenger("Edward Scisshorhands", 0);
        passenger13 = new Passenger("Samuel L Snakes on a mfunkin plane Jackson", 0);
        flightAttendant1 = new CabinCrewMember("John Jackson", Rank.LeadFlightAttendant);
        flightAttendant2 = new CabinCrewMember("Jan Jackson", Rank.FlightAttendant);
        flightAttendant3 = new CabinCrewMember("James Jackson", Rank.FlightAttendant);
        flightAttendant4 = new CabinCrewMember("Jimmy Jackson", Rank.FlightAttendant);
        coPilot = new CabinCrewMember("Danny DeVito", Rank.CoPilot);
        pilot = new Pilot("Leslie Nielsen", 12345);
        CabinCrewMember[] crew = {flightAttendant1, flightAttendant2, flightAttendant3, flightAttendant4, coPilot, pilot};
        flightCrew = new ArrayList<>();
        for(CabinCrewMember member : crew){
            flightCrew.add(member);
        }
        plane = new Plane(Type.Boeing747);
        departureTime = LocalDateTime.of(2021, Month.AUGUST, 15, 12, 45);
        flight = new Flight(flightCrew, plane, "145TY", "ANT", "GLA", departureTime);
        flightManager = new FlightManager(flight);
    }

    @Test
    public void hasPlane() {
        assertEquals(plane, flight.getPlane());
    }

    @Test
    public void hasFlightNumber() {
        assertEquals("145TY", flight.getFlightNumber());
    }

    @Test
    public void hasDestination() {
        assertEquals("ANT", flight.getDestination());
    }

    @Test
    public void hasDepartureAirport() {
        assertEquals("GLA", flight.getDepartureAirport());
    }

    @Test
    public void hasDepartureTime() {
        assertEquals(departureTime, flight.getDepartureTime());
    }

    @Test
    public void canGetNumberOfSeats(){
        assertEquals(12,flight.getNumberOfSeats());
    }

    @Test
    public void canAddPassenger(){
        flight.addPassenger(passenger);
        assertEquals(1, flight.getPassengerCount());
    }

    @Test
    public void cantAddPassengerDueToCapacity() {
        Passenger[] passengers = {passenger, passenger2, passenger3, passenger4, passenger5, passenger6,
        passenger7, passenger8,passenger9,passenger10,passenger11,passenger12,passenger13,};
        for(Passenger passenger : passengers){
            flight.addPassenger(passenger);
        }
        assertEquals(12, flight.getPassengerCount());
    }

    @Test
    public void canAddPassengerFlightNo() {
        flight.addPassenger(passenger);
        assertEquals("145TY", passenger.getFlightNo());
    }

    @Test
    public void canGetTotalBaggageAllowance() {
        assertEquals(50.00,flightManager.getTotalBaggageAllowance(), 0.0);
    }

    @Test
    public void canGetBaggageWeightPerPassenger() {
        assertEquals(4.16, flightManager.getBaggageWeightReservedPerPassenger(), 0.1);
    }

    @Test
    public void canGetTotalBaggageWeightBookedPassengers() {
        flight.addPassenger(passenger);
        flight.addPassenger(passenger2);
        assertEquals(20, flightManager.getBaggageWeightBookedPassengers());
    }

    @Test
    public void canGetRemainingBaggageWeightForFlight() {
        flight.addPassenger(passenger);
        flight.addPassenger(passenger2);
        assertEquals(30.00, flightManager.getRemainingWeightforFlight(), 0.0);
    }

    @Test
    public void canAssignSeatNumberToPassenger() {
        flight.addPassenger(passenger);
        assertEquals(true, flight.checkIfSeatExists(passenger.getSeatNo()));
    }

    @Test
    public void willNotDoubleBook(){
        Passenger[] passengers = {passenger, passenger2, passenger3, passenger4, passenger5, passenger6,
                passenger7, passenger8,passenger9,passenger10,passenger11,passenger12,passenger13,};
        for(Passenger passenger : passengers){
            flight.addPassenger(passenger);
        }
        assertEquals(false, flight.checkForDoubleBookings());
    }
}
