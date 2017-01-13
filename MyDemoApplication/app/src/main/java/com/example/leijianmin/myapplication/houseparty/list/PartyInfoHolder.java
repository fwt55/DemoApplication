package com.example.leijianmin.myapplication.houseparty.list;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.leijianmin.myapplication.R;

/**
 * Created by leijianmin on 2016/12/27.
 */

public class PartyInfoHolder extends RecyclerView.ViewHolder {
    TextView mTvName;

    public PartyInfoHolder(View itemView) {
        super(itemView);

        init(itemView);
    }

    private void init(View parent) {
        mTvName = (TextView) parent.findViewById(R.id.tv_name);
    }

    public void configure(PartyInfoWrapper partyInfoWrapper) {
        mTvName.setText(partyInfoWrapper.getName()[0]);
    }
}
