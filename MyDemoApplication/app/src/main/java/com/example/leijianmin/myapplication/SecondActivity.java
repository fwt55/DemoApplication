package com.example.leijianmin.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;



public class SecondActivity extends AppCompatActivity {

    TextView mTextView;
    Button mExecute;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);


        mTextView = (TextView) findViewById(R.id.text_view);
        mExecute = (Button) findViewById(R.id.execute);
        init();

    }

    public void execute(View v) {

    }

    private void init() {



    }

}
