package org.gtre.itg.ais2019.registration;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class RegistrationPagerAdapter extends FragmentPagerAdapter {
    private static int NUM_ITEMS = 4;

    public RegistrationPagerAdapter(FragmentManager fragmentManager) {
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
                return RegistrationAboutFragment.newInstance(0, "About");
            case 1:
                return RegistrationOnlineFragment.newInstance(1, "Online");
            case 2: // Fragment # 0 - This will show FirstFragment different title
                return RegistrationSecurityFragment.newInstance(1, "Security");
            case 3: // Fragment # 0 - This will show FirstFragment different title
                return RegistrationPaymentFragment.newInstance(2, "Payment");
            case 4:
                return RegistrationAccommodationFragment.newInstance(3, "Accommodation");
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
                return "Online";
            case 2:
                return "Security";
            case 3:
                return "Payment";
            case 4:
                return "Accommodation";
            default:
                return null;
        }
    }

}