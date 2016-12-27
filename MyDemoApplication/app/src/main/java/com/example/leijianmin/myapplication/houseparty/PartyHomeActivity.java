package com.example.leijianmin.myapplication.houseparty;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.leijianmin.myapplication.R;

/**
 * Created by leijianmin on 2016/12/26.
 */

public class PartyHomeActivity extends AppCompatActivity implements PartyListFragment.IPartyListInteraction {

    DropdownLayout layout;
    View btExecute;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_party_home);

        layout = (DropdownLayout) findViewById(R.id.dropdown_layout);
        btExecute = findViewById(R.id.execute);

        init();
    }

    private void init() {
        PartyListFragment fragment = new PartyListFragment();

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.drawer_party_list_container, fragment);
        transaction.commit();
    }

    @Override
    public void onToggleShow() {
        layout.expandOrShrink();
    }
}
