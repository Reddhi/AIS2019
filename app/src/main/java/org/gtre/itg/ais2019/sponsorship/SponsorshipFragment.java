package org.gtre.itg.ais2019.sponsorship;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.viewpagerindicator.TitlePageIndicator;

import org.gtre.itg.ais2019.R;

public class SponsorshipFragment extends Fragment {


    public SponsorshipFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_sponsorship, container, false);
        ViewPager mViewPager = view.findViewById(R.id.sponsorship_view_pager);
        mViewPager.setAdapter(new SponsorshipPagerAdapter(getChildFragmentManager()));
        TitlePageIndicator titleIndicator = view.findViewById(R.id.sponsorship_titles);
        titleIndicator.setSelectedBold(true);
        titleIndicator.setViewPager(mViewPager);
        return view;
    }

}
