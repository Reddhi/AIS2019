package org.gtre.itg.ais2019.schedule;

import java.io.Serializable;
import java.util.ArrayList;

public class SeminarEvent implements Serializable{

    private String id;
    private String title;
    private String theme;
    private int order;
    private String date;
    private String startTime;
    private String endTime;
    private String location;
    private String type;
    private SeminarSpeaker speaker;
    private ArrayList<SeminarSpeaker> speakersList;

    public SeminarEvent() {
    }

    public SeminarEvent(String title, String startTime, String endTime, String location) {
        this.title = title;
        this.startTime = startTime;
        this.endTime = endTime;
        this.location = location;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public SeminarSpeaker getSpeaker() {
        return speaker;
    }

    public void setSpeaker(SeminarSpeaker speaker) {
        this.speaker = speaker;
    }

    public ArrayList<SeminarSpeaker> getSpeakersList() {
        return speakersList;
    }

    public void setSpeakersList(ArrayList<SeminarSpeaker> speakersList) {
        this.speakersList = speakersList;
    }
}
