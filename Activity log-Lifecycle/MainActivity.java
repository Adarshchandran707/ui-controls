package com.example.activitylifecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("Lifecycle","OnCreate Invoked");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("Lifecycle","onStart Invoked");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("Lifecycle","onPause invoked");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("Lifecycle","onResume Invoked");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("Lifecycle","onStop Invoked");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("Lifecycle","onRestart Invoked");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("Lifecycle","onDestroy Invoked");
    }
}