package org.gtre.itg.ais2019.schedule;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.gtre.itg.ais2019.R;

import java.util.ArrayList;

public class SeminarDayRecyclerViewAdapter extends RecyclerView.Adapter<SeminarDayRecyclerViewAdapter.SeminarDayViewHolder> {

    private ArrayList<SeminarEvent> events = new ArrayList<>();
    private Context mContext;

    public SeminarDayRecyclerViewAdapter(Context mContext, ArrayList<SeminarEvent> events) {
        this.mContext = mContext;
        this.events = events;
    }


    @Override
    public int getItemCount() {
        return events.size();
    }

    @Override
    public SeminarDayRecyclerViewAdapter.SeminarDayViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_rv_with_details_2, parent, false);
        return new SeminarDayRecyclerViewAdapter.SeminarDayViewHolder(view);
    }

    @Override
    public void onBindViewHolder(SeminarDayRecyclerViewAdapter.SeminarDayViewHolder holder, int position) {
        SeminarEvent event = events.get(position);
        holder.title.setText(event.getTitle());
        String time = event.getStartTime()+" - "+event.getEndTime();
        holder.time.setText(time);
        holder.location.setText(event.getLocation());
    }

    class SeminarDayViewHolder extends RecyclerView.ViewHolder {

        private final TextView title;
        private final TextView time;
        private final TextView location;
        private final LinearLayout container;

        SeminarDayViewHolder(final View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.rv_event_title_view);
            time = itemView.findViewById(R.id.rv_event_time_view);
            location = itemView.findViewById(R.id.rv_event_location_view);
            container = itemView.findViewById(R.id.rv_event_details_container_view);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (container.getVisibility() == View.GONE) {
                        container.setVisibility(View.VISIBLE);
                    } else {
                        container.setVisibility(View.GONE);
                    }
                }
            });
        }
    }
}
