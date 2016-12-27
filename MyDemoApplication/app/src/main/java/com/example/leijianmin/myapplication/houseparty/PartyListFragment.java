package com.example.leijianmin.myapplication.houseparty;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.leijianmin.myapplication.R;

/**
 * Created by leijianmin on 2016/12/26.
 */

public class PartyListFragment extends Fragment implements View.OnClickListener {

    IPartyListInteraction mInteraction;

    View mBottomBar;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_party_list, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        mBottomBar = view.findViewById(R.id.bottom_bar);

        mBottomBar.setOnClickListener(this);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mInteraction = (IPartyListInteraction) context;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mInteraction = null;
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.bottom_bar) {
            if (mInteraction != null) {
                mInteraction.onToggleShow();
            }
        }
    }

    public interface IPartyListInteraction {
        void onToggleShow();
    }
}
