public enum Type {

    Boeing747(20, 100.00, "Boeing", "747"),
    Airbus343(15, 75.00, "Airbus",  "343");

    private final int capacity;
    private final double weight;
    private final String manufacturer;
    private final String model;

    Type(int capacity, double weight, String manufacturer, String model){
        this.capacity = capacity;
        this.weight = weight;
        this.manufacturer = manufacturer;
        this.model = model;
    }

    public int getCapacity(){
        return capacity;
    }

    public double getWeight(){
        return weight;
    }

    public String getManufacturer(){
        return manufacturer;
    }

    public String getModel(){
        return model;
    }

}
