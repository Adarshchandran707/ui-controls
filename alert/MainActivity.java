package com.example.alertbox;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.SimpleAdapter;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    GridView gd;
    int logos[] = {R.drawable.cl1, R.drawable.cl2, R.drawable.cl3, R.drawable.cl4};
    String[] names ={"adidas","Be","S","BMW","Smile","Github",};
    final Context context = this;
    AlertDialog.Builder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        GridView gv = (GridView) findViewById(R.id.gridView);
        gv.setAdapter(new ImageAdapter(this));
        builder = new AlertDialog.Builder(this);

        gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                builder.setMessage("Name : "+String.valueOf(names[position]))
                        .setCancelable(false)
                        .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                            }
                        });
                        AlertDialog alert = builder.create();
                        alert.setTitle("Info Alert");
                        alert.show();
            }
        });
    }
}
