import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class FlightTest {

    Passenger passenger;
    Passenger passenger2;
    Passenger passenger3;
    Flight flight;
    Pilot pilot;
    CabinCrewMember flightAttendant1;
    CabinCrewMember flightAttendant2;
    CabinCrewMember flightAttendant3;
    CabinCrewMember flightAttendant4;
    CabinCrewMember coPilot;
    ArrayList<CabinCrewMember> flightCrew;
    Plane plane;

    @Before
    public void before(){
        passenger = new Passenger("Wesley Snipes", 1);
        passenger2 = new Passenger("Christopher Lambert", 3);
        passenger3 = new Passenger("Homelander", 0);
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
        flight = new Flight(flightCrew, plane, "145TY", "ANT", "GLA", "12:45");
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
        assertEquals("12:45", flight.getDepartureTime());
    }

    @Test
    public void canGetNumberOfSeats(){
        assertEquals(2,flight.getNumberOfSeats());
    }

    @Test
    public void canAddPassenger(){
        flight.addPassenger(passenger);
        assertEquals(1, flight.getPassengerCount());
    }

    @Test
    public void cantAddPassengerDueToCapacity() {
        flight.addPassenger(passenger);
        flight.addPassenger(passenger2);
        flight.addPassenger(passenger3);
        assertEquals(2, flight.getPassengerCount());
    }
}
