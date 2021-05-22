public class Passenger extends Person{

    private int noOfBags;
    private String flightNo;
    private String seatNo;

    public Passenger(String name, int noOfBags) {
        super(name);
        this.noOfBags = noOfBags;
        this.flightNo = null;
        this.seatNo = null;
    }

    public int getNoOfBags() {
        return noOfBags;
    }

    public String getFlightNo() {
        return flightNo;
    }

    public void setFlightNo(String flightNo) {
        this.flightNo = flightNo;
    }

    public String getSeatNo() {
        return seatNo;
    }

    public void setSeatNo(String seatNo) {
        this.seatNo = seatNo;
    }

    public int getBagsTotalWeight() {
        return noOfBags * 5;
    }
}
