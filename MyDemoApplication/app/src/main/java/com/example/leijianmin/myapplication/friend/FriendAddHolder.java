package com.example.leijianmin.myapplication.friend;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.leijianmin.myapplication.R;

/**
 * Created by leijianmin on 2016/12/29.
 */

public class FriendAddHolder extends RecyclerView.ViewHolder {

    TextView tvName;
    TextView tvDesc;
    ImageView ivAvatar;
    ImageView ivAvatarRight;

    public FriendAddHolder(View itemView) {
        super(itemView);
        tvName = (TextView) itemView.findViewById(R.id.tv_name);
        tvDesc = (TextView) itemView.findViewById(R.id.tv_desc);
        ivAvatarRight = (ImageView) itemView.findViewById(R.id.iv_avatar_right);
    }

    public void configure(IFriendAdd data) {
        tvName.setText(data.getName());
    }
}
