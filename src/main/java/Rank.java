public enum Rank {
    Pilot("Pilot"),
    CoPilot("Co-Pilot"),
    LeadFlightAttendant("Chief Flight Attendant"),
    FlightAttendant("Flight Attendant");

    private final String rank;

    Rank(String rank){
        this.rank = rank;
    }

    public String getRank(){
        return rank;
    }
}
