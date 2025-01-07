public abstract class Property {
    private String address;
    private double area;
    private double price;

    public Property(String address, double area, double price) {
        setAddress(address);
        setArea(area);
        setPrice(price);
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        if (address == null  || address.equals("") || !address.contains(" ")) {
            address = "Na, na";
        }
        this.address = address;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        if (area < 0) {
            area = 0;
        }
        this.area = area;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price < 0) {
            price = 0;
        }
        this.price = price;
    }

    public abstract void taxIt();

    @Override
    public String toString() {
        return "Property: " +
                "address: '" + address + '\'' +
                ", area: " + area +
                ", price: " + price;
    }
}
