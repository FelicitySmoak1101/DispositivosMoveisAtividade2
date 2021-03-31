package com.example.atividadedois.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Coments implements Parcelable {
    private int postId;
    private int id;
    private String name;
    private String email;
    private String body;


    public Coments(int postId, int id, String name, String email, String body) {
        this.postId = postId;
        this.id = id;
        this.name = name;
        this.email = email;
        this.body = body;
    }

    protected Coments(Parcel in) {
        this.postId = in.readInt();
        this.id = in.readInt();
        this.name = in.readString();
        this.email = in.readString();
        this.body = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.postId);
        dest.writeInt(this.id);
        dest.writeString(this.name);
        dest.writeString(this.email);
        dest.writeString(this.body);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Coments> CREATOR = new Creator<Coments>() {
        @Override
        public Coments createFromParcel(Parcel in) {
            return new Coments(in);
        }

        @Override
        public Coments[] newArray(int size) {
            return new Coments[size];
        }
    };

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

}
