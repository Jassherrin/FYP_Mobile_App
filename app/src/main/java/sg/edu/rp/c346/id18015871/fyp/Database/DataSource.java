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

import sg.edu.rp.c346.id18015871.fyp.Model.StudentUser;

public class DataSource {
    private Context mContext;
    private SQLiteDatabase database;
    SQLiteOpenHelper mdbHelper;

    public DataSource(Context context) {
        this.mContext = context;
        mdbHelper=new DBHelper(mContext);
        database= mdbHelper.getWritableDatabase();



    }

    public void open() {
        database=mdbHelper.getWritableDatabase();
    }
    public void close() {
        mdbHelper.close();
    }

    public StudentUser createItem(StudentUser item) {
        ContentValues values = item.toValues();
        database.insert(Sql.TABLE_NAME, null, values);
        return item;
    }
    public long getDataItemsCount() {
        return DatabaseUtils.queryNumEntries(database, Sql.TABLE_NAME);
    }
    public void seedDatabase(List<StudentUser> dataItemList) {
        long numItems = getDataItemsCount();
        if (numItems == 0) {
            for (StudentUser item :
                    dataItemList) {
                try {
                    createItem(item);
                } catch (SQLiteException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    public List<StudentUser> getAllItems(String category) {
        List<StudentUser> dataItems = new ArrayList<>();

        Cursor cursor;
        if (category == null) {
            cursor = database.query(Sql.TABLE_NAME, Sql.ALL_COLUMNS,
                    null, null, null, null, Sql.COLUMN_NAME);
        } else {
            String[] categories = {category};
           cursor = database.query(Sql.TABLE_NAME, Sql.ALL_COLUMNS,
                   Sql.COLUMN_ID + "=?", categories, null, null,
                   Sql.COLUMN_contactNumber);
        }

        while (cursor.moveToNext()) {
            StudentUser item = new StudentUser();
            item.setId(cursor.getInt(
                    cursor.getColumnIndex(Sql.COLUMN_ID)));
            item.setName(cursor.getString(
                    cursor.getColumnIndex(Sql.COLUMN_NAME)));
            item.setContactNumber(cursor.getInt(
                    cursor.getColumnIndex(Sql.COLUMN_contactNumber)));
            item.setSchool(cursor.getString(
                    cursor.getColumnIndex(Sql.COLUMN_school)));
            item.setEmailAddress(cursor.getString(
                    cursor.getColumnIndex(Sql.COLUMN_emailAddress)));
            item.setDob(cursor.getString(
                    cursor.getColumnIndex(Sql.COLUMN_dob)));
            item.setPassword(cursor.getString(
                    cursor.getColumnIndex(Sql.COLUMN_password)));
            item.setInstructorName(cursor.getString(
                    cursor.getColumnIndex(Sql.COLUMN_InstructorName)));
            item.setDate1(cursor.getString(
                    cursor.getColumnIndex(Sql.COLUMN_Date1)));
            item.setSlot1(cursor.getInt(
                    cursor.getColumnIndex(Sql.COLUMN_Slot1)));
            item.setDate2(cursor.getString(
                    cursor.getColumnIndex(Sql.COLUMN_Date2)));
            item.setSlot2(cursor.getInt(
                    cursor.getColumnIndex(Sql.COLUMN_Slot2)));
            item.setDate3(cursor.getString(
                    cursor.getColumnIndex(Sql.COLUMN_Date3)));
            item.setSlot3(cursor.getInt(
                    cursor.getColumnIndex(Sql.COLUMN_Slot3)));
            dataItems.add(item);
        }
        cursor.close();
        return dataItems;
    }
}
