package org.gtre.itg.ais2019.registration;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.gtre.itg.ais2019.R;

import java.util.ArrayList;

public class RegistrationAccommodationRecyclerViewAdapter extends RecyclerView.Adapter<RegistrationAccommodationRecyclerViewAdapter.RegistrationAccommodationViewHolder> {

    private ArrayList<String> titles;
    private ArrayList<String> details;
    private Context mContext;

    public RegistrationAccommodationRecyclerViewAdapter(Context mContext, ArrayList<String> titles, ArrayList<String> details) {
        this.mContext = mContext;
        this.titles = titles;
        this.details = details;
    }


    @Override
    public int getItemCount() {
        return details.size();
    }

    @Override
    public RegistrationAccommodationRecyclerViewAdapter.RegistrationAccommodationViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_rv_faq, parent, false);

        return new RegistrationAccommodationRecyclerViewAdapter.RegistrationAccommodationViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RegistrationAccommodationRecyclerViewAdapter.RegistrationAccommodationViewHolder holder, int position) {
        holder.title.setText(titles.get(position));
        holder.details.setText(details.get(position));
    }

    class RegistrationAccommodationViewHolder extends RecyclerView.ViewHolder {

        private final TextView title;
        private final TextView details;
        private final LinearLayout container;

        RegistrationAccommodationViewHolder(final View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.rv_title_view);
            details = itemView.findViewById(R.id.rv_details_view);
            container = itemView.findViewById(R.id.rv_details_container_view);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    container.requestFocus();
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
