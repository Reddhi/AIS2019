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

public class DayOneFragment extends Fragment {

    private ArrayList<SeminarEvent> events;
    private Context mContext;
    private RecyclerView rv;
    private SeminarDayRecyclerViewAdapter adapter;

    public DayOneFragment() {
        // Required empty public constructor
        mContext = this.getContext();
        events = new ArrayList<>();
    }

    public static DayOneFragment newInstance(int page, String title) {
        DayOneFragment fragment = new DayOneFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_day_one, container, false);
        rv = view.findViewById(R.id.day_one_recycler_view);
        rv.setLayoutManager(new LinearLayoutManager(mContext));
        DatabaseReference myRef = FirebaseDatabaseUtility.getDatabase().getReference("events");
        final Query eventQuery = myRef.orderByChild("order");
        eventQuery.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot eventSnapshot) {
                events = new ArrayList<>();
                for (DataSnapshot dataSnapshot : eventSnapshot.getChildren()) {
                    SeminarEvent data = dataSnapshot.getValue(SeminarEvent.class);
                    ArrayList<SeminarSpeaker> speakers = new ArrayList<>();
                    if(data.getDate().equals("18/02/19")){
                        if(data.getSpeaker() != null){
                            SeminarSpeaker s = data.getSpeaker();
                            String name = s.getName();
                            String pos = s.getPosition();
                            String dp = s.getDisplayPicture();
                            String names1[] = name.split(" &&& ");
                            String poss1[] = pos.split(" &&& ");
                            String dps1[] = dp.split(" &&& ");
                            for(int i=0; i< names1.length; i++){
                                if(names1[i].contains("&&")){
                                    String names2[] = names1[i].split(" && ");
                                    String dps2[] = dps1[i].split(" && ");
                                    String pos2 = poss1[i].replace(" && ", "\n");
                                    for(int j=0; j<names2.length; j++){
                                        SeminarSpeaker spk = new SeminarSpeaker();
                                        spk.setName(names2[j]);
                                        spk.setDisplayPicture(dps2[j]);
                                        spk.setPosition(pos2);
                                        spk.setTalkDate(data.getDate());
                                        spk.setTalkId(data.getId());
                                        spk.setTalkType(data.getType());
                                        spk.setTalkLocation(data.getLocation());
                                        spk.setTalkTime(data.getStartTime()+" - "+data.getEndTime());
                                        spk.setTalkTitle(data.getTitle());
                                        speakers.add(spk);
                                    }
                                } else {
                                    SeminarSpeaker spk = new SeminarSpeaker();
                                    spk.setName(names1[i]);
                                    spk.setDisplayPicture(dps1[i]);
                                    spk.setPosition(poss1[i]);
                                    spk.setTalkDate(data.getDate());
                                    spk.setTalkId(data.getId());
                                    spk.setTalkType(data.getType());
                                    spk.setTalkLocation(data.getLocation());
                                    spk.setTalkTime(data.getStartTime()+" - "+data.getEndTime());
                                    spk.setTalkTitle(data.getTitle());
                                    speakers.add(spk);
                                }
                            }
                        }
                        data.setSpeakersList(speakers);
                        events.add(data);
                    }
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
