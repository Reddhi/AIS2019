package org.gtre.itg.ais2019.schedule;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.viewpagerindicator.TitlePageIndicator;

import org.gtre.itg.ais2019.R;

public class ScheduleFragment extends Fragment {

    private Context mContext;

    public ScheduleFragment() {
        // Required empty public constructor
        mContext = getContext();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_schedule, container, false);
        ViewPager mViewPager = view.findViewById(R.id.schedule_view_pager);
        mViewPager.setAdapter(new SchedulePagerAdapter(getChildFragmentManager()));
        TitlePageIndicator titleIndicator = view.findViewById(R.id.schedule_titles);
        titleIndicator.setSelectedBold(true);
        titleIndicator.setViewPager(mViewPager);
        return view;
    }

}
