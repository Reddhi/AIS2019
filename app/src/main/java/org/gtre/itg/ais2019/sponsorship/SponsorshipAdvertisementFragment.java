package org.gtre.itg.ais2019.sponsorship;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.gtre.itg.ais2019.R;

public class SponsorshipAdvertisementFragment extends Fragment {


    public SponsorshipAdvertisementFragment() {
        // Required empty public constructor
    }

    public static SponsorshipAdvertisementFragment newInstance(int page, String title) {
        SponsorshipAdvertisementFragment fragment = new SponsorshipAdvertisementFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sponsorship_advertisement, container, false);
    }

}
