package sg.edu.rp.c346.id18015871.fyp.Database;

public class SqlBooking {
    public static final String TABLE_NAME = "StudentBooking";
    public static final String COLUMN_HE = "Id";
    public static final String COLUMN_DATE = "Date";
    public static final String COLUMN_TIME = "Time";


    public static final String SQL_CREATE =
            "CREATE TABLE " + TABLE_NAME + " (" +
                    COLUMN_HE +"TEXT"+
                    COLUMN_DATE + " TEXT," +
                    COLUMN_TIME  + " TEXT)";

    public static final String[] ALL_COLUMNS =
            {COLUMN_HE, COLUMN_DATE, COLUMN_TIME};

    public static final String SQL_DELETE = "DROP TABLE IF EXISTS" + TABLE_NAME;

}