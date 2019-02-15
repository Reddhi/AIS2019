package org.gtre.itg.ais2019.contact;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.gtre.itg.ais2019.R;

import java.util.ArrayList;

public class ContactRecyclerViewAdapter extends RecyclerView.Adapter<ContactRecyclerViewAdapter.FAQViewHolder> {

    private ArrayList<ContactPerson> contacts;
    private Context mContext;

    public ContactRecyclerViewAdapter(Context mContext, ArrayList<ContactPerson> contacts) {
        this.mContext = mContext;
        this.contacts = contacts;
    }


    @Override
    public int getItemCount() {
            return contacts.size();
            }

    @Override
    public FAQViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
            View view = inflater.inflate(R.layout.item_rv_contacts, parent, false);

            return new FAQViewHolder(view);
            }

    @Override
    public void onBindViewHolder(FAQViewHolder holder, int position) {
        final ContactPerson data = contacts.get(position);
        holder.name.setText(data.getName());
        String txt = "+91 "+data.getMobile();
        holder.mobile.setText(txt);
        holder.callButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:+91"+data.getMobile()));
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                if (intent.resolveActivity(mContext.getPackageManager()) != null) {
                    mContext.startActivity(intent);
                }
            }
        });
    }

    class FAQViewHolder extends RecyclerView.ViewHolder {

        private final TextView name;
        private final TextView mobile;
        private final LinearLayout callButton;

        FAQViewHolder(final View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.contact_name);
            mobile = itemView.findViewById(R.id.contact_mobile);
            callButton = itemView.findViewById(R.id.contact_call);
        }

    }
}

