import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FlightTest {

    Flight flight;
    Pilot pilot;
    Plane plane;

    @Before
    public void before(){
        pilot = new Pilot("Leslie Nielsen", 12345);
        plane = new Plane(Type.Boeing747);
        flight = new Flight(pilot, plane, "145TY", "ANT", "GLA", "12:45");
    }

    @Test
    public void hasPilot(){
        assertEquals(pilot, flight.getPilot());
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
}
