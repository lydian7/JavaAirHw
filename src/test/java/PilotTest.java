import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PilotTest {

    Pilot pilot;

    @Before
    public void before(){
        pilot = new Pilot("Leslie Nielsen", 15734567);
    }

    @Test
    public void hasName(){
        assertEquals("Leslie Nielsen", pilot.getName());
    }

    @Test
    public void hasLicenseNumber(){
        assertEquals(15734567, pilot.getLicenseNumber());
    }

    @Test
    public void hasRank(){
        assertEquals("Pilot", pilot.getRank());
    }

    @Test
    public void canFlyPlane(){
        assertEquals("I'm flying the plane. Yarp.", pilot.fly());
    }
}
