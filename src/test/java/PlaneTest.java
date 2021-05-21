import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PlaneTest {

    Plane plane;

    @Before
    public void before() {
        plane = new Plane(Type.Boeing747);
    }

    @Test
    public void hasCapacity() {
        assertEquals(20, plane.getCapacity());

    }

    @Test
    public void hasWeight() {
        assertEquals(100, plane.getWeight(), 0.0);
    }

    @Test
    public void hasManufacturer() {
        assertEquals("Boeing", plane.getManufacturer());
    }

    @Test
    public void hasModel() {
        assertEquals("747", plane.getModel());
    }
}
