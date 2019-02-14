package org.gtre.itg.ais2019.sponsorship;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import org.gtre.itg.ais2019.FirebaseDatabaseUtility;
import org.gtre.itg.ais2019.R;

import java.util.ArrayList;

import static android.content.ContentValues.TAG;

public class SponsorsFragment extends Fragment {

    private Context mContext;
    private RecyclerView rv;
    private ArrayList<Sponsor> sponsors;

    public SponsorsFragment() {
        // Required empty public constructor
    }

    public static SponsorsFragment newInstance(int page, String title) {
        SponsorsFragment fragment = new SponsorsFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_sponsors, container, false);
        mContext = this.getActivity().getBaseContext();
        rv = view.findViewById(R.id.sponsors_recycler_view);
        rv.setLayoutManager(new GridLayoutManager(mContext, 2){
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        });
        DatabaseReference myRef = FirebaseDatabaseUtility.getDatabase().getReference("sponsors");
        final Query eventQuery = myRef.orderByKey();
        eventQuery.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot eventSnapshot) {
                sponsors = new ArrayList<>();
                for (DataSnapshot dataSnapshot : eventSnapshot.getChildren()) {
                    Sponsor data = dataSnapshot.getValue(Sponsor.class);
                    sponsors.add(data);
                }
                SponsorsRecyclerViewAdapter adapter = new SponsorsRecyclerViewAdapter(mContext, sponsors);
                rv.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });
        return view;
    }

}
