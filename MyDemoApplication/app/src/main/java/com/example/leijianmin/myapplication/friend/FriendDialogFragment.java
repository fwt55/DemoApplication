package com.example.leijianmin.myapplication.friend;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.leijianmin.myapplication.R;

/**
 * Created by leijianmin on 2016/12/29.
 */

public class FriendDialogFragment extends DialogFragment {
    public static final int TYPE_HOME = 0;
    public static final int TYPE_ADD_FRIENDS = 1;
    public static final int TYPE_PARTY_FRIENDS = 2;
    public static final int TYPE_ADD_FROM_CONTACTS = 3;

    private RecyclerView mRecyclerView;
    private FriendAddAdapter mAdapter;
    private TextView mTvTitle;
    private ImageView mIvTopLeft;
    private ImageView mIvTopRight;

    private int mType = TYPE_HOME;

    public static FriendDialogFragment newInstance(int type) {
        FriendDialogFragment fragment = new FriendDialogFragment();
        fragment.mType = type;
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(DialogFragment.STYLE_NO_TITLE, R.style.Dialog_Fullscreen);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.dialog_friend, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        mRecyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        mTvTitle = (TextView) view.findViewById(R.id.tv_title);
        mIvTopLeft = (ImageView) view.findViewById(R.id.iv_top_left);
        mIvTopRight = (ImageView) view.findViewById(R.id.iv_top_right);

        mAdapter = new FriendAddAdapter();
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        init();
    }

    private void init() {
        loadData();
    }

    private void loadData() {
        String title = null;

        if (mType == TYPE_HOME) {
            title = "Friends";
            mIvTopLeft.setVisibility(View.GONE);
        } else if (mType == TYPE_ADD_FRIENDS){
            mIvTopLeft.setVisibility(View.VISIBLE);
            title = "Add Friends";
        } else if (mType == TYPE_PARTY_FRIENDS) {
            title = "Private Live Friends";
        } else if (mType == TYPE_ADD_FROM_CONTACTS) {
            mIvTopLeft.setVisibility(View.VISIBLE);
            title = "Add From Contacts";
        }

        mTvTitle.setText(title);
        mAdapter.setDataSource(mType);
    }
}
