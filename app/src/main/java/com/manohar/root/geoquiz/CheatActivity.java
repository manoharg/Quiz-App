package com.manohar.root.geoquiz;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CheatActivity extends AppCompatActivity {
private TextView cheatTextview;
private Button mshowButton;
private  boolean ansfromintent;
private  String TAG_CHEAT,USER_CHEAT;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cheat);
        cheatTextview=findViewById(R.id.textviewCheat);
        mshowButton=findViewById(R.id.showanswer);

        mshowButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
ansfromintent=getIntent().getBooleanExtra(TAG_CHEAT,false);
                //cheatTextview.setText();
                if(ansfromintent)
                {
                    cheatTextview.setText("True!!");
                }else
                {
                    cheatTextview.setText("False!!");
                }
                Intent result=new Intent();
                result.putExtra(USER_CHEAT,true);
                setResult(Activity.RESULT_OK,result);

            }
        });
    }
}
