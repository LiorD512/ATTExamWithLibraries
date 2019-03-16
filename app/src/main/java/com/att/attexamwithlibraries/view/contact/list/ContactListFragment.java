package com.att.attexamwithlibraries.view.contact.list;


import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.att.attexamwithlibraries.R;
import com.att.attexamwithlibraries.adapters.ContactListAdapter;
import com.att.attexamwithlibraries.interfaces.OnItemClickListener;
import com.att.attexamwithlibraries.model.Contact;
import com.att.attexamwithlibraries.utils.BaseFragment;
import com.att.attexamwithlibraries.view.contact.detail.ContactDetailFragment;
import com.att.attexamwithlibraries.viewmodel.ContactListViewModel;

import java.util.List;
import java.util.Objects;

/**
 * A simple {@link Fragment} subclass.
 */
public class ContactListFragment extends BaseFragment implements OnItemClickListener {

    private RecyclerView mContactsRv;

    private ContactListViewModel mContactListViewModel;


    @Override
    public String getManagerTag() {
        return ContactListFragment.class.getSimpleName();
    }

    public ContactListFragment() {
        // Required empty public constructor
    }

    public static ContactListFragment newInstance() {
        return new ContactListFragment();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_contact_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        mContactsRv = view.findViewById(R.id.contacts_rv);

        mContactListViewModel = (ContactListViewModel) ViewModelProviders
                .of(this, new ContactListViewModel.ContactListViewModelFactory())
                .get(ContactListViewModel.class);


        mContactListViewModel.getContacts().observe(this, new Observer<List<Contact>>() {
            @Override
            public void onChanged(@Nullable List<Contact> contacts) {
                ContactListAdapter contactListAdapter = new ContactListAdapter(contacts,ContactListFragment.this);
                mContactsRv.setAdapter(contactListAdapter);
                mContactsRv.setLayoutManager(new GridLayoutManager(getContext(), 2));
            }
        });


    }

    @Override
    public void OnItemClickListener(int position) {
        List<Contact> contactList = mContactListViewModel.getContacts().getValue();
        showFragment(ContactDetailFragment.newInstance(Objects.requireNonNull(contactList).get(position)), true);

    }
}
