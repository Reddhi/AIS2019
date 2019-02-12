package org.gtre.itg.ais2019.schedule;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.mikhaellopez.circularimageview.CircularImageView;

import org.gtre.itg.ais2019.DownloadImageTask;
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
        
        holder.speakerName1.setText(event.getSpeakersList().get(0).getName());
        holder.speakerPos1.setText(event.getSpeakersList().get(0).getPosition());
        if (event.getSpeakersList().get(0).getDisplayPicture() != null) {
            new DownloadImageTask(holder.speakerDp1).execute(event.getSpeakersList().get(0).getDisplayPicture());
        } else {
            holder.speakerDp1.setImageDrawable(null);
        }
        holder.speakerView1.setVisibility(View.VISIBLE);
        
        if(event.getSpeakersList().size()>1){
            holder.speakerName2.setText(event.getSpeakersList().get(1).getName());
            holder.speakerPos2.setText(event.getSpeakersList().get(1).getPosition());
            if (event.getSpeakersList().get(1).getDisplayPicture() != null) {
                new DownloadImageTask(holder.speakerDp2).execute(event.getSpeakersList().get(1).getDisplayPicture());
            } else {
                holder.speakerDp2.setImageDrawable(null);
            }
            holder.speakerView2.setVisibility(View.VISIBLE);
        }

        if(event.getSpeakersList().size()>2){
            holder.speakerName3.setText(event.getSpeakersList().get(2).getName());
            holder.speakerPos3.setText(event.getSpeakersList().get(2).getPosition());
            if (event.getSpeakersList().get(2).getDisplayPicture() != null) {
                new DownloadImageTask(holder.speakerDp3).execute(event.getSpeakersList().get(2).getDisplayPicture());
            } else {
                holder.speakerDp3.setImageDrawable(null);
            }
            holder.speakerView3.setVisibility(View.VISIBLE);
        }

        if(event.getSpeakersList().size()>3){
            holder.speakerName4.setText(event.getSpeakersList().get(3).getName());
            holder.speakerPos4.setText(event.getSpeakersList().get(3).getPosition());
            if (event.getSpeakersList().get(3).getDisplayPicture() != null) {
                new DownloadImageTask(holder.speakerDp4).execute(event.getSpeakersList().get(3).getDisplayPicture());
            } else {
                holder.speakerDp4.setImageDrawable(null);
            }
            holder.speakerView4.setVisibility(View.VISIBLE);
        }
    }

    class SeminarDayViewHolder extends RecyclerView.ViewHolder {

        private final TextView title;
        private final TextView time;
        private final TextView location;
        private final LinearLayout container;
        private final LinearLayout speakerView1;
        private final TextView speakerName1;
        private final TextView speakerPos1;
        private final CircularImageView speakerDp1;

        private final LinearLayout speakerView2;
        private final TextView speakerName2;
        private final TextView speakerPos2;
        private final CircularImageView speakerDp2;

        private final LinearLayout speakerView3;
        private final TextView speakerName3;
        private final TextView speakerPos3;
        private final CircularImageView speakerDp3;

        private final LinearLayout speakerView4;
        private final TextView speakerName4;
        private final TextView speakerPos4;
        private final CircularImageView speakerDp4;

        SeminarDayViewHolder(final View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.rv_event_title_view);
            time = itemView.findViewById(R.id.rv_event_time_view);
            location = itemView.findViewById(R.id.rv_event_location_view);
            container = itemView.findViewById(R.id.rv_event_details_container_view);
            
            speakerView1 = itemView.findViewById(R.id.rv_event_speaker_1);
            speakerName1 = itemView.findViewById(R.id.rv_speaker_name_1);
            speakerPos1 = itemView.findViewById(R.id.rv_speaker_position_1);
            speakerDp1 = itemView.findViewById(R.id.rv_speaker_image_1);

            speakerView2 = itemView.findViewById(R.id.rv_event_speaker_2);
            speakerName2 = itemView.findViewById(R.id.rv_speaker_name_2);
            speakerPos2 = itemView.findViewById(R.id.rv_speaker_position_2);
            speakerDp2 = itemView.findViewById(R.id.rv_speaker_image_2);

            speakerView3 = itemView.findViewById(R.id.rv_event_speaker_3);
            speakerName3 = itemView.findViewById(R.id.rv_speaker_name_3);
            speakerPos3 = itemView.findViewById(R.id.rv_speaker_position_3);
            speakerDp3 = itemView.findViewById(R.id.rv_speaker_image_3);

            speakerView4 = itemView.findViewById(R.id.rv_event_speaker_4);
            speakerName4 = itemView.findViewById(R.id.rv_speaker_name_4);
            speakerPos4 = itemView.findViewById(R.id.rv_speaker_position_4);
            speakerDp4 = itemView.findViewById(R.id.rv_speaker_image_4);

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
