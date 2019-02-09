package org.gtre.itg.ais2019.registration;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.gtre.itg.ais2019.R;

public class RegistrationPaymentFragment extends Fragment {


    public RegistrationPaymentFragment() {
        // Required empty public constructor
    }

    public static RegistrationPaymentFragment newInstance(int page, String title) {
        RegistrationPaymentFragment fragment = new RegistrationPaymentFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_registration_payment, container, false);
    }

}
