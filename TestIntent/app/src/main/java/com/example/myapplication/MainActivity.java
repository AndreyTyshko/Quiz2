package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textView  = findViewById(R.id.textViewHello);

    }


    public void onClick(View v){
        final EditText nameText = findViewById(R.id.nameText);
        String name = nameText.getText().toString();

        Intent intent = new Intent(this, Main2Activity.class);
        intent.putExtra("name", name);
        startActivity(intent);
    }

}
