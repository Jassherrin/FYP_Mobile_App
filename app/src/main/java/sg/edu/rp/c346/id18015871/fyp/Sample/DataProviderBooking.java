package sg.edu.rp.c346.id18015871.fyp.Sample;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import sg.edu.rp.c346.id18015871.fyp.Model.Booking;

public class DataProviderBooking {
    public static List<Booking> dataItemList1;
    public static Map<String, Booking> dataItemMap1;

    static {
        dataItemList1 = new ArrayList<>();
        dataItemMap1 = new HashMap<>();
      //  addItem(new Booking(null,"27/8/2020","9:30"));
    }
    private static void addItem(Booking item) {
        dataItemList1.add(item);
        dataItemMap1.put(item.getHe(), item);
    }
}