package org.gtre.itg.ais2019.sponsorship;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import org.gtre.itg.ais2019.R;

import java.util.ArrayList;

public class SponsorsRecyclerViewAdapter extends RecyclerView.Adapter<SponsorsRecyclerViewAdapter.FAQViewHolder> {

    private ArrayList<Sponsor> sponsors;
    private Context mContext;

    public SponsorsRecyclerViewAdapter(Context mContext, ArrayList<Sponsor> sponsors) {
        this.mContext = mContext;
        this.sponsors = sponsors;
    }


    @Override
    public int getItemCount() {
        return sponsors.size();
    }

    @Override
    public FAQViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_rv_sponsors, parent, false);

        return new FAQViewHolder(view);
    }

    @Override
    public void onBindViewHolder(FAQViewHolder holder, int position) {
        final Sponsor data = sponsors.get(position);
        if (data.getImage() != null) {
            String url = data.getImage();
            Glide.with(mContext)
                    .load(url)
                    .into(holder.image);
        } else {
            // make sure Glide doesn't load anything into this view until told otherwise
            Glide.with(mContext).clear(holder.image);
            // remove the placeholder (optional); read comments below
            holder.image.setImageDrawable(null);
        }
    }

    class FAQViewHolder extends RecyclerView.ViewHolder {

        private final ImageView image;

        FAQViewHolder(final View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.sponsor_image);
        }

    }
}

