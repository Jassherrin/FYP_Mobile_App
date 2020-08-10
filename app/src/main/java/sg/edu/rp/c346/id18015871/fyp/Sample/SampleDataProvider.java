package sg.edu.rp.c346.id18015871.fyp.Sample;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import sg.edu.rp.c346.id18015871.fyp.Model.StudentUser;

public class SampleDataProvider {
    public static List<StudentUser> dataItemList;
    public static Map<String, StudentUser> dataItemMap;

    static {
        dataItemList = new ArrayList<>();
        dataItemMap = new HashMap<>();
        addItem(new StudentUser(1, "Sam", 98254106,
                "RP", "sam@gmail.com", "11/1/2000",
                "123456","Tom","27/8/2020",
                10,"28/8/2020",10,
                "29/8/2020",10,null,98521475));
    }
    private static void addItem(StudentUser item) {
        dataItemList.add(item);
        dataItemMap.put(item.getIid(), item);
    }

}
