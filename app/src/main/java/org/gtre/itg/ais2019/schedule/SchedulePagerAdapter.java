package org.gtre.itg.ais2019.schedule;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class SchedulePagerAdapter extends FragmentPagerAdapter {
    private static int NUM_ITEMS = 2;

    public SchedulePagerAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
    }

    // Returns total number of pages
    @Override
    public int getCount() {
        return NUM_ITEMS;
    }

    // Returns the fragment to display for that page
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0: // Fragment # 0 - This will show FirstFragment
                return DayOneFragment.newInstance(0, "18th Feb");
            case 1: // Fragment # 0 - This will show FirstFragment different title
                return DayTwoFragment.newInstance(1, "19th Feb");
            default:
                return null;
        }
    }

    // Returns the page title for the top indicator
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "18th Feb";
            case 1:
                return "19th Feb";
            default:
                return null;
        }
    }

}