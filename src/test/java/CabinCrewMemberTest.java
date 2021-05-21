import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CabinCrewMemberTest {

    CabinCrewMember crewMember;

    @Before
    public void before(){
        crewMember = new CabinCrewMember("Leslie Nielsen", Rank.FlightAttendant);
    }

    @Test
    public void canGetName() {
        assertEquals("Leslie Nielsen", crewMember.getName());
    }

    @Test
    public void canGetRank() {
        assertEquals("Flight Attendant", crewMember.getRank());
    }
}
