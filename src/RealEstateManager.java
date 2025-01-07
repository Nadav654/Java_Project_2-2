import java.util.ArrayList;

public class RealEstateManager {
    private String name;
    private ArrayList<Property> properties = new ArrayList<>();

    public RealEstateManager(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Property> getProperties() {
        return properties;
    }

    public void setProperties(ArrayList<Property> properties) {
        this.properties = properties;
    }

    public void addProperty(Property property) {
        if (property != null) {
            properties.add(property);
        }
    }

    public ArrayList<Property> getPropertiesByPrice(double maxPrice) {
        ArrayList<Property> filteredProperties = new ArrayList<>();
        for (Property property : properties) {
            if (property.getPrice() <= maxPrice)
                filteredProperties.add(property);
        }
        return filteredProperties;
    }

    public double getTotalPropertiesValue() {
        double sum = 0;
        for (Property property : properties) {
            sum += property.getPrice();
        }
        return sum;
    }
}
