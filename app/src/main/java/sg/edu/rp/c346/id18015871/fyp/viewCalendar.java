package sg.edu.rp.c346.id18015871.fyp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import sg.edu.rp.c346.id18015871.fyp.Database.DataSource;
import sg.edu.rp.c346.id18015871.fyp.Database.DataSourceBooking;
import sg.edu.rp.c346.id18015871.fyp.Model.Booking;
import sg.edu.rp.c346.id18015871.fyp.Model.StudentUser;
import sg.edu.rp.c346.id18015871.fyp.Sample.DataProviderBooking;
import sg.edu.rp.c346.id18015871.fyp.Sample.SampleDataProvider;

public class viewCalendar extends AppCompatActivity {
    CalendarView cal;

    Button btnHome;
    Button btnStatus;
    Button btnBooking;
    Button btnLogout;

    Button btnLink;
    Button btnContact;

    DataSource database;
    DataSourceBooking database1;

    List<StudentUser> StudentUserList = SampleDataProvider.dataItemList;

    List<Booking> booking = DataProviderBooking.dataItemList1;
    List<Booking> listFromDB =new ArrayList<>();
    String category;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_calendar);

        database=new DataSource(this);
        database.open();

        database1=new DataSourceBooking(this);
        database1.open();

        database.seedDatabase(StudentUserList);
        database1.seedDatabase1(booking);

        cal=findViewById(R.id.calendarView21);
        btnHome = findViewById(R.id.buttonHome);
        btnStatus = findViewById(R.id.buttonStatus);
        btnBooking = findViewById(R.id.buttonBooking);
        btnLogout = findViewById(R.id.buttonLogout);

        btnLink =findViewById(R.id.buttonLink);
        btnContact = findViewById(R.id.buttonContact);
    //    listFromDB = database1.getAllItems1(category);




        cal.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView calendarView, int i, int i1, int i2) {
                int v=i1+1;
                String cc=""+i2+"/"+v+"/"+i+"";
                int r=0;
                String msg="";
              while(r<booking.size()){
                  if(booking.get(r).getHeDate().equals(cc)) {
                      msg="Selected Date:\n" + booking.get(r).getHeDate()+"\n There are  pending bookings today";
                  }
                  if(!booking.get(r).getHeDate().equals(cc)) {
                      msg="Selected Date:\n" + cc + "\n There are no bookings made today";
                  }
                    r++;
                }
                Toast.makeText(getApplicationContext(), msg , Toast.LENGTH_SHORT).show();
            }
        });

        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(viewCalendar.this, HomePage.class);

                startActivity(intent);

            }

        });

        btnBooking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(viewCalendar.this, StudentBooking.class);

                startActivity(intent);

            }

        });

        btnStatus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(viewCalendar.this, BookingStatus.class);

                startActivity(intent);

            }

        });

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(viewCalendar.this, MainActivity.class);

                startActivity(intent);

            }

        });
        btnLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Intent. ACTION_VIEW, Uri.parse("https://www.syfc.sg/"));
                startActivity(intent);

            }

        });


        btnContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(viewCalendar.this, ContactList.class);

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
