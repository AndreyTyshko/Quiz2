package com.example.geoquiz;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CheatActivity extends AppCompatActivity {
    private static final String EXTRA_ANSWER_IS_TRUE = "com.example.geoquiz.answer_is_true";
    private static final String EXTRA_ANSWER_SHOWN = "com.example.android.geoquiz.answer_shown";
    private static final String TAG = "CheatActivity" ;
    private static final String KEY_INDEX = "index";


    private boolean mAnswerIsTrue;
    private TextView mAnswerTextView;
    private TextView version;
    private TextView count_text_view;
    private Button mShowAnswerButton;
    private int mCount =0;

    public static Intent newIntent (Context packageContext, Boolean answerIsTrue){
        Intent intent = new Intent( packageContext, CheatActivity.class );
        intent.putExtra(EXTRA_ANSWER_IS_TRUE, answerIsTrue);
        return intent;
    }

    public static boolean wasAnswerShown (Intent result){
        return result.getBooleanExtra(EXTRA_ANSWER_SHOWN, false);
    }
@Override
    public void onSaveInstanceState (Bundle savedInstanceState){
    super.onSaveInstanceState(savedInstanceState);
    Log.i(TAG, "onSaveInstanceState");
    savedInstanceState.putInt(KEY_INDEX, mCount);
    }


    @Override
    public void onRestoreInstanceState (Bundle savedInstanceState){
        super.onRestoreInstanceState(savedInstanceState);

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cheat);
        mAnswerIsTrue = getIntent().getBooleanExtra(EXTRA_ANSWER_IS_TRUE, false);
        version = (TextView) findViewById(R.id.version);
        version.setText(String.valueOf("API Level " + Build.VERSION.SDK_INT));
        mAnswerTextView = (TextView) findViewById(R.id.answer_text_view);
        mShowAnswerButton = (Button) findViewById( R.id.show_answer_button);
        count_text_view = findViewById(R.id.count_text_view);

        if(savedInstanceState !=null){
            mCount=savedInstanceState.getInt(KEY_INDEX,0);
            count_text_view.setText(""+mCount);
        }



        mShowAnswerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                if (mAnswerIsTrue){
                    mAnswerTextView.setText(R.string.true_button );

                }else {
                    mAnswerTextView.setText(R.string.false_button);

                }



                setAnswerShownResult(true);

                count_text_view.setText("подсмотрел " + ++mCount +"");


            }
        });


    }

        private void setAnswerShownResult(boolean isAnswerShown) {
        Intent data = new Intent();
        data.putExtra(EXTRA_ANSWER_SHOWN, isAnswerShown);
        setResult(RESULT_OK, data);
       // count_text_view.setText("подсмотрел " + ++mCount +"");
    }

//    public void onButtonClick() {
//        //++mCount;
//        count_text_view.setText(""+ mCount +"");
//
//    }
}
