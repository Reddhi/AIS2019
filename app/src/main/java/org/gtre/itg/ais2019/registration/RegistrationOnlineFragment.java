package org.gtre.itg.ais2019.registration;


import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import org.gtre.itg.ais2019.R;

public class RegistrationOnlineFragment extends Fragment {


    public RegistrationOnlineFragment() {
        // Required empty public constructor
    }

    public static RegistrationOnlineFragment newInstance(int page, String title) {
        RegistrationOnlineFragment fragment = new RegistrationOnlineFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_registration_online, container, false);
        TextView onlineButton = view.findViewById(R.id.online_registration_button);
        onlineButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.aeroindiaseminar.com/online-registration/"));
                    startActivity(browserIntent);
                } catch (ActivityNotFoundException e) {
                    Toast.makeText(getContext(), "No application can handle this request. Please install a web browser",  Toast.LENGTH_SHORT).show();
                    e.printStackTrace();
                }
            }
        });
        return view;
    }

}
