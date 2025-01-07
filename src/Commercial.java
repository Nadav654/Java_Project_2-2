public class Commercial extends Property{
    private boolean storeRoom = false;
    private double yield = 0.0;

    public Commercial(String address, double area, double price, double yield) {
        super(address, area, price);
        setYield(yield);
    }

    public Commercial(String address, double area, double price, boolean storeRoom, double yield) {
        super(address, area, price);
        this.storeRoom = storeRoom;
        setYield(yield);
    }

    public boolean isStoreRoom() {
        return storeRoom;
    }

    public void setStoreRoom(boolean storeRoom) {
        this.storeRoom = storeRoom;
    }

    public double getYield() {
        return yield;
    }

    public void setYield(double yield) {
        if (yield > 0.0) {
            this.yield = yield;
        }
    }

    public void calculateMonthlyProfit() {
        System.out.println("Monthly profit for this commercial property: " + getPrice() * (yield/100)/12 + "$");
    }

    @Override
    public void taxIt() {
        System.out.println("Tax: " + getPrice()*0.05 + " (5%)");
    }
}
