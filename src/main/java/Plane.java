public class Plane {

    private Type type;

    public Plane(Type type) {
        this.type = type;
    }

    public int getCapacity(){
        return type.getCapacity();
    }

    public double getWeight(){
        return type.getWeight();
    }

    public String getManufacturer(){
        return type.getManufacturer();
    }

    public String getModel(){
        return type.getModel();
    }

}
