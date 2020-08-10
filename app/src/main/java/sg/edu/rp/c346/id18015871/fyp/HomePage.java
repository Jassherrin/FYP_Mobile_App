package sg.edu.rp.c346.id18015871.fyp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomePage extends AppCompatActivity {
    Button btnBooking;
    Button btnStatus;
    Button btnVCalendar;
    Button btnLogout;
    Button btnLink;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        btnBooking = findViewById(R.id.buttonBooking);
        btnStatus = findViewById(R.id.buttonStatus);
        btnVCalendar = findViewById(R.id.buttonCalendar);
        btnLogout = findViewById(R.id.buttonLogout);
        btnLink =findViewById(R.id.buttonLink);


        btnBooking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(HomePage.this, StudentBooking.class);

                startActivity(intent);

            }

        });

        btnVCalendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(HomePage.this, viewCalendar.class);

                startActivity(intent);

            }

        });

        btnStatus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(HomePage.this, BookingStatus.class);

                startActivity(intent);

            }

        });

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(HomePage.this, MainActivity.class);

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

    }
}