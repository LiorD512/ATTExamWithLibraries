package com.att.attexamwithlibraries.adapters;

import android.annotation.SuppressLint;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.att.attexamwithlibraries.R;
import com.att.attexamwithlibraries.interfaces.OnItemClickListener;
import com.att.attexamwithlibraries.model.Contact;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ContactListAdapter extends RecyclerView.Adapter<ContactListAdapter.ViewHolder> {

    private List<Contact> mContactList;
    private OnItemClickListener mOnItemClickListener;


    public ContactListAdapter(List<Contact> contacts, OnItemClickListener onItemClickListener) {
        this.mContactList = contacts;
        this.mOnItemClickListener = onItemClickListener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_contact, parent, false);
        return new ViewHolder(v);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        Contact contact  = mContactList.get(holder.getAdapterPosition());
        holder.contactName.setText(String.format("%s", contact.getContactName().getFirstName() + " " + contact.getContactName().getLastName()));
        holder.contactPhone.setText(contact.getPhoneNumber());
        Picasso.get()
                .load(contact.getContactPicture().getLarge())
                .fit()
                .into(holder.contactImage);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mOnItemClickListener != null) {
                    mOnItemClickListener.OnItemClickListener(holder.getAdapterPosition());
                }

            }
        });

    }

    @Override
    public int getItemCount() {
        return mContactList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView contactName;
        private TextView contactPhone;
        private ImageView contactImage;

        ViewHolder(View itemView) {
            super(itemView);
            contactName = (TextView) itemView.findViewById(R.id.contact_name);
            contactPhone = (TextView) itemView.findViewById(R.id.contact_phone);
            contactImage = (ImageView) itemView.findViewById(R.id.contact_image);
        }
}
}
