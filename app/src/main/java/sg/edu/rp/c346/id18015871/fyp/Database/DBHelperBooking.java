package sg.edu.rp.c346.id18015871.fyp.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelperBooking extends SQLiteOpenHelper {
    public static final String DB_FILE_NAME="StudentBooking.dbo";
    public static final int DB_VERSION=1;

    public DBHelperBooking( Context context) {
        super(context, DB_FILE_NAME, null , DB_VERSION);
    }

    @Override
    public void onCreate(final SQLiteDatabase db) {
        db.execSQL(SqlBooking.SQL_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SqlBooking.SQL_DELETE);
        onCreate(db);
    }
}