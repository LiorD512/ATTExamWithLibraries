package com.att.attexamwithlibraries.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.Objects;

public class ContactName implements Parcelable {

    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
        public ContactName createFromParcel(Parcel in) {
            return new ContactName(in);
        }

        public ContactName[] newArray(int size) {
            return new ContactName[size];
        }
    };


    @SerializedName("first")
    private String mFirstName;
    @SerializedName("last")
    private String mLastName;

    public ContactName(String firstName, String lastName) {
        this.mFirstName = firstName;
        this.mLastName = lastName;
    }


    public String getFirstName() {
        return mFirstName;
    }

    public void setFirstName(String firstName) {
        this.mFirstName = firstName;
    }

    public String getLastName() {
        return mLastName;
    }

    public void setLastName(String lastName) {
        this.mLastName = lastName;
    }


    public ContactName(Parcel in){
        this.mFirstName = in.readString();
        this.mLastName =  in.readString();
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.mFirstName);
        dest.writeString(this.mLastName);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContactName that = (ContactName) o;
        return Objects.equals(mFirstName, that.mFirstName) &&
                Objects.equals(mLastName, that.mLastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mFirstName, mLastName);
    }
}
