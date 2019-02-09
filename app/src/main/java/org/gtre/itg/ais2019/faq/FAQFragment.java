package org.gtre.itg.ais2019.faq;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.gtre.itg.ais2019.R;

import java.util.ArrayList;

public class FAQFragment extends Fragment {

    private ArrayList<FAQ> faqs;
    private Context mContext;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this.getContext();
        faqs = new ArrayList<>();
        String[] quesArray = getResources().getStringArray(R.array.faq_questions);
        String[] ansArray = getResources().getStringArray(R.array.faq_answers);
        for(int i=0; i<quesArray.length; i++){
            FAQ faq = new FAQ(quesArray[i], ansArray[i]);
            faqs.add(faq);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_faq, container, false);
        RecyclerView rv = view.findViewById(R.id.faq_recycler_view);
        rv.setLayoutManager(new LinearLayoutManager(mContext));
        FAQRecyclerViewAdapter adapter = new FAQRecyclerViewAdapter(mContext, faqs);
        rv.setAdapter(adapter);
        return view;
    }


}
