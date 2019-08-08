package com.example.geoquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class QuizActivity extends AppCompatActivity {

    private static final String TAG = "QuizActivity";

    private Button mTrueButton;
    private Button mFalseButton;
    private ImageButton mNextButton;
    private ImageButton mPrevButton;
    private TextView mQuestionTextView;
    public int mCurrentIndex = 0;

    private Question[] mQuestionBank = new Question[]{
            new Question(R.string.question_australia, true),
            new Question(R.string.question_oceans, true),
            new Question(R.string.question_mideast, false),
            new Question(R.string.question_africa, false),
            new Question(R.string.question_americas, true),
            new Question(R.string.question_asia, true),

    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate(BUNDLE) called");
        setContentView(R.layout.activity_quiz);

        mQuestionTextView = (TextView) findViewById(R.id.question_text_view);


//        int question = mQuestionBank[mCurrentIndex].getTextResId();
//        mQuestionTextView.setText(question);
        mQuestionTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                mCurrentIndex = (mCurrentIndex + 1) % mQuestionBank.length;
                updateQuestion();
            }
        });


        mTrueButton = (Button) findViewById(R.id.true_button);
        mTrueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(QuizActivity.this, R.string.correct_toast, Toast.LENGTH_SHORT).show();
                checkAnswer(true);
            }
        });

        mFalseButton = (Button) findViewById(R.id.false_button);
        mFalseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(QuizActivity.this, R.string.incorrect_toast, Toast.LENGTH_SHORT).show();
                checkAnswer(false);
            }
        });

        mPrevButton = (ImageButton) findViewById(R.id.prev_button);


// mPrevButton.setEnabled(false);
        mPrevButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //v.setClickable(false);
                mCurrentIndex = (mCurrentIndex - 1) % mQuestionBank.length;

//                if (mCurrentIndex == 0) {
//                    v.setClickable(false);
//                } else {v.setClickable(true);}
                //for (mCurrentIndex = 0; mCurrentIndex <mQuestionBank.length ; --mCurrentIndex) {

                updateQuestion();
            }
        });

        mNextButton = (ImageButton) findViewById(R.id.next_button);
        mNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCurrentIndex = (mCurrentIndex + 1) % mQuestionBank.length;
//                int question = mQuestionBank[mCurrentIndex].getTextResId();
//                mQuestionTextView.setText(question);


                updateQuestion();
            }
        });

        updateQuestion();


    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d(TAG, "onStart() called");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG, "onResume() called");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(TAG, "onPause() called");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d(TAG, "onStop() called");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy() called");
    }

    private void updateQuestion() {
        int question = mQuestionBank[mCurrentIndex].getTextResId();
        mQuestionTextView.setText(question);

        if (mCurrentIndex == 0 ) {
            mPrevButton.setEnabled(false);
        } else if (mCurrentIndex == mQuestionBank.length){
            mNextButton.setEnabled(false);
        }

    }


    private void checkAnswer(boolean userPressedTrue) {
        boolean answerIsTrue = mQuestionBank[mCurrentIndex].isAnswerTrue();
        int messageResId = 0;


        if (userPressedTrue == answerIsTrue) {
            messageResId = R.string.correct_toast;
        } else {
            messageResId = R.string.incorrect_toast;
        }
        Toast.makeText(this, messageResId, Toast.LENGTH_SHORT)
                .show();
    }
}
