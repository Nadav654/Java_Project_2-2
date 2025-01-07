public class Plot extends Property{
    public enum Type {
        URBAN,
        AGRICULTURAL,
        INDUSTRIAL
    };
    private Type type;

    public Plot(String address, double area, double price, Type type) {
        super(address, area, price);
        this.type = type;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    @Override
    public void taxIt() {
        switch (type) {
            case URBAN -> System.out.println("Tax: " + getPrice()*0.1 + " (10%)");
            case INDUSTRIAL -> System.out.println("Tax: " + getPrice()*0.05 + " (5%)");
            case AGRICULTURAL -> System.out.println("Tax: " + getPrice()*0.02 + " (2%)");
        }

    }

    @Override
    public String toString() {
        return "Plot: " + type + ", " + super.toString();
    }
}
