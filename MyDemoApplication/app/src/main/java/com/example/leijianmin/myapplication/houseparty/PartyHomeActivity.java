package com.example.leijianmin.myapplication.houseparty;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.example.leijianmin.myapplication.R;

/**
 * Created by leijianmin on 2016/12/26.
 */

public class PartyHomeActivity extends AppCompatActivity implements PartyListFragment.IPartyListInteraction, View.OnClickListener{

    DropdownLayout layout;
    View btExecute;

    View btLeft;
    View btRight;

    View mIndicator;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_party_home);

        layout = (DropdownLayout) findViewById(R.id.dropdown_layout);
        btExecute = findViewById(R.id.execute);
        btLeft = findViewById(R.id.bt_left);
        btRight = findViewById(R.id.bt_right);
        mIndicator = findViewById(R.id.indicator);

        btLeft.setOnClickListener(this);
        btRight.setOnClickListener(this);
        mIndicator.setOnClickListener(this);

        init();
    }

    private void init() {
        PartyListFragment fragment = new PartyListFragment();

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.drawer_party_list_container, fragment);
        transaction.commit();

        layout.setBottomPosListener(new DropdownLayout.IBottomPosListener() {
            @Override
            public void onChange(int bottom) {
                mIndicator.setTranslationY(bottom);
            }
        });
    }

    @Override
    public void onToggleShow() {
        layout.expandOrShrink();
    }

    @Override
    public void onClick(View v) {
        Toast.makeText(this, v.getId()+ "", Toast.LENGTH_LONG).show();

        if (v.getId() == R.id.indicator) {
            onToggleShow();
        }
    }
}
