package com.att.attexamwithlibraries.view.contact.detail;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.att.attexamwithlibraries.R;
import com.att.attexamwithlibraries.model.Contact;
import com.att.attexamwithlibraries.utils.BaseFragment;
import com.squareup.picasso.Picasso;

/**
 * A simple {@link Fragment} subclass.
 */
public class ContactDetailFragment extends BaseFragment {

    private Contact mContact;

    @Override
    public String getManagerTag() {
        return ContactDetailFragment.class.getSimpleName();
    }

    public ContactDetailFragment() {
        // Required empty public constructor
    }

    public static ContactDetailFragment newInstance(Contact contact){
        ContactDetailFragment fragment = new ContactDetailFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable("contact", contact);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_contact_detail, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ImageView contactImage = view.findViewById(R.id.contact_detail_image);
        TextView contactName = view.findViewById(R.id.contact_detail_name);
        TextView contactEmail = view.findViewById(R.id.contact_detail_email);
        TextView contactAddress = view.findViewById(R.id.contact_detail_address);

        if (getArguments() != null){
            mContact = getArguments().getParcelable("contact");
        }

        if (mContact != null){
            Picasso.get()
                    .load(mContact.getContactPicture().getLarge())
                    .fit()
                    .into(contactImage);

            contactName.setText(String.format("%s",mContact.getContactName().getFirstName() + " " + mContact.getContactName().getLastName()));
            contactEmail.setText(mContact.getEmail());
            contactAddress.setText(String.format("%s, %s, \n %s, %s" ,mContact.getAddress().getPostCode(),
                    mContact.getAddress().getStreet(), mContact.getAddress().getCity(), mContact.getAddress().getState()));
        }



    }
}
