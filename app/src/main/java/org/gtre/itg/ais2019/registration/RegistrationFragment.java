package org.gtre.itg.ais2019.registration;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.viewpagerindicator.TitlePageIndicator;

import org.gtre.itg.ais2019.R;

public class RegistrationFragment extends Fragment {


    public RegistrationFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_registration, container, false);
        ViewPager mViewPager = view.findViewById(R.id.registration_view_pager);
        mViewPager.setAdapter(new RegistrationPagerAdapter(getChildFragmentManager()));
        TitlePageIndicator titleIndicator = view.findViewById(R.id.registration_titles);
        titleIndicator.setSelectedBold(true);
        titleIndicator.setViewPager(mViewPager);
        return view;
    }

}
