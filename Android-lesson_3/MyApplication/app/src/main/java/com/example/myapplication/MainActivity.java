package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toast.makeText(getApplicationContext(), "Main - onCreate()", Toast.LENGTH_SHORT).show();


        Switch switch1 = (Switch) findViewById(R.id.switch1);
        if (switch1 != null) {
            switch1.setOnCheckedChangeListener(this);

        }

        /*Switch switch2 = (Switch) findViewById(R.id.switch2);
        if (switch2 != null) {
            onCheckedChanged(CompoundButton);*/

        }






    public void onSwitchClicked (View view) {
        Switch switch2 = (Switch) view;
        boolean checked = switch2.isChecked();

        if (checked == true) {
             switch2 = findViewById(R.id.switch2);
             Intent intent2 = new Intent( MainActivity.this, SecondActivity.class);
             intent2.putExtra("switch2", switch2.getText().toString());
            startActivity(intent2);


        }
    }

       public void onClick(View view) {

           EditText editText1 = findViewById(R.id.editText1);
           Intent intent = new Intent(MainActivity.this, SecondActivity.class);
           intent.putExtra("editText1", editText1.getText().toString());
           startActivity(intent);

       }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(getApplicationContext(), "Main - onStart()", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(getApplicationContext(), "Main - onResume()", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(getApplicationContext(), "Main - onPause()", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(getApplicationContext(), "Main - onStop()", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(getApplicationContext(), "Main - onRestart()", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(getApplicationContext(), "Main - onDestroy()", Toast.LENGTH_SHORT).show();
    }


    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        Toast.makeText(this, "Отслеживание переключения: " + (isChecked ? "on" : "off"), Toast.LENGTH_SHORT).show();
    }


}
