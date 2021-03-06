package sg.edu.rp.c346.id18015871.fyp.Database;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;



public class DBHelper extends SQLiteOpenHelper {
    public static final String DB_FILE_NAME="StudentProfile.dbo";
    public static final int DB_VERSION=1;

    public DBHelper( Context context) {
        super(context, DB_FILE_NAME, null , DB_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Sql.SQL_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(Sql.SQL_DELETE);
        onCreate(db);
    }
}
