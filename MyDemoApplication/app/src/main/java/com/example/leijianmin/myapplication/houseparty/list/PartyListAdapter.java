package com.example.leijianmin.myapplication.houseparty.list;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.leijianmin.myapplication.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by leijianmin on 2016/12/27.
 */

public class PartyListAdapter extends RecyclerView.Adapter<PartyInfoHolder> {

    List<PartyInfoWrapper> mList;

    @Override
    public PartyInfoHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_party, parent, false);
        return new PartyInfoHolder(view);
    }

    @Override
    public void onBindViewHolder(PartyInfoHolder holder, int position) {
        holder.configure(mList.get(position));
    }

    @Override
    public int getItemCount() {
        return mList != null ? mList.size() : 0;
    }


    public void setDataSource() {
        mList = new ArrayList<>();

        String[] names = {"Shakria", "wrqfdsfad","fdsafasdfwqrfweq", "dsafsdasdfafda", "qwprewqwefasd", "vcxvxczvw"};

        for (String name : names) {
            PartyInfoWrapper info = new PartyInfoWrapper();
            info.setName(name);
            mList.add(info);
        }

        notifyDataSetChanged();
    }
}
