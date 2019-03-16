package com.att.attexamwithlibraries.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

public class Contact implements Parcelable {

    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
        public Contact createFromParcel(Parcel in) {
            return new Contact(in);
        }

        public Contact[] newArray(int size) {
            return new Contact[size];
        }
    };

    @SerializedName("name")
    private ContactName mContactName;
    @SerializedName("location")
    private ContactLocation mLocation;
    @SerializedName("email")
    private String mEmail;
    @SerializedName("phone")
    private String mPhoneNumber;
    @SerializedName("picture")
    private ContactPicture mContactPicture;

    public Contact(ContactName contactNames,  ContactLocation contactLocation, String email, String phoneNumber, ContactPicture contactPicture) {
        this.mContactName = contactNames;
        this.mLocation = contactLocation;
        this.mEmail = email;
        this.mPhoneNumber = phoneNumber;
        this.mContactPicture = contactPicture;
    }


    public ContactLocation getAddress() {
        return mLocation;
    }

    public void setAddress(ContactLocation contactLocation) {
        this.mLocation = contactLocation;
    }

    public String getEmail() {
        return mEmail;
    }

    public void setEmail(String email) {
        this.mEmail = email;
    }

    public String getPhoneNumber() {
        return mPhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.mPhoneNumber = phoneNumber;
    }

    public ContactName getContactName() {
        return mContactName;
    }

    public void setContactName(ContactName contactName) {
        this.mContactName = contactName;
    }

    public ContactPicture getContactPicture() {
        return mContactPicture;
    }

    public void setContactPicture(ContactPicture contactPicture) {
        this.mContactPicture = contactPicture;
    }

    public Contact(Parcel in){
        mContactName = in.readParcelable(ContactName.class.getClassLoader());
        this.mLocation = in.readParcelable(ContactLocation.class.getClassLoader());
        this.mEmail =  in.readString();
        this.mPhoneNumber = in.readString();
        mContactPicture = in.readParcelable(ContactPicture.class.getClassLoader());
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(mContactName, flags);
        dest.writeParcelable(mLocation, flags);
        dest.writeString(this.mEmail);
        dest.writeString(this.mPhoneNumber);
        dest.writeParcelable(mContactPicture, flags);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contact contact = (Contact) o;
        return Objects.equals(mContactName, contact.mContactName) &&
                Objects.equals(mLocation, contact.mLocation) &&
                Objects.equals(mEmail, contact.mEmail) &&
                Objects.equals(mPhoneNumber, contact.mPhoneNumber)&&
                Objects.equals(mContactPicture, contact.mContactPicture);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mContactName, mLocation, mEmail, mPhoneNumber, mContactPicture);
    }

}
