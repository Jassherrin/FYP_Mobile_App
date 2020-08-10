package sg.edu.rp.c346.id18015871.fyp.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import sg.edu.rp.c346.id18015871.fyp.Model.Booking;

public class DataSourceBooking {
    private Context m1Context;
    private SQLiteDatabase database1;
    SQLiteOpenHelper DBHelperBooking;

    public DataSourceBooking(Context context) {
        this.m1Context = context;
        DBHelperBooking=new DBHelperBooking(m1Context);
        database1= DBHelperBooking.getWritableDatabase();
    }
    public void open() {
        database1=DBHelperBooking.getWritableDatabase();
    }
    public void close() {
        DBHelperBooking.close();
    }

    public Booking createItem3(Booking item) {
        ContentValues values = item.toValues2();
        database1.insert(SqlBooking.TABLE_NAME, null, values);
        return item;
    }
    public long getDataItemsCount3() {
        return DatabaseUtils.queryNumEntries(database1, SqlBooking.TABLE_NAME);
    }
    public void seedDatabase1(List<Booking> dataItemList1) {
        long numItems1 = getDataItemsCount3();
        if (numItems1 == 0) {
            for (Booking item1 :
                    dataItemList1) {
                try {
                    createItem3(item1);
                } catch (SQLiteException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    public List<Booking> getAllItems1(String category) {
        List<Booking> dataItems = new ArrayList<>();

        Cursor cursor;
        if (category == null) {
            cursor = database1.query(SqlBooking.TABLE_NAME, SqlBooking.ALL_COLUMNS,
                    null , null, null, null, SqlBooking.COLUMN_DATE);
        } else {
            String[] categories = {category};
            cursor = database1.query(SqlBooking.TABLE_NAME, SqlBooking.ALL_COLUMNS,
                    SqlBooking.COLUMN_HE + "=?", categories, null, null,
                    SqlBooking.COLUMN_TIME);
        }

        while (cursor.moveToNext()) {
            Booking item = new Booking();
            item.setHe(cursor.getString(
                    cursor.getColumnIndex(SqlBooking.COLUMN_HE)));
            item.setHeDate(cursor.getString(
                    cursor.getColumnIndex(SqlBooking.COLUMN_DATE)));
            item.setHeTime(cursor.getString(
                    cursor.getColumnIndex(SqlBooking.COLUMN_TIME)));
            dataItems.add(item);
        }
        cursor.close();
        return dataItems;
    }
}