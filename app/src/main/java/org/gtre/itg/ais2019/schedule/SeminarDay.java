package org.gtre.itg.ais2019.schedule;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class SeminarDay implements Serializable {

    private String id;
    private Date date;
    private String day;
    private ArrayList<SeminarEvent> events;

    public SeminarDay() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public ArrayList<SeminarEvent> getEvents() {
        return events;
    }

    public void setEvents(ArrayList<SeminarEvent> events) {
        this.events = events;
    }
}
