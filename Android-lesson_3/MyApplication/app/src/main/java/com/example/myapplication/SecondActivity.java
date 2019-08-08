package com.example.myapplication;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends Activity {
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actvity2);


        String user;
        String TypeOfWeather;


        user = getIntent().getStringExtra("editText1");
        TextView infoTextView = findViewById(R.id.textViewInfo);
        infoTextView.setText(user);



        TypeOfWeather = getIntent().getStringExtra("switch2");
        TextView textViewTWeather = findViewById(R.id.textViewTWeather);
        textViewTWeather.setText(TypeOfWeather);

    }


}
