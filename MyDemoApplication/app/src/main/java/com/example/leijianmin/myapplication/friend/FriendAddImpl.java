package com.example.leijianmin.myapplication.friend;

/**
 * Created by leijianmin on 2016/12/29.
 */

public abstract class FriendAddImpl implements IFriendAdd {

    protected String mName;
    protected int mType;

    @Override
    public int getType() {
        return mType;
    }

    @Override
    public String getName() {
        return mName;
    }

    @Override
    public String getDesc() {
        return null;
    }

}
