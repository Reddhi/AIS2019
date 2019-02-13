package org.gtre.itg.ais2019.contact;


import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import org.gtre.itg.ais2019.FirebaseDatabaseUtility;
import org.gtre.itg.ais2019.R;

import java.util.ArrayList;

import static android.content.ContentValues.TAG;

public class ContactFragment extends Fragment {

    ArrayList<ContactPerson> registration, accommodation, transport, website;
    Context mContext;
    public ContactFragment() {
        // Required empty public constructor
        this.mContext = getContext();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_contact, container, false);
        final RecyclerView reg, acc, trans, web;

        LinearLayout sec1, sec2, sec3;
        reg = view.findViewById(R.id.con_registration_recycler_view);
        acc = view.findViewById(R.id.con_accommodation_recycler_view);
        trans = view.findViewById(R.id.con_transport_recycler_view);
        web = view.findViewById(R.id.con_website_recycler_view);
        sec1 = view.findViewById(R.id.call_sec_1);
        sec2 = view.findViewById(R.id.call_sec_2);
        sec3 = view.findViewById(R.id.email_sec);

        reg.setLayoutManager(new LinearLayoutManager(mContext));
        acc.setLayoutManager(new LinearLayoutManager(mContext));
        trans.setLayoutManager(new LinearLayoutManager(mContext));
        web.setLayoutManager(new LinearLayoutManager(mContext));

        sec1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:+919740864000"));
                if (intent.resolveActivity(getActivity().getPackageManager()) != null) {
                    startActivity(intent);
                }
            }
        });
        sec2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:+919110247392"));
                if (intent.resolveActivity(getActivity().getPackageManager()) != null) {
                    startActivity(intent);
                }
            }
        });
        sec3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:" + "secretary@aeroindiaseminar.com"));
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Enquiry");
                emailIntent.putExtra(Intent.EXTRA_TEXT, "");
                if (emailIntent.resolveActivity(getActivity().getPackageManager()) != null) {
                    startActivity(emailIntent);
                }
            }
        });

        registration = new ArrayList<>();
        accommodation = new ArrayList<>();
        transport = new ArrayList<>();
        website = new ArrayList<>();

        DatabaseReference myRef = FirebaseDatabaseUtility.getDatabase().getReference("contact");
        final Query eventQuery = myRef.orderByKey();
        eventQuery.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot eventSnapshot) {
                registration = new ArrayList<>();
                accommodation = new ArrayList<>();
                transport = new ArrayList<>();
                website = new ArrayList<>();
                for (DataSnapshot dataSnapshot : eventSnapshot.getChildren()) {
                    ContactPerson data = dataSnapshot.getValue(ContactPerson.class);
                    if(data.getCategory().equals("Transport")){
                        transport.add(data);
                    } else if(data.getCategory().equals("Accommodation")){
                        accommodation.add(data);
                    } else if(data.getCategory().equals("Registration")){
                        registration.add(data);
                    } else if(data.getCategory().equals("Website")){
                        website.add(data);
                    }
                }
                ContactRecyclerViewAdapter adapterT = new ContactRecyclerViewAdapter(mContext, transport);
                trans.setAdapter(adapterT);
                ContactRecyclerViewAdapter adapterR = new ContactRecyclerViewAdapter(mContext, registration);
                reg.setAdapter(adapterR);
                ContactRecyclerViewAdapter adapterA = new ContactRecyclerViewAdapter(mContext, accommodation);
                acc.setAdapter(adapterA);
                ContactRecyclerViewAdapter adapterW = new ContactRecyclerViewAdapter(mContext, website);
                web.setAdapter(adapterW);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });
        return view;
    }

}
