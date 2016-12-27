package com.example.leijianmin.myapplication.houseparty;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.leijianmin.myapplication.R;

/**
 * Created by leijianmin on 2016/12/26.
 */

public class PartyHomeFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_party_home, container, false);
    }
}
