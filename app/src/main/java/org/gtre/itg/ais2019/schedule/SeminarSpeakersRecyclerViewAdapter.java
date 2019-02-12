package org.gtre.itg.ais2019.schedule;

import android.content.Context;
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

public class SeminarSpeakersRecyclerViewAdapter extends RecyclerView.Adapter<SeminarSpeakersRecyclerViewAdapter.SeminarSpeakersViewHolder> {

    private ArrayList<SeminarSpeaker> speakers = new ArrayList<>();
    private Context mContext;

    public SeminarSpeakersRecyclerViewAdapter(Context mContext, ArrayList<SeminarSpeaker> speakers) {
        this.mContext = mContext;
        this.speakers = speakers;
    }


    @Override
    public int getItemCount() {
        return speakers.size();
    }

    @Override
    public SeminarSpeakersRecyclerViewAdapter.SeminarSpeakersViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_rv_with_details_3, parent, false);
        return new SeminarSpeakersRecyclerViewAdapter.SeminarSpeakersViewHolder(view);
    }

    @Override
    public void onBindViewHolder(SeminarSpeakersRecyclerViewAdapter.SeminarSpeakersViewHolder holder, int position) {
        SeminarSpeaker speaker = speakers.get(position);
        holder.name.setText(speaker.getName());
        holder.position.setText(speaker.getPosition());
        holder.time.setText(speaker.getTalkTime());
        holder.location.setText(speaker.getTalkLocation());
        holder.date.setText(speaker.getTalkDate());
        holder.title.setText(speaker.getTalkTitle());
        if (speaker.getDisplayPicture() != null) {
            new DownloadImageTask(holder.image).execute(speaker.getDisplayPicture());
        } else {
            holder.image.setImageDrawable(null);
        }

    }

    class SeminarSpeakersViewHolder extends RecyclerView.ViewHolder {

        private final TextView name;
        private final TextView position;
        private final CircularImageView image;
        private final TextView title;
        private final TextView date;
        private final TextView time;
        private final TextView location;
        private final LinearLayout container;

        SeminarSpeakersViewHolder(final View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.rv_talk_title_view);
            date = itemView.findViewById(R.id.rv_talk_date_view);
            time = itemView.findViewById(R.id.rv_talk_time_view);
            location = itemView.findViewById(R.id.rv_talk_location_view);
            name = itemView.findViewById(R.id.rv_speaker_name_view);
            position = itemView.findViewById(R.id.rv_speaker_position_view);
            image = itemView.findViewById(R.id.rv_speaker_image_view);
            container = itemView.findViewById(R.id.rv_speaker_talk_container_view);

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
