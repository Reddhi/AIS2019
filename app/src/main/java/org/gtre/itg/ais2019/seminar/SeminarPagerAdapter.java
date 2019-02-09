package org.gtre.itg.ais2019.seminar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class SeminarPagerAdapter extends FragmentPagerAdapter {
    private static int NUM_ITEMS = 3;

    public SeminarPagerAdapter(FragmentManager fragmentManager) {
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
                return SeminarAboutFragment.newInstance(0, "About");
            case 1: // Fragment # 0 - This will show FirstFragment different title
                return SeminarThemeFragment.newInstance(1, "Themes");
            case 2: // Fragment # 0 - This will show FirstFragment different title
                return SeminarOrganisationsFragment.newInstance(1, "Participating Organisations");
            default:
                return null;
        }
    }

    // Returns the page title for the top indicator
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "About";
            case 1:
                return "Themes";
            case 2:
                return "Participating Organisations";
            default:
                return null;
        }
    }

}

