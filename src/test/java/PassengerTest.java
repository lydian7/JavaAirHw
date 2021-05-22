import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PassengerTest {

    Passenger passenger;

    @Before
    public void before(){
        passenger = new Passenger("Ahmet Giritli", 2);
    }

    @Test
    public void canGetName(){
        assertEquals("Ahmet Giritli", passenger.getName());
    }

    @Test
    public void canGetNoOfBags() {
        assertEquals(2, passenger.getNoOfBags());
    }

    @Test
    public void canGetFlightNo() {
        assertEquals(null, passenger.getFlightNo());
    }

    @Test
    public void canSetFlightNo() {
        passenger.setFlightNo("TK235");
        assertEquals("TK235", passenger.getFlightNo());
    }

    @Test
    public void canGetBagsTotalWeight() {
        assertEquals(10, passenger.getBagsTotalWeight());
    }
}
