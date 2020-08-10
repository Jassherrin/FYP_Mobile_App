package sg.edu.rp.c346.id18015871.fyp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import sg.edu.rp.c346.id18015871.fyp.Database.DataSource;
import sg.edu.rp.c346.id18015871.fyp.Database.DataSourceBooking;
import sg.edu.rp.c346.id18015871.fyp.Model.Booking;
import sg.edu.rp.c346.id18015871.fyp.Model.StudentUser;
import sg.edu.rp.c346.id18015871.fyp.Sample.DataProviderBooking;
import sg.edu.rp.c346.id18015871.fyp.Sample.SampleDataProvider;

public class BookingStatus extends AppCompatActivity {
    Button btnBooking;
    Button btnHome;
    Button btnVCalendar;
    Button btnLogout;
    Button btnDel;

    EditText etDate;
    EditText etTime;

    ArrayList<String> text;
    ArrayList<String> text1;
    List<Booking> listFromDB =new ArrayList<>();
    CustomAdapter adapter;

    DataSource database;
    DataSourceBooking database1;
    List<StudentUser> StudentUserList = SampleDataProvider.dataItemList;
    List<Booking> booking= DataProviderBooking.dataItemList1;
    RecyclerView mRecyclerView;
    String category2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_booking_status);
        btnBooking = findViewById(R.id.buttonBooking);
        btnHome = findViewById(R.id.buttonHome);
        btnVCalendar = findViewById(R.id.buttonCalendar);
        btnLogout = findViewById(R.id.buttonLogout);

        etDate = findViewById(R.id.editTextDate);
        etTime = findViewById(R.id.editTextTime);

        mRecyclerView = findViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        database=new DataSource(this);
        database.open();
        database1=new DataSourceBooking(this);
        database1.open();

        database.seedDatabase(StudentUserList);
        database1.seedDatabase1(booking);

      //  listFromDB = database1.getAllItems1(category2);

        adapter = new CustomAdapter(BookingStatus.this, booking);
        mRecyclerView.setAdapter(adapter);

        btnBooking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(BookingStatus.this, StudentBooking.class);

                startActivity(intent);

            }

        });


        btnVCalendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(BookingStatus.this, viewCalendar.class);

                startActivity(intent);

            }

        });

        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(BookingStatus.this, HomePage.class);

                startActivity(intent);

            }

        });


        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(BookingStatus.this, MainActivity.class);

                startActivity(intent);

            }

        });
        btnDel=findViewById(R.id.buttonDeleteBooking);
        btnDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int i=0;
                String msg= "";
                while (i<booking.size()) {
                    String dt=etDate.getText().toString();
                    String Tm=etTime.getText().toString();
                    if(booking.get(i).getHeDate().equals(dt)){
                        if(booking.get(i).getHeTime().equals(Tm)) {
                            booking.remove(i);
                            adapter = new CustomAdapter(BookingStatus.this, booking);
                            mRecyclerView.setAdapter(adapter);
                            msg ="You have successfully deleted the booking";
                        }
                        else{
                            msg ="Invalid time, try re-entering";
                        }
                    }
                    else{
                        msg ="Invalid date, try re-entering";

                    }
                    i++;
                }
                Toast.makeText(BookingStatus.this,msg , Toast.LENGTH_SHORT).show();
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