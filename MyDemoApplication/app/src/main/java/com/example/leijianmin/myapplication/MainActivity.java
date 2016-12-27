package com.example.leijianmin.myapplication;

import android.content.ComponentName;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;



public class MainActivity extends AppCompatActivity {


    TextView mExecute;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mExecute = (TextView) findViewById(R.id.execute);


        init();

        ComponentName name = getIntent().getComponent();
    }

    private void init() {

    }

    private Rect getViewRectInScreen(View view) {
        int[] position = new int[2];
        view.getLocationOnScreen(position);

        int left = position[0];
        int top = position[1];
        int width = view.getWidth();
        int height = view.getHeight();
        Rect rect = new Rect(left, top, left + width, top + height);
        return rect;
    }

    public void execute(View v) {


//        gift.setEnabled(!gift.isEnabled());

//        TestDialog dialog = new TestDialog(this, R.style.FullScreenDialog);
//        dialog.show();
    }

}
