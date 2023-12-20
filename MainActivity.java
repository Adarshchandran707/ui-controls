package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Date;

public class MainActivity extends AppCompatActivity {
    EditText firstname,lastname,dob,emailid,password;
    RadioButton btn1,btn2,btn3;
    Button login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        firstname = (EditText) findViewById(R.id.fn);
        lastname = (EditText) findViewById(R.id.ln);
        dob = (EditText) findViewById(R.id.date);
        emailid = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.pass);
        btn1 = (RadioButton) findViewById(R.id.rb1);
        btn2 = (RadioButton) findViewById(R.id.rb2);
        btn3 = (RadioButton) findViewById(R.id.rb3);
        login = (Button) findViewById(R.id.log);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String fn = firstname.getText().toString().trim();
                if (fn.isEmpty()) {
                    firstname.setError("FirstName is required.");
                    return;
                }
                String ln = lastname.getText().toString().trim();
                if (ln.isEmpty()) {
                    lastname.setError("LastName is required.");
                    return;
                }
                String date = dob.getText().toString();
                if (date.isEmpty()) {
                    dob.setError("Date of birth is required.");
                    return;
                }
                String gender = "";
                if (btn1.isChecked()) {
                    gender = "Male";
                } else if (btn2.isChecked()) {
                    gender = "Female";
                } else if (btn3.isChecked()) {
                    gender = "Other";
                } else {
                    Toast.makeText(MainActivity.this, "Please select a gender.", Toast.LENGTH_SHORT).show();
                    return;
                }
                String email = emailid.getText().toString().trim();
                if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                    emailid.setError("Invalid email address.");
                    return;
                }
                String pass = password.getText().toString().trim();
                if (password.length() < 8) {
                    password.setError("Password must be atleast 8 characters.");
                    return;
                }
                Toast.makeText(MainActivity.this, "Form submitted successfully", Toast.LENGTH_SHORT).show();
                Intent send = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(send);
            }
        });
    }
            protected void onResume() {
                super.onResume();
                SharedPreferences sh = getSharedPreferences("MySharedPref", MODE_PRIVATE);
                String s1 = sh.getString("firstname", "");
                int a = sh.getInt("lastname", 0);

                firstname.setText(s1);
                lastname.setText(String.valueOf(a));
            }

            @Override
            protected void onPause() {
                super.onPause();

                SharedPreferences sharedPreferences = getSharedPreferences("MySharedPref", MODE_PRIVATE);
                SharedPreferences.Editor myEdit = sharedPreferences.edit();

                myEdit.putString("firstname", firstname.getText().toString());
                myEdit.putInt("lastname", Integer.parseInt(lastname.getText().toString()));
                myEdit.apply();
            }
}