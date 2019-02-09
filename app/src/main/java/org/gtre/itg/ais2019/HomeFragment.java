package org.gtre.itg.ais2019;


import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v4.app.Fragment;
import android.text.format.DateUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Calendar;
import java.util.Date;

public class HomeFragment extends Fragment {

    private TextView daysView, hoursView, minutesView, secondsView;
    private LinearLayout timerContainer;
    private String days, hours, minutes, seconds;

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_home, container, false);
        daysView = view.findViewById(R.id.days_left_view);
        hoursView = view.findViewById(R.id.hours_left_view);
        minutesView = view.findViewById(R.id.minutes_left_view);
        secondsView = view.findViewById(R.id.seconds_left_view);
        timerContainer = view.findViewById(R.id.countdown_timer_view);
        Calendar targetDate = Calendar.getInstance();
        targetDate.set(2019, 1, 18, 9,30);
        long currentTime = new Date().getTime();
        long targetTime = targetDate.getTimeInMillis();
        long ttl = targetTime - currentTime;
        CountDownTimer mCountDownTimer = new CountDownTimer(ttl, 1000) {
            @Override
            public void onFinish() {
                secondsView.setText(DateUtils.formatElapsedTime(0));
                minutesView.setText(DateUtils.formatElapsedTime(0));
                hoursView.setText(DateUtils.formatElapsedTime(0));
                daysView.setText(DateUtils.formatElapsedTime(0));
                timerContainer.setVisibility(View.GONE);
            }
            @Override
            public void onTick(long millisUntilFinished) {
                // Use days if appropriate
                if(millisUntilFinished > DateUtils.DAY_IN_MILLIS) {
                    long count = millisUntilFinished / DateUtils.DAY_IN_MILLIS;
                    days = count+"";
                    daysView.setText(days);
                    millisUntilFinished %= DateUtils.DAY_IN_MILLIS;
                }
                if(millisUntilFinished > DateUtils.HOUR_IN_MILLIS) {
                    long count = millisUntilFinished / DateUtils.HOUR_IN_MILLIS;
                    hours = count+"";
                    hoursView.setText(hours);
                    millisUntilFinished %= DateUtils.HOUR_IN_MILLIS;
                }
                if(millisUntilFinished > DateUtils.MINUTE_IN_MILLIS) {
                    long count = millisUntilFinished / DateUtils.MINUTE_IN_MILLIS;
                    minutes = count+"";
                    minutesView.setText(minutes);
                    millisUntilFinished %= DateUtils.MINUTE_IN_MILLIS;
                }
                if(millisUntilFinished > DateUtils.SECOND_IN_MILLIS) {
                    long count = millisUntilFinished / DateUtils.SECOND_IN_MILLIS;
                    seconds = count+"";
                    secondsView.setText(seconds);
                }
            }
        }.start();
        return view;
    }

}
