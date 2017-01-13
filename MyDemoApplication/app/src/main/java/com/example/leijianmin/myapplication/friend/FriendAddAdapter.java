package com.example.leijianmin.myapplication.friend;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.leijianmin.myapplication.R;

/**
 * Created by leijianmin on 2016/12/29.
 */

public class FriendAddAdapter extends RecyclerView.Adapter<FriendAddHolder> {

    private FriendAddWrapper mWrapper;

    @Override
    public FriendAddHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = null;

        switch (viewType) {
            case FriendAddWrapper.TYPE_FRIEND_INVITE:
                itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_friend_add_to_invite, parent, false);
                break;
            case FriendAddWrapper.TYPE_FRIEND_ADD:
                itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_friend_add_nomal_with_desc, parent, false);
                break;
            case FriendAddWrapper.TYPE_MENU_NO_ICON:
                itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_friend_add_menu_no_icon, parent, false);
                break;
            case FriendAddWrapper.TYPE_MENU_WITH_ICON:
                itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_friend_add_menu_with_icon, parent, false);
                break;
            case FriendAddWrapper.TYPE_LABEL:
                itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_friend_add_label, parent, false);
                break;
        }

        return new FriendAddHolder(itemView);
    }

    @Override
    public void onBindViewHolder(FriendAddHolder holder, int position) {
        IFriendAdd item = mWrapper.getItem(position);
        holder.configure(item);
    }

    @Override
    public int getItemViewType(int position) {
        return mWrapper == null ? 0 : mWrapper.getItem(position).getType();
    }

    @Override
    public int getItemCount() {
        return mWrapper == null ? 0 : mWrapper.getCount();
    }

    public void setDataSource(int type) {
        mWrapper = FriendAddWrapper.newInstance(type);
    }
}
