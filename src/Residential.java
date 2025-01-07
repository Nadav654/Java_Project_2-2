public abstract class Residential extends Property{
    private int parkingLots;

    public Residential(String address, double area, double price, int parkingLots) {
        super(address, area, price);
        setParkingLots(parkingLots);
    }

    public int getParkingLots() {
        return parkingLots;
    }

    public void setParkingLots(int parkingLots) {
        if (parkingLots < 0) {
            parkingLots = 0;
        }
        this.parkingLots = parkingLots;
    }

    @Override
    public void taxIt() {
        System.out.println("Tax: " + getPrice()*0.08 + "(8%)");
    }

    @Override
    public String toString() {
        return ", Residential: Parking Lots: " + parkingLots + ", " + super.toString();
    }
}
