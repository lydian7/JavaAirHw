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
}
