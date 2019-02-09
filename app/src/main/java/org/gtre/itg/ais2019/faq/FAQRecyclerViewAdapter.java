package org.gtre.itg.ais2019.faq;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.gtre.itg.ais2019.R;

import java.util.ArrayList;

public class FAQRecyclerViewAdapter extends RecyclerView.Adapter<FAQRecyclerViewAdapter.FAQViewHolder> {

    private ArrayList<FAQ> faqs;
    private Context mContext;

    public FAQRecyclerViewAdapter(Context mContext, ArrayList<FAQ> faqs) {
        this.mContext = mContext;
        this.faqs = faqs;
    }


    @Override
    public int getItemCount() {
        return faqs.size();
    }

    @Override
    public FAQViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_rv_with_details, parent, false);

        return new FAQViewHolder(view);
    }

    @Override
    public void onBindViewHolder(FAQViewHolder holder, int position) {
        holder.ques.setText(faqs.get(position).getQuestion());
        holder.ans.setText(faqs.get(position).getAnswer());
    }

    class FAQViewHolder extends RecyclerView.ViewHolder {

        private final TextView ques;
        private final TextView ans;
        private final LinearLayout ansView;

        FAQViewHolder(final View itemView) {
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
