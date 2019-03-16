package com.att.attexamwithlibraries.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.Objects;

public class ContactPicture implements Parcelable {

    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
        public ContactPicture createFromParcel(Parcel in) {
            return new ContactPicture(in);
        }

        public ContactPicture[] newArray(int size) {
            return new ContactPicture[size];
        }
    };

    @SerializedName("large")
    private String mLarge;
    @SerializedName("medium")
    private String mMedium;
    @SerializedName("thumbnail")
    private String mThumbnail;

    public ContactPicture(String large, String medium, String thumbnail) {
        this.mLarge = large;
        this.mMedium = medium;
        this.mThumbnail = thumbnail;
    }

    public String getLarge() {
        return mLarge;
    }

    public void setLarge(String large) {
        this.mLarge = large;
    }

    public String getMedium() {
        return mMedium;
    }

    public void setMedium(String medium) {
        this.mMedium = medium;
    }

    public String getThumbnail() {
        return mThumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.mThumbnail = thumbnail;
    }



    public ContactPicture(Parcel in){
        this.mLarge = in.readString();
        this.mMedium =  in.readString();
        this.mThumbnail =  in.readString();
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.mLarge);
        dest.writeString(this.mMedium);
        dest.writeString(this.mThumbnail);
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContactPicture that = (ContactPicture) o;
        return Objects.equals(mLarge, that.mLarge) &&
                Objects.equals(mMedium, that.mMedium) &&
                Objects.equals(mThumbnail, that.mThumbnail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mLarge, mMedium, mThumbnail);
    }
}
