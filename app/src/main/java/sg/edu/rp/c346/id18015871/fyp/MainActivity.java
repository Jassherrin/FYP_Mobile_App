package sg.edu.rp.c346.id18015871.fyp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
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


public class MainActivity extends AppCompatActivity {
    Button btnConfirm;
    EditText txtUsername;
    EditText txtPassword;
    CheckBox rememberMe;
   // ArrayList<StudentUser> SUList;
   // ArrayAdapter SUa;
    //early phase
    DataSource database;
    DataSourceBooking database1;
    List<StudentUser> StudentUserList = SampleDataProvider.dataItemList;
    List<Booking> booking = DataProviderBooking.dataItemList1;
    List<StudentUser> listFromDB1;
    List<Booking> listFromDB=new ArrayList<>();
    String category1;
    String category;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        database=new DataSource(this);
        database.open();
        database1=new DataSourceBooking(this);
        database1.open();

        database.seedDatabase(StudentUserList);
        database1.seedDatabase1(booking);

        btnConfirm = findViewById(R.id.buttonLogin);
        txtUsername = findViewById(R.id.editText);
        txtPassword = findViewById(R.id.editText2);
        rememberMe = findViewById(R.id.checkBox);
        listFromDB1 = database.getAllItems(category);
    //    listFromDB = database1.getAllItems1(category1);

       // SUList.add(new StudentUser(1,"Sam",98254106,"RP",
              //   "sam@gmail.com","11/1/2000","Ck0kaHBWTdM="));
      //  SUa= new ArrayAdapter(this,R.layout.activity_main,SUList);  //Early phase

        btnConfirm.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                 if (txtUsername.length()>0 && txtPassword.length()>0) { //Making sure the username and password fields are filled
                   //Making sure the password is in the StudentUser class
                    String usr= txtUsername.getText().toString();
                    String pass= txtPassword.getText().toString();

                     for (int i=0; i<listFromDB1.size();i++){
                          if (listFromDB1.get(i).getName().equals(usr)) { //Making sure the username field is filled
                             if (listFromDB1.get(i).getPassword().equals(pass)) { //Making sure the password field is filled
                                 Intent intent = new Intent(MainActivity.this, HomePage.class);
                                 startActivity(intent); //This makes the app Login to the home page
                             }
                             else{
                                 Toast.makeText(MainActivity.this, "Invalid Password", Toast.LENGTH_SHORT).show();
                             } //Making sure the password field is filled
                         }
                          else {
                              Toast.makeText(MainActivity.this, "Invalid Username", Toast.LENGTH_SHORT).show();
                          } //Making sure the username field is filled
                     }
            } //Making sure the username and password fields are filled
                 else {
                    Toast.makeText(MainActivity.this, "Username or password field has not been entered", Toast.LENGTH_SHORT).show();
                 }
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        database.close();
        database1.close();
        String usr= txtUsername.getText().toString();
        String pass= txtPassword.getText().toString();
        if (rememberMe.isChecked()) {
            //Step 1a: Obtain an instance of the SharedPreferences
            SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);

            //Step 1b: Obtain an instance of the SharedPreference Editor for update later
            SharedPreferences.Editor prefEdit =prefs.edit();

            //Step 1c: Add the key-value pair
            prefEdit.putString("savedUserName",usr);
            prefEdit.putString("savedPassword",pass);

            //Step 1d: Call commit() to save the changes into SharedPreferences
            prefEdit.commit();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        database.open();
        database1.open();
        if (rememberMe.isChecked()) {
            //Step 2a: Obtain an instance of SharedPreferences
            SharedPreferences prefs =PreferenceManager.getDefaultSharedPreferences(this);

            //Step 2b: Retrieve the saved data with the key "greeting" from the SharedPreference object

            String user=prefs.getString("savedUserName","");
            String password=prefs.getString("savedPassword","");
            txtUsername.setText(user);
            txtPassword.setText(password);
        }
        Toast toast = Toast.makeText(MainActivity.this,"Hello! Welcome back!",Toast.LENGTH_SHORT);
        toast.show();
    }
}