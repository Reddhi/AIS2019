package org.gtre.itg.ais2019.sponsorship;


import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.gtre.itg.ais2019.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class SponsorshipOpportunitiesFragment extends Fragment {


    public SponsorshipOpportunitiesFragment() {
        // Required empty public constructor
    }

    public static SponsorshipOpportunitiesFragment newInstance(int page, String title) {
        SponsorshipOpportunitiesFragment fragment = new SponsorshipOpportunitiesFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_sponsorship_opportunities, container, false);
        TextView diamond = view.findViewById(R.id.diamond_button);
        TextView platinum = view.findViewById(R.id.platinum_button);
        TextView gold = view.findViewById(R.id.gold_button);
        TextView silver = view.findViewById(R.id.silver_button);
        diamond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fm = getActivity().getSupportFragmentManager();
                DiamondFragment dialogFragment = DiamondFragment.newInstance("Diamond");
                dialogFragment.setStyle(DialogFragment.STYLE_NORMAL, R.style.Dialog_FullScreen);
                dialogFragment.show(fm, "Diamond");
            }
        });
        platinum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fm = getActivity().getSupportFragmentManager();
                PlatinumFragment dialogFragment = PlatinumFragment.newInstance("Platinum");
                dialogFragment.setStyle(DialogFragment.STYLE_NORMAL, R.style.Dialog_FullScreen);
                dialogFragment.show(fm, "Platinum");
            }
        });
        gold.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fm = getActivity().getSupportFragmentManager();
                GoldFragment dialogFragment = GoldFragment.newInstance("Gold");
                dialogFragment.setStyle(DialogFragment.STYLE_NORMAL, R.style.Dialog_FullScreen);
                dialogFragment.show(fm, "Gold");
            }
        });
        silver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fm = getActivity().getSupportFragmentManager();
                SilverFragment dialogFragment = SilverFragment.newInstance("Silver");
                dialogFragment.setStyle(DialogFragment.STYLE_NORMAL, R.style.Dialog_FullScreen);
                dialogFragment.show(fm, "Silver");
            }
        });
        return view;
    }

}
