package org.gtre.itg.ais2019.seminar;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.gtre.itg.ais2019.R;

import java.util.ArrayList;

public class SeminarOrganisationsFragment extends Fragment {

    private ArrayList<String> organizations;
    private Context mContext;

    public SeminarOrganisationsFragment() {
        // Required empty public constructor
        mContext = this.getContext();

    }

    public static SeminarOrganisationsFragment newInstance(int page, String title) {
        SeminarOrganisationsFragment fragment = new SeminarOrganisationsFragment();
        Bundle args = new Bundle();
        args.putInt("someInt", page);
        args.putString("someTitle", title);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int page = getArguments().getInt("someInt", 0);
        String title = getArguments().getString("someTitle");
        String[] org = getResources().getStringArray(R.array.participating_organizations);
        organizations = new ArrayList<>();
        for(int i=0; i<org.length; i++) {
            organizations.add(org[i]);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_seminar_organisations, container, false);
        RecyclerView rv = view.findViewById(R.id.seminar_organisations_recycler_view);
        rv.setLayoutManager(new LinearLayoutManager(mContext));
        SeminarPORecyclerViewAdapter adapter = new SeminarPORecyclerViewAdapter(mContext, organizations);
        rv.setAdapter(adapter);
        return view;
    }

}
