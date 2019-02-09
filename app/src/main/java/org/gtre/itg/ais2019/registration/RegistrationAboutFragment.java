package org.gtre.itg.ais2019.registration;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.gtre.itg.ais2019.R;

public class RegistrationAboutFragment extends Fragment {


    public RegistrationAboutFragment() {
        // Required empty public constructor
    }

    public static RegistrationAboutFragment newInstance(int page, String title) {
        RegistrationAboutFragment fragment = new RegistrationAboutFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_registration_about, container, false);
    }

}
