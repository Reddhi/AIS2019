package org.gtre.itg.ais2019.seminar;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.gtre.itg.ais2019.R;

public class SeminarAboutFragment extends Fragment {

    public SeminarAboutFragment() {
        // Required empty public constructor
    }

    public static SeminarAboutFragment newInstance(int page, String title) {
        SeminarAboutFragment fragment = new SeminarAboutFragment();
        Bundle args = new Bundle();
        args.putInt("someInt", page);
        args.putString("someTitle", title);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_seminar_about, container, false);
    }

}
