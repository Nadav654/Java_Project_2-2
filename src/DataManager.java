import java.util.ArrayList;

public class DataManager {
    public static ArrayList<Property> inputData() {
        ArrayList<Property> properties = new ArrayList<>();

        properties.add(new Plot("Tel Aviv, Rothschild 10", 500, 2000000, Plot.Type.URBAN));
        properties.add(new Plot("Haifa, Herzl 15", 1000, 3000000, Plot.Type.INDUSTRIAL));

        // 2 דירות מגורים
        properties.add(new Apartment("Jerusalem, King George 18", 100, 1500000, 1, 3));
        properties.add(new Apartment("Ramat Gan, Bialik 23", 80, 1200000, 2, 2));

        // 2 וילות
        properties.add(new Villa("Kfar Saba, Weitzman 12", 300, 5000000, 3, 2));
        properties.add(new Villa("Herzliya, Hayarkon 1", 400, 8000000, 4, 3));

        // 2 דירות נופש
        properties.add(new Vacation("Eilat, Coral Beach 5", 200, 2500000, 2, 8));
        properties.add(new Vacation("Dead Sea, Ein Bokek 10", 150, 1800000, 1, 6));

        // 2 נדל״ן מסחרי
        properties.add(new Commercial("Ashdod, Ben Gurion 33", 300, 4000000, true, 6.5));
        properties.add(new Commercial("Be'er Sheva, Rager 50", 250, 3500000, false, 5.0));

        // 2 משרדים
        properties.add(new Office("Netanya, Independence 3", 200, 3000000));
        properties.add(new Office("Ashkelon, Barnea 17", 180, 2500000));

        return properties;
    }
}
