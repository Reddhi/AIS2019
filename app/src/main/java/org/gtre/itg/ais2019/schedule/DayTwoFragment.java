package org.gtre.itg.ais2019.schedule;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import org.gtre.itg.ais2019.FirebaseDatabaseUtility;
import org.gtre.itg.ais2019.R;

import java.util.ArrayList;

import static android.content.ContentValues.TAG;

/**
 * A simple {@link Fragment} subclass.
 */
public class DayTwoFragment extends Fragment {

    private ArrayList<SeminarEvent> events;
    private Context mContext;
    private RecyclerView rv;
    private SeminarDayRecyclerViewAdapter adapter;

    public DayTwoFragment() {
        // Required empty public constructor
        mContext = this.getContext();
        events = new ArrayList<>();
    }

    public static DayTwoFragment newInstance(int page, String title) {
        DayTwoFragment fragment = new DayTwoFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_day_two, container, false);
        rv = view.findViewById(R.id.day_two_recycler_view);
        rv.setLayoutManager(new LinearLayoutManager(mContext));
        final DatabaseReference myRef = FirebaseDatabaseUtility.getDatabase().getReference("schedule/19022019");
        final Query eventQuery = myRef.orderByKey();
        eventQuery.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot eventSnapshot) {
                events = new ArrayList<>();
                for (DataSnapshot dataSnapshot : eventSnapshot.getChildren()) {
                    SeminarEvent data = dataSnapshot.getValue(SeminarEvent.class);
                    events.add(data);
                }
                adapter = new SeminarDayRecyclerViewAdapter(mContext, events);
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
