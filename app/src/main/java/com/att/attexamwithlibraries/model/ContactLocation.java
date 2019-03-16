package com.att.attexamwithlibraries.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.Objects;

public class ContactLocation implements Parcelable {

    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
        public ContactLocation createFromParcel(Parcel in) {
            return new ContactLocation(in);
        }

        public ContactLocation[] newArray(int size) {
            return new ContactLocation[size];
        }
    };


    @SerializedName("street")
    private String mStreet;
    @SerializedName("city")
    private String mCity;
    @SerializedName("state")
    private String mState;
    @SerializedName("postcode")
    private String mPostCode;

    public ContactLocation(String street, String city, String state, String postCode) {
        this.mStreet = street;
        this.mCity = city;
        this.mState = state;
        this.mPostCode = postCode;
    }

    public String getStreet() {
        return mStreet;
    }

    public void setStreet(String street) {
        this.mStreet = street;
    }

    public String getCity() {
        return mCity;
    }

    public void setCity(String city) {
        this.mCity = city;
    }

    public String getState() {
        return mState;
    }

    public void setState(String state) {
        this.mState = state;
    }

    public String getPostCode() {
        return mPostCode;
    }

    public void setPostCode(String postCode) {
        this.mPostCode = postCode;
    }

    public ContactLocation(Parcel in){
        this.mStreet = in.readString();
        this.mCity =  in.readString();
        this.mState =  in.readString();
        this.mPostCode =  in.readString();
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.mStreet);
        dest.writeString(this.mCity);
        dest.writeString(this.mState);
        dest.writeString(this.mPostCode);
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContactLocation that = (ContactLocation) o;
        return Objects.equals(mStreet, that.mStreet) &&
                Objects.equals(mCity, that.mCity) &&
                Objects.equals(mState, that.mState) &&
                Objects.equals(mPostCode, that.mPostCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mStreet, mCity, mState, mPostCode);
    }
}
