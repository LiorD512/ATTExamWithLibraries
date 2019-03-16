package com.att.attexamwithlibraries.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ContactList {

    @SerializedName("results")
    private List<Contact> contacts;

    public List<Contact> getContacts() {
        return contacts;
    }
}
