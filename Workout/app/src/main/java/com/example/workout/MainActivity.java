package com.example.workout;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.icu.text.MessageFormat;
import android.os.Build;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    ImageButton plusRepsButton;
    ImageButton minusRepsButton;
    ImageButton workoutShareButton;
    Button saveButton;

    TextView repsCountTextView;

    TextView weightTextView;
    TextView recordRepsTextView;
    TextView recordInfoTextView;
    TextView recordWeightTextView;
    SeekBar weightSeekBar;
    int reps;

    public String savedText;
    public String savedText1;

    SharedPreferences sPref;

    final String SAVED_TEXT = "saved_text";
    final String SAVED_TEXT1 = "saved_text1";
    final String DATE_TEXT = "date_text";


    Date currentDate = new Date();
    // Форматирование времени как "день.месяц.год"
    DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy", Locale.getDefault());
    String dateText = dateFormat.format(currentDate);
    private static final String KEY_REPS = "saved_reps_text";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (savedInstanceState != null) {
            reps = Integer.parseInt(savedInstanceState.getString(KEY_REPS));
        }

        setContentView(R.layout.activity_main);

        WorkoutUI();


    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putString(KEY_REPS, repsCountTextView.getText().toString());

    }


    private void WorkoutUI() {
        repsCountTextView = findViewById(R.id.workout_detail_reps_text_view);
        repsCountTextView.setText(String.valueOf(reps));
        recordRepsTextView = findViewById(R.id.record_reps);
        recordInfoTextView = findViewById(R.id.record_info);
        weightTextView = findViewById(R.id.workout_detail_weight_text_view);
        recordWeightTextView = findViewById(R.id.record_weight);

        //reps = Integer.parseInt(repsCountTextView.getText().toString());

        plusRepsButton = findViewById(R.id.workout_detail_plus_reps_button);
        minusRepsButton = findViewById(R.id.workout_detail_minus_reps_button);
        workoutShareButton = findViewById(R.id.workout_share_button);

        saveButton = findViewById(R.id.button_save_record);
        weightSeekBar = findViewById(R.id.workout_detail_weigt_seek_bar);

        plusRepsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                repsCountTextView.setText(String.valueOf(++reps));
            }
        });

        minusRepsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (reps >= 1) {
                    repsCountTextView.setText(String.valueOf(--reps));
                } else {
                    repsCountTextView.setText("0");
                }
            }
        });

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = weightTextView.getText().toString();
                int zz = Integer.parseInt(savedText);
                int i = Integer.parseInt(str);
                int z = Integer.parseInt(savedText1);
                if ((reps <= z) && (i <= zz)) {
                    saveButton.setText(getString(R.string.recordNO));
                } else {
                    saveButton.setText(getString(R.string.recordYES));
                    saveText();
                }
                LoadText();
            }
        });

        workoutShareButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, savedText1 + " " + savedText + " " + dateText);

                sendIntent.setType("text/plain");

                Intent shareIntent = Intent.createChooser(sendIntent, null);
                startActivity(shareIntent);

            }
        });


        weightSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                weightTextView.setText(MessageFormat.format(getString(R.string.weight), progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        LoadText();
    }

    void saveText() {
        sPref = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor ed = sPref.edit();
        ed.putString(SAVED_TEXT, weightTextView.getText().toString());
        ed.putString(SAVED_TEXT1, repsCountTextView.getText().toString());
        ed.putString(DATE_TEXT, dateText);
        ed.apply();
    }

    void LoadText() {
        sPref = getPreferences(MODE_PRIVATE);
        savedText = sPref.getString(SAVED_TEXT, "");
        savedText1 = sPref.getString(SAVED_TEXT1, "");
        String dateTextStr = sPref.getString(DATE_TEXT, "");


        recordRepsTextView.setText(savedText);
        recordWeightTextView.setText(savedText1);
        recordInfoTextView.setText(dateTextStr);
    }


}
