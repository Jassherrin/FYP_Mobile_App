package sg.edu.rp.c346.id18015871.fyp;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import sg.edu.rp.c346.id18015871.fyp.Database.DataSource;
import sg.edu.rp.c346.id18015871.fyp.Database.DataSourceBooking;
import sg.edu.rp.c346.id18015871.fyp.Model.Booking;
import sg.edu.rp.c346.id18015871.fyp.Model.StudentUser;
import sg.edu.rp.c346.id18015871.fyp.Sample.DataProviderBooking;
import sg.edu.rp.c346.id18015871.fyp.Sample.SampleDataProvider;

public class StudentBooking extends AppCompatActivity {
    DatePicker dp;
    TimePicker tp;

    DataSource database;
    DataSourceBooking database1;

    Button btnConfirm;
    Button btnHome;
    Button btnStatus;
    Button btnVCalendar;
    Button btnLogout;
    EditText instructor;
    EditText student;
    EditText studentid;
    List<StudentUser> StudentUserList = SampleDataProvider.dataItemList;
    List<StudentUser> listFromDB1;
    String category1;

    List<Booking> booking = DataProviderBooking.dataItemList1;

    List<Booking> listFromDB=new ArrayList<>();
    String category;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_booking);

        database=new DataSource(this);
        database.open();

        database1=new DataSourceBooking(this);
        database1.open();

        database.seedDatabase(StudentUserList);

        database1.seedDatabase1(booking);

        dp = findViewById(R.id.datePicker);
        tp = findViewById(R.id.timePicker);

        btnConfirm = findViewById(R.id.buttoncfrm);
        btnHome = findViewById(R.id.buttonHome);
        btnStatus = findViewById(R.id.buttonStatus);
        btnVCalendar = findViewById(R.id.buttonCalendar);
        btnLogout = findViewById(R.id.buttonLogout);
        instructor=findViewById(R.id.editTextGrpSize);
        student=findViewById(R.id.editTextName);
        studentid=findViewById(R.id.editTextMobile);
      //  listFromDB = database1.getAllItems1(category);
        listFromDB1 = database.getAllItems(category1);

        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View v) {
                for (int i=0; i<listFromDB1.size();i++){
                    String inst = instructor.getText().toString();
                    String stu = student.getText().toString();
                    String stuid = studentid.getText().toString();
                    String hm=""+listFromDB1.get(i).getId()+"";
                    if (listFromDB1.get(i).getName().equals(stu)) { //Making sure the name entered matches the database
                        if (hm.equals(stuid)) { //Making sure the id entered matches the database
                            if(listFromDB1.get(i).getInstructorName().equals(inst)) { //Making sure the instructor's name entered matches the database
                                Calendar now =Calendar.getInstance();
                                int year = now.get(Calendar.YEAR);
                                int month = now.get(Calendar.MONTH);
                                int day = now.get(Calendar.DAY_OF_MONTH);
                                if(dp.getDayOfMonth()<=day
                                        && dp.getMonth()<=month
                                        && dp.getYear()<=year) {  //Making sure that the day that is booked isn't on the day itself or on a previous date
                                    Toast.makeText(StudentBooking.this, "Invalid Booking!", Toast.LENGTH_LONG).show();
                                } //Making sure that the day that is booked isn't on the day itself or on a previous date
                                else {
                                    String dd = dp.getDayOfMonth()+"/"+(dp.getMonth()+1)+"/"+dp.getYear();
                                    String tt = tp.getHour()+":"+tp.getMinute();
                                    Booking item1 = new Booking(null,dd,tt );
                                    booking.add(item1);
                                    Toast.makeText(StudentBooking.this, "Booking made", Toast.LENGTH_LONG).show();
                                } //Adds the booking~
                            }
                            else {
                                Toast.makeText(StudentBooking.this, "Invalid Instructor name", Toast.LENGTH_SHORT).show();
                            } //Making sure the instructor's name entered matches the database
                        }
                        else{
                            Toast.makeText(StudentBooking.this, "Invalid id", Toast.LENGTH_SHORT).show();
                        } //Making sure the id entered matches the database
                    }
                    else {
                        Toast.makeText(StudentBooking.this, "Invalid Student Name", Toast.LENGTH_SHORT).show();
                    } //Making sure the name entered matches the database
                }
            }

        });

        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StudentBooking.this, HomePage.class);
                startActivity(intent);
            }

        });
        btnVCalendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StudentBooking.this, viewCalendar.class);
                startActivity(intent);
            }

        });
        btnStatus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StudentBooking.this, BookingStatus.class);
                startActivity(intent);
            }

        });
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StudentBooking.this, MainActivity.class);
                startActivity(intent);
            }

        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        database.close();
        database1.close();
    }
    @Override
    protected void onResume() {
        super.onResume();
        database.open();
        database1.open();
    }
}