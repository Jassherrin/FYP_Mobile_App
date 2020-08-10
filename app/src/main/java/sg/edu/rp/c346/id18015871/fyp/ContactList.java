package sg.edu.rp.c346.id18015871.fyp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import sg.edu.rp.c346.id18015871.fyp.Database.DataSource;
import sg.edu.rp.c346.id18015871.fyp.Model.StudentUser;
import sg.edu.rp.c346.id18015871.fyp.Sample.SampleDataProvider;

public class ContactList extends AppCompatActivity {

        Button btnNo;
        Button btnStatus;
        TextView txt;

        DataSource database;
        List<StudentUser> StudentUserList = SampleDataProvider.dataItemList;
        List<StudentUser> listFromDB1;
        String category1;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_contact_list);
            btnNo=findViewById(R.id.buttonMobileNumber);
            btnStatus = findViewById(R.id.buttonStatus);
            txt= findViewById(R.id.textViewInstructorName);

            database=new DataSource(this);
            database.open();
            database.seedDatabase(StudentUserList);
            listFromDB1 = database.getAllItems(category1);

            for (int i=0; i<listFromDB1.size();i++) {
                txt.setText(listFromDB1.get(i).getInstructorName());

            }

            btnNo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Code for the action
                    Intent intentCall =new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + StudentUserList.get(0).getInstContactNo()));
                    startActivity(intentCall);
                }
            });



            btnStatus.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent intent = new Intent(ContactList.this, BookingStatus.class);

                    startActivity(intent);

                }

            });
        }
    @Override
    protected void onPause() {
        super.onPause();
        database.close();
    }

    @Override
    protected void onResume() {
        super.onResume();
        database.open();
    }

}
