public class Pilot extends CabinCrewMember{

    private int licenseNumber;

    public Pilot(String name, int licenseNumber) {
        super(name, Rank.Pilot);
        this.licenseNumber = licenseNumber;
    }

    public int getLicenseNumber() {
        return licenseNumber;
    }
}
