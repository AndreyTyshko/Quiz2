package com.example.geoquiz;

public class Question {
    private int mTextResId;
    private Boolean mAnswerTrue;

    public int getTextResId() {
        return mTextResId;
    }

    public void setTextResId(int textResId) {
        mTextResId = textResId;
    }

    public Boolean isAnswerTrue() {
        return mAnswerTrue;
    }

    public void setAnswerTrue(Boolean answerTrue) {
        mAnswerTrue = answerTrue;
    }

    public Question(int mTextResId, Boolean mAnswerTrue) {
        this.mTextResId = mTextResId;
        this.mAnswerTrue = mAnswerTrue;



    }


}
