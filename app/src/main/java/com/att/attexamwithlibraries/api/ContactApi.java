package com.att.attexamwithlibraries.api;

import com.att.attexamwithlibraries.model.Contact;
import com.att.attexamwithlibraries.model.ContactList;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ContactApi {

    @GET("/api")
    Call<ContactList> getTenContacts();
}
