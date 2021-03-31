package com.example.atividadedois.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Albums implements Parcelable {
    private int userId;
    private int id;
    private String title;


    public Albums(int userId, int id, String title) {
        this.userId = userId;
        this.id = id;
        this.title = title;
    }

    protected Albums(Parcel in) {
        this.userId = in.readInt();
        this.id = in.readInt();
        this.title = in.readString();
    }

    public static final Creator<Albums> CREATOR = new Creator<Albums>() {
        @Override
        public Albums createFromParcel(Parcel in) {
            return new Albums(in);
        }

        @Override
        public Albums[] newArray(int size) {
            return new Albums[size];
        }
    };

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.userId);
        dest.writeInt(this.id);
        dest.writeString(this.title);
    }
}
