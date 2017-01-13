package com.example.leijianmin.myapplication.friend;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by leijianmin on 2016/12/29.
 */

public class FriendAddWrapper {

    public final static int TYPE_FRIEND_INVITE = 0;
    public final static int TYPE_FRIEND_ADD = 1;
    public final static int TYPE_MENU_NO_ICON = 2;
    public final static int TYPE_MENU_WITH_ICON = 3;
    public final static int TYPE_LABEL = 4;

    List<IFriendAdd> mData = new ArrayList<>();

    private FriendAddWrapper() {

    }

    public static FriendAddWrapper newInstance(int type) {
        FriendAddWrapper wrapper = new FriendAddWrapper();

        if (type == 0) {
            wrapper.setUpHome();
        } else if (type == 1) {
            wrapper.setUpAddFriends();
        } else if (type == 2) {
            wrapper.setUpPartyFriends();
        } else if (type == 3) {
            wrapper.setUpAddFromContacts();
        }

        return wrapper;
    }

    private void setUpAddFromContacts() {



    }

    private void setUpPartyFriends() {
        mData.add(new PartyFriend());
        mData.add(new PartyFriend());
        mData.add(new PartyFriend());
        mData.add(new PartyFriend());
        mData.add(new PartyFriend());
        mData.add(new PartyFriend());
        mData.add(new PartyFriend());
    }

    private void setUpAddFriends() {
        mData.clear();

        mData.add(new MenuWithIcon("Add From Contacts"));
        mData.add(new MenuWithIcon("Invite Friends"));
    }

    private void setUpHome() {
        mData.clear();

        mData.add(new Menu("Add Friends"));
        mData.add(new Menu("Private Live Friends"));

        mData.add(new Label("PEOPLE YOU MAY KNOW"));

        mData.add(new ContactAdd());
        mData.add(new ContactAdd());
        mData.add(new ContactAdd());
        mData.add(new ContactAdd());
        mData.add(new ContactAdd());
        mData.add(new ContactAdd());
        mData.add(new ContactAdd());
        mData.add(new ContactAdd());
    }

    public int getCount() {
        return mData.size();
    }

    public IFriendAdd getItem(int position) {
        return mData.get(position);
    }

    protected class ContactAdd extends FriendAddImpl {
        public ContactAdd() {
            mType = TYPE_FRIEND_INVITE;
        }
    }

    protected class ContactInvite extends FriendAddImpl {
        public ContactInvite() {

        }
    }

    protected class PartyFriend extends FriendAddImpl {
        public PartyFriend() {
            mType = TYPE_FRIEND_ADD;
        }
    }

    protected class Menu extends FriendAddImpl {
        public Menu(String name) {
            mName = name;
            mType = TYPE_MENU_NO_ICON;
        }
    }

    protected class MenuWithIcon extends FriendAddImpl {
        public MenuWithIcon(String name) {
            mName = name;
            mType = TYPE_MENU_WITH_ICON;
        }
    }

    protected class Label extends FriendAddImpl {
        public Label(String name) {
            mName = name;
            mType = TYPE_LABEL;
        }
    }
}
