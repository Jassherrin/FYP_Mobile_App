package sg.edu.rp.c346.id18015871.fyp.Database;

public class Sql {
    public static final String TABLE_NAME = "StudentProfile";
    public static final String COLUMN_ID = "Id";
    public static final String COLUMN_NAME = "Name";
    public static final String COLUMN_contactNumber = "ContactNumber";
    public static final String COLUMN_school = "School";
    public static final String COLUMN_emailAddress= "EmailAddress";
    public static final String COLUMN_dob = "DateOfBirth";
    public static final String COLUMN_password = "Password";
    public static final String COLUMN_InstructorName="InstructorName";
    public static final String COLUMN_Date1="Date1";
    public static final String COLUMN_Slot1="Slot1";
    public static final String COLUMN_Date2="Date2";
    public static final String COLUMN_Slot2="Slot2";
    public static final String COLUMN_Date3="Date3";
    public static final String COLUMN_Slot3="Slot3";


    public static final String[] ALL_COLUMNS =
            {COLUMN_ID, COLUMN_NAME, COLUMN_NAME,
                    COLUMN_contactNumber, COLUMN_school, COLUMN_emailAddress,
                    COLUMN_dob,COLUMN_password,COLUMN_InstructorName,COLUMN_Date1,
                    COLUMN_Slot1,COLUMN_Date2,COLUMN_Slot2,COLUMN_Date3,COLUMN_Slot3};

    public static final String SQL_CREATE =
            "CREATE TABLE " + TABLE_NAME + " (" +
                    COLUMN_ID + " INTEGER PRIMARY KEY," +
                    COLUMN_NAME + " TEXT," +
                    COLUMN_contactNumber + " INTEGER," +
                    COLUMN_school + " TEXT," +
                    COLUMN_emailAddress + " TEXT," +
                    COLUMN_dob + " TEXT," +
                    COLUMN_password + " TEXT," +
                    COLUMN_InstructorName+ " TEXT," +
                    COLUMN_Date1+ " TEXT," +
                    COLUMN_Slot1+ " INTEGER," +
                    COLUMN_Date2+ " TEXT," +
                    COLUMN_Slot2+ " INTEGER," +
                    COLUMN_Date3+ " TEXT," +
                    COLUMN_Slot3+ " INTEGER," + " TEXT)";

    public static final String SQL_DELETE = "DROP TABLE IF EXISTS" + TABLE_NAME;


}
