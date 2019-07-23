package com.example.weather;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       // TextView textViewDate = new TextView(this);

        TextView textViewDate = findViewById(R.id.textViewDate);

        Date currentDate = new Date();
        // Форматирование времени как "день.месяц.год"
        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy", Locale.getDefault());
        String dateText = dateFormat.format(currentDate);

        textViewDate.setText(dateText);
        //textViewDate.setText(dateText);

    }








//    TextView textViewDate = (TextView)findViewById(R.id.textViewDate);
//
//    Date currentDate = new Date();
//    // Форматирование времени как "день.месяц.год"
//    DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy", Locale.getDefault());
//    String dateText = dateFormat.format(currentDate);
//
//
//    textViewDate
//private void display (){
//
//}

}
