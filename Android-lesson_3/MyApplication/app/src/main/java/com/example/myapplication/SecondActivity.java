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


        String user = "ЖЫвотное";
       // String gift = "дырку от бублика";

//        user = getIntent().getExtras().getString("editText1");
//        gift = getIntent().getExtras().getString("editText2");

        user = getIntent().getStringExtra("editText1");
       // gift = getIntent().getStringExtra("editText2");

        TextView infoTextView = findViewById(R.id.textViewInfo);
        infoTextView.setText(user);

    }


}
