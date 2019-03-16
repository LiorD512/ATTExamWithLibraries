package com.att.attexamwithlibraries.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

import com.att.attexamwithlibraries.model.Contact;
import com.att.attexamwithlibraries.model.ContactList;
import com.att.attexamwithlibraries.repository.ContactRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ContactListViewModel extends ViewModel {

    private LiveData<List<Contact>> mContacts;

    public ContactListViewModel(){
        init();
    }


    private void init(){

        ContactRepository contactRepository = new ContactRepository();
        if (this.mContacts != null) {
            return;
        }
        mContacts = contactRepository.getTenContacts();
    }

    public LiveData<List<Contact>> getContacts(){
        return mContacts;
    }


    public static class ContactListViewModelFactory implements ViewModelProvider.Factory {

        public ContactListViewModelFactory() {}

        @NonNull
        @Override
        public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
            //noinspection unchecked
            return (T) new ContactListViewModel();
        }
    }
}
