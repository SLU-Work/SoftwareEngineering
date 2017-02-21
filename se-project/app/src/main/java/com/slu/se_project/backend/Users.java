package com.slu.se_project.backend;


import android.os.Parcel;
import android.os.Parcelable;

import com.backendless.BackendlessUser;

import java.io.Serializable;
import java.util.Date;

public class Users extends BackendlessObject implements Serializable {

    private static final long serialVersionUID = -2518143671167959399L;

    public static Users createFrom(BackendlessUser backendlessUser){
        Users users = new Users();
        users.setObjectId(backendlessUser.getObjectId());
        users.setEmail(backendlessUser.getEmail());
        users.setName((String)backendlessUser.getProperty("name"));
        users.setUpdated((Date)backendlessUser.getProperty("updated"));
        users.setCreated((Date)backendlessUser.getProperty("created"));
        return users;
    }

    private String email;
    private String name;
    private String accountType;

    public Users(){}

    private Users(Parcel in){
        objectId = in.readString();
        ownerId  = in.readString();
        email    = in.readString();
        name     = in.readString();
        accountType = in.readString();
    }

    public static final Parcelable.Creator<Users> CREATOR = new Parcelable.Creator<Users>() {
        public Users createFromParcel(Parcel in) {
            return new Users(in);
        }

        public Users[] newArray(int size) {
            return new Users[size];
        }
    };

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public void makeAdmin(){accountType = "admin";}

    public boolean isAdmin(){return accountType.equals("admin");}

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(email);
        parcel.writeString(name);
        parcel.writeString(accountType);
    }

    @Override
    public int describeContents() {
        return super.describeContents();
    }
}
