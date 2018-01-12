package com.manohar.root.geoquiz;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class QuizActivity extends AppCompatActivity {
    public Button mTrueButton, nextButton, prevButton,mCheatButton;
    public Button mFalseButton;
    public TextView textView;
    private  String TAG_CHEAT,USER_CHEAT;
    private  boolean ischeater=false;

    public int index = 0;
    public boolean userans;
    public Question[] qbank = new Question[]{new Question(R.string.c_question, true), new Question(R.string.gk_question, false), new Question(R.string.gk2_question, false), new Question(R.string.cpp_question, true)};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        mTrueButton = findViewById(R.id.TrueButton);
        prevButton = findViewById(R.id.prev_button);
        mFalseButton = findViewById(R.id.FalseButton);
        textView = findViewById(R.id.textView);
        nextButton = findViewById(R.id.next_button);
        mCheatButton=findViewById(R.id.cheatButton);
    mCheatButton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent i =new Intent(QuizActivity.this,CheatActivity.class);
            i.putExtra(TAG_CHEAT,qbank[index].getAns());
            startActivityForResult(i,0);
        }
    });
        //textView.setText(qbank[index].getQid());
        mTrueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Toast.makeText(QuizActivity.this, "Correct !", Toast.LENGTH_SHORT).show();

                checkAnswer(true);
            }
        });
        prevButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                index = (index -1+qbank.length) % qbank.length;
                int que = qbank[index].getQid();
                textView.setText(que);
                ischeater=false;
            }
        });
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                index = (index + 1) % qbank.length;
                int que = qbank[index].getQid();
                textView.setText(que);
                ischeater=false;
            }
        });
        mFalseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(QuizActivity.this, "Incorrect !", Toast.LENGTH_SHORT).show();

                checkAnswer(false);
            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode!=0)
            return;
        if(resultCode== Activity.RESULT_OK)
        ischeater=data.getBooleanExtra(USER_CHEAT,false);
        else
            return;

    }

    private void checkAnswer(boolean ans) {
        boolean correctAns = qbank[index].getAns();
        if(ischeater)
        {
            Toast.makeText(this,"You Cheater!!",Toast.LENGTH_SHORT).show();
        }
        else if (correctAns == ans) {
            Toast.makeText(this, R.string.correct, Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, R.string.incorrect, Toast.LENGTH_SHORT).show();
        }
    }
}