package org.gtre.itg.ais2019.registration;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.gtre.itg.ais2019.R;

import java.util.ArrayList;

public class RegistrationAccommodationFragment extends Fragment {

    private ArrayList<String> categories;
    private ArrayList<String> details;
    private Context mContext;

    public RegistrationAccommodationFragment() {
        // Required empty public constructor
        mContext = this.getContext();
    }

    public static RegistrationAccommodationFragment newInstance(int page, String title) {
        RegistrationAccommodationFragment fragment = new RegistrationAccommodationFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        categories = new ArrayList<>();
        details = new ArrayList<>();
        String[] cats = getResources().getStringArray(R.array.accommodation_delegate_categories);
        String[] dets = getResources().getStringArray(R.array.accommodation_delegate_details);
        for(int i=0; i<cats.length; i++) {
            categories.add(cats[i]);
            details.add(dets[i]);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_registration_accomodation, container, false);
        RecyclerView rv = view.findViewById(R.id.accommodation_recycler_view);
        rv.setLayoutManager(new LinearLayoutManager(mContext));
        RegistrationAccommodationRecyclerViewAdapter adapter = new RegistrationAccommodationRecyclerViewAdapter(mContext, categories, details);
        rv.setAdapter(adapter);
        TextView royalOrchid = view.findViewById(R.id.royal_orchid);
        TextView itcWindsor = view.findViewById(R.id.itc_windsor);
        TextView leMeridien = view.findViewById(R.id.le_meridien);
        TextView thePark = view.findViewById(R.id.the_park);
        royalOrchid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fm = getActivity().getSupportFragmentManager();
                RoyalOrchidFragment dialogFragment = RoyalOrchidFragment.newInstance("Royal Orchid");
                dialogFragment.setStyle(DialogFragment.STYLE_NORMAL, R.style.Dialog_FullScreen);
                dialogFragment.show(fm, "Royal Orchid");
            }
        });
        itcWindsor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fm = getActivity().getSupportFragmentManager();
                ItcWindsorFragment dialogFragment = ItcWindsorFragment.newInstance("ITC Windsor");
                dialogFragment.setStyle(DialogFragment.STYLE_NORMAL, R.style.Dialog_FullScreen);
                dialogFragment.show(fm, "ITC Windsor");
            }
        });
        leMeridien.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fm = getActivity().getSupportFragmentManager();
                LeMeridienFragment dialogFragment = LeMeridienFragment.newInstance("Le Meridien");
                dialogFragment.setStyle(DialogFragment.STYLE_NORMAL, R.style.Dialog_FullScreen);
                dialogFragment.show(fm, "Le Meridien");
            }
        });
        thePark.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fm = getActivity().getSupportFragmentManager();
                TheParkFragment dialogFragment = TheParkFragment.newInstance("The Park");
                dialogFragment.setStyle(DialogFragment.STYLE_NORMAL, R.style.Dialog_FullScreen);
                dialogFragment.show(fm, "The Park");
            }
        });
        return view;
    }

}
