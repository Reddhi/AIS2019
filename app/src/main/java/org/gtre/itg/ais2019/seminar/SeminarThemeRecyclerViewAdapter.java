package org.gtre.itg.ais2019.seminar;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.gtre.itg.ais2019.R;

import java.util.ArrayList;

public class SeminarThemeRecyclerViewAdapter extends RecyclerView.Adapter<SeminarThemeRecyclerViewAdapter.SeminarThemeViewHolder> {

    private ArrayList<SeminarTheme> themes;
    private Context mContext;

    public SeminarThemeRecyclerViewAdapter(Context mContext, ArrayList<SeminarTheme> themes) {
        this.mContext = mContext;
        this.themes = themes;
    }


    @Override
    public int getItemCount() {
        return themes.size();
    }

    @Override
    public SeminarThemeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_rv_faq, parent, false);

        return new SeminarThemeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(SeminarThemeViewHolder holder, int position) {
        holder.ques.setText(themes.get(position).getTopic());
        holder.ans.setText(themes.get(position).getDetails());
    }

    class SeminarThemeViewHolder extends RecyclerView.ViewHolder {

        private final TextView ques;
        private final TextView ans;
        private final LinearLayout ansView;

        SeminarThemeViewHolder(final View itemView) {
            super(itemView);
            ques = itemView.findViewById(R.id.rv_title_view);
            ans = itemView.findViewById(R.id.rv_details_view);
            ansView = itemView.findViewById(R.id.rv_details_container_view);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ansView.requestFocus();
                    if (ansView.getVisibility() == View.GONE) {
                        ansView.setVisibility(View.VISIBLE);
                    } else {
                        ansView.setVisibility(View.GONE);
                    }
                }
            });
        }

    }
}
