package sg.edu.rp.c346.id18015871.fyp.Model;

import android.content.ContentValues;
import android.os.Parcel;
import android.os.Parcelable;


import sg.edu.rp.c346.id18015871.fyp.Database.Sql;

public class StudentUser {
    private int id;
    private String name;
    private int contactNumber;
    private String school;
    private String emailAddress;
    private String dob;
    private String password;
    private String InstructorName;
    private String Date1;
    private int Slot1;
    private String Date2;
    private int Slot2;
    private String Date3;
    private int Slot3;
    private String iid;
    private int instContactNo;


    public StudentUser(int id, String name,
                       int contactNumber, String school,
                       String emailAddress, String dob,
                       String password, String instructorName,
                       String date1, int slot1, String date2,
                       int slot2, String date3, int slot3
    , String iid, int instContactNo) {
        this.id = id;
        this.instContactNo = instContactNo;
        this.iid = iid;
        this.name = name;
        this.contactNumber = contactNumber;
        this.school = school;
        this.emailAddress = emailAddress;
        this.dob = dob;
        this.password = password;
        InstructorName = instructorName;
        Date1 = date1;
        Slot1 = slot1;
        Date2 = date2;
        Slot2 = slot2;
        Date3 = date3;
        Slot3 = slot3;
    }

    public StudentUser() {

    }

    public int getInstContactNo() {
        return instContactNo;
    }

    public void setInstContactNo(int instContactNo) {
        this.instContactNo = instContactNo;
    }
    public String getIid() {
        return iid;
    }

    public void setIid(String iid) {
        this.iid = iid;
    }

    public String getInstructorName() {
        return InstructorName;
    }

    public void setInstructorName(String instructorName) {
        InstructorName = instructorName;
    }

    public String getDate1() {
        return Date1;
    }

    public void setDate1(String date1) {
        Date1 = date1;
    }

    public int getSlot1() {
        return Slot1;
    }

    public void setSlot1(int slot1) {
        Slot1 = slot1;
    }

    public String getDate2() {
        return Date2;
    }

    public void setDate2(String date2) {
        Date2 = date2;
    }

    public int getSlot2() {
        return Slot2;
    }

    public void setSlot2(int slot2) {
        Slot2 = slot2;
    }

    public String getDate3() {
        return Date3;
    }

    public void setDate3(String date3) {
        Date3 = date3;
    }

    public int getSlot3() {
        return Slot3;
    }

    public void setSlot3(int slot3) {
        Slot3 = slot3;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(int contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ContentValues toValues() {
        ContentValues values = new ContentValues(14);

        values.put(Sql.COLUMN_ID, id);
        values.put(Sql.COLUMN_NAME, name);
        values.put(Sql.COLUMN_contactNumber, contactNumber);
        values.put(Sql.COLUMN_school, school);
        values.put(Sql.COLUMN_emailAddress, emailAddress);
        values.put(Sql.COLUMN_dob, dob);
        values.put(Sql.COLUMN_password, password);
        values.put(Sql.COLUMN_InstructorName, InstructorName);
        values.put(Sql.COLUMN_Date1, Date1);
        values.put(Sql.COLUMN_Slot1, Slot1);
        values.put(Sql.COLUMN_Date2, Date2);
        values.put(Sql.COLUMN_Slot2, Slot2);
        values.put(Sql.COLUMN_Date3, Date3);
        values.put(Sql.COLUMN_Slot3, Slot3);

        return values;
    }

    @Override
    public String toString() {
        return "StudentUser{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", ContactNumber='" + contactNumber + '\'' +
                ", School='" + school + '\'' +
                ", EmailAddress=" + emailAddress +
                ", DateOfBirth=" + dob +
                ", Password='" + password + '\'' +
                ", InstructorName='" + InstructorName + '\'' +
                ", Date1='" + Date1 + '\'' +
                ", Slot1='" + Slot1 + '\'' +
                ", Date2='" + Date2 + '\'' +
                ", Slot2='" + Slot2 + '\'' +
                ", Date3='" + Date3 + '\'' +
                ", Slot3='" + Slot3 + '\'' +
                '}';
    }

    // @Override
    public int describeContents() {
        return 0;
    }

     //@Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.id);
        dest.writeString(this.name);
        dest.writeInt(this.contactNumber);
        dest.writeString(this.school);
        dest.writeString(this.emailAddress);
        dest.writeString(this.dob);
        dest.writeString(this.password);
        dest.writeString(this.InstructorName);
        dest.writeString(this.Date1);
        dest.writeInt(this.Slot1);
        dest.writeString(this.Date2);
        dest.writeInt(this.Slot2);
        dest.writeString(this.Date3);
        dest.writeInt(this.Slot3);
    }

    protected StudentUser(Parcel in) {
        this.id = in.readInt();
        this.name = in.readString();
        this.contactNumber = in.readInt();
        this.school = in.readString();
        this.emailAddress = in.readString();
        this.dob = in.readString();
        this.password = in.readString();
        this.InstructorName = in.readString();
        this.Date1 = in.readString();
        this.Slot1 = in.readInt();
        this.Date2 = in.readString();
        this.Slot2 = in.readInt();
        this.Date3 = in.readString();
        this.Slot3 = in.readInt();
    }

    public static final Parcelable.Creator<StudentUser> CREATOR = new Parcelable.Creator<StudentUser>() {
        @Override
        public StudentUser createFromParcel(Parcel source) {
            return new StudentUser(source);
        }

         @Override
        public StudentUser[] newArray(int size) {
            return new StudentUser[size];
        }
    };
}
