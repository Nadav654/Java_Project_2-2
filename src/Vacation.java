public class Vacation extends Residential{
    private int guests = 1;

    public Vacation(String address, double area, double price, int parkingLots, int guests) {
        super(address, area, price, parkingLots);
        setGuests(guests);
    }

    public int getGuests() {
        return guests;
    }

    public void setGuests(int guests) {
        if (guests > 1) {
            this.guests = guests;
        }
    }

    @Override
    public void taxIt() {
        System.out.println("Tax: " + getPrice()*0.25 + " (25%)");
    }

    @Override
    public String toString() {
        return "Vacation: guests: " + guests + super.toString();
    }
}
