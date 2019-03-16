package com.att.attexamwithlibraries.repository;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

import com.att.attexamwithlibraries.RetrofitClient;
import com.att.attexamwithlibraries.api.ContactApi;
import com.att.attexamwithlibraries.model.Contact;
import com.att.attexamwithlibraries.model.ContactList;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ContactRepository {

    private ContactApi mContactApi;
    private ArrayList<Contact> contactList = new ArrayList<>();
    private ContactList contact;

    public ContactRepository() {
        mContactApi = RetrofitClient.getRetrofitInstance().create(ContactApi.class);
    }

    public LiveData<List<Contact>> getTenContacts() {

        Call<ContactList> call = mContactApi.getTenContacts();
        final MutableLiveData<List<Contact>> data = new MutableLiveData<>();

        call.enqueue(new Callback<ContactList>() {
            @Override
            public void onResponse(Call<ContactList> call, Response<ContactList> response) {
                if (response.isSuccessful()) {
                    contact = response.body();
                    assert contact != null;
                    contactList.add(contact.getContacts().get(0));

                    if (contactList.size() < 10) {
                        call.clone().enqueue(this);
                    }

                    data.postValue(contactList);

                }

            }

            @Override
            public void onFailure(Call<ContactList> call, Throwable t) {
                t.printStackTrace();

            }
        });


        return data;

    }

}
