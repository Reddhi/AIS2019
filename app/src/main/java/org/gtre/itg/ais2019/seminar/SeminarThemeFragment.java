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

public class SeminarThemeFragment extends Fragment {

    private ArrayList<SeminarTheme> themes;
    private Context mContext;

    public SeminarThemeFragment() {
        // Required empty public constructor
        mContext = this.getContext();
    }

    public static SeminarThemeFragment newInstance(int page, String title) {
        SeminarThemeFragment fragment = new SeminarThemeFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        themes = new ArrayList<>();
        String[] topics = getResources().getStringArray(R.array.theme_topics);
        String[] details = getResources().getStringArray(R.array.theme_details);
        for(int i=0; i<topics.length; i++) {
            SeminarTheme theme = new SeminarTheme(topics[i], details[i]);
            themes.add(theme);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
            View view = inflater.inflate(R.layout.fragment_seminar_theme, container, false);
            RecyclerView rv = view.findViewById(R.id.seminar_theme_recycler_view);
            rv.setLayoutManager(new LinearLayoutManager(mContext));
            SeminarThemeRecyclerViewAdapter adapter = new SeminarThemeRecyclerViewAdapter(mContext, themes);
            rv.setAdapter(adapter);
            return view;
    }

}
