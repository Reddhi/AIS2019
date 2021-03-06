package org.gtre.itg.ais2019.registration;


import android.media.Image;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import org.gtre.itg.ais2019.R;

public class ItcWindsorFragment extends DialogFragment {

    public ItcWindsorFragment() {
        // Required empty public constructor
    }

    public static ItcWindsorFragment newInstance(String title) {
        ItcWindsorFragment frag = new ItcWindsorFragment();
        Bundle args = new Bundle();
        args.putString("title", title);
        frag.setArguments(args);
        return frag;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_itc_windsor, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // Get field from view
        ImageView closeButton = view.findViewById(R.id.itc_windsor_close);
        closeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getDialog().dismiss();
            }
        });
        // Fetch arguments from bundle and set title
        String title = getArguments().getString("title", getResources().getString(R.string.itc_windsor));
        getDialog().setTitle(title);
        getDialog().getWindow().requestFeature(Window.FEATURE_NO_TITLE);

    }

    @Override
    public void onResume() {
        // Get existing layout params for the window
        ViewGroup.LayoutParams params = getDialog().getWindow().getAttributes();
        // Assign window properties to fill the parent
        params.width = WindowManager.LayoutParams.MATCH_PARENT;
        params.height = WindowManager.LayoutParams.MATCH_PARENT;
        getDialog().getWindow().setAttributes((WindowManager.LayoutParams) params);
        // Call super onResume after sizing
        super.onResume();
    }


}
