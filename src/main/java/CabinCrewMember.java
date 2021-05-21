public class CabinCrewMember extends Person{

    Rank rank;

    public CabinCrewMember(String name, Rank rank) {
        super(name);
        this.rank = rank;
    }

    public String getRank() {
        return rank.getRank();
    }
}
