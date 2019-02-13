package org.gtre.itg.ais2019.seminar;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.gtre.itg.ais2019.R;

import java.util.ArrayList;

public class SeminarPORecyclerViewAdapter extends RecyclerView.Adapter<SeminarPORecyclerViewAdapter.SeminarPOViewHolder> {

    private ArrayList<String> org;
    private Context mContext;

    public SeminarPORecyclerViewAdapter(Context mContext, ArrayList<String> org) {
        this.mContext = mContext;
        this.org = org;
    }


    @Override
    public int getItemCount() {
        return org.size();
    }

    @Override
    public SeminarPORecyclerViewAdapter.SeminarPOViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_rv_organizations, parent, false);

        return new SeminarPORecyclerViewAdapter.SeminarPOViewHolder(view);
    }

    @Override
    public void onBindViewHolder(SeminarPORecyclerViewAdapter.SeminarPOViewHolder holder, int position) {
        holder.text.setText(org.get(position));
    }

    class SeminarPOViewHolder extends RecyclerView.ViewHolder {

        private final TextView text;

        SeminarPOViewHolder(final View itemView) {
            super(itemView);
            text = itemView.findViewById(R.id.rv_item_title);
        }

    }
}
