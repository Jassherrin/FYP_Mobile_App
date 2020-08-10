package sg.edu.rp.c346.id18015871.fyp.Model;

import android.content.ContentValues;
import android.os.Parcel;
import android.os.Parcelable;

import java.util.UUID;

import sg.edu.rp.c346.id18015871.fyp.Database.SqlBooking;

public class Booking {
    String he;
    String heDate;
    String heTime;

    public Booking(String he, String heDate, String heTime) {
        this.heDate = heDate;
        this.heTime = heTime;
        if (he == null) {
            he = UUID.randomUUID().toString();
        }
    }

    public Booking() {

    }

    public String getHe() {
        return he;
    }

    public void setHe(String he) {
        this.he = he;
    }

    public String getHeDate() {
        return heDate;
    }

    public void setHeDate(String heDate) {
        this.heDate = heDate;
    }

    public String getHeTime() {
        return heTime;
    }

    public void setHeTime(String heTime) {
        this.heTime = heTime;
    }
    @Override
    public String toString() {
        return "He:"+he+
                "Date: " + heDate +
                " Time: " + heTime
                +"Pending";
    }
    // @Override
    public int describeContents() {
        return 0;
    }

    //@Override
    public void writeToParcel(Parcel dest, int flags) {

        dest.writeString(this.he);
        dest.writeString(this.heDate);
        dest.writeString(this.heTime);

    }

    protected Booking(Parcel in) {

        this.he = in.readString();
        this.heDate = in.readString();
        this.heTime = in.readString();

    }

    public static final Parcelable.Creator<Booking> CREATOR = new Parcelable.Creator<Booking>() {
        @Override
        public Booking createFromParcel(Parcel source) {
            return new Booking(source);
        }

        @Override
        public Booking[] newArray(int size) {
            return new Booking[size];
        }
    };


    public ContentValues toValues2() {
        ContentValues values = new ContentValues(3);

        values.put(SqlBooking.COLUMN_HE, he);
        values.put(SqlBooking.COLUMN_DATE, heDate);
        values.put(SqlBooking.COLUMN_TIME, heTime);
        return values;
    }
}
