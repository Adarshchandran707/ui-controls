package com.example.login;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText username;
    Button login;
    EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username=(EditText)findViewById((R.id.name));
        password=(EditText)findViewById((R.id.password));
        login=(Button)findViewById(R.id.button);
        login.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view )
            {
                if (username.getText().toString().equals("user") && password.getText().toString().equals("pass")){
                    Toast.makeText(MainActivity.this, "LOGIN SUCCESSFULLY", Toast.LENGTH_SHORT).show();
                }else
                {
                    Toast.makeText(MainActivity.this, "Login Failed", Toast.LENGTH_SHORT).show();

                }
            }
        });
    }
}