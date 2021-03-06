package org.gtre.itg.ais2019.sponsorship;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import org.gtre.itg.ais2019.registration.RegistrationPaymentFragment;

public class SponsorshipPagerAdapter extends FragmentPagerAdapter {
    private static int NUM_ITEMS = 4;

    public SponsorshipPagerAdapter(FragmentManager fragmentManager) {
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
            case 0:
                return  SponsorsFragment.newInstance(0, "2019 Sponsors");
            case 1:
                return SponsorshipOpportunitiesFragment.newInstance(0, "Opportunities");
            case 2:
                return SponsorshipAdvertisementFragment.newInstance(1, "Advertisement");
            case 3:
                return RegistrationPaymentFragment.newInstance(1, "Payment");
            default:
                return null;
        }
    }

    // Returns the page title for the top indicator
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "Sponsors";
            case 1:
                return "Opportunities";
            case 2:
                return "Advertisement";
            case 3:
                return "Payment";
            default:
                return null;
        }
    }

}