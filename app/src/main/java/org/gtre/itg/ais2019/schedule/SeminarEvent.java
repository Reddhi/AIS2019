package org.gtre.itg.ais2019.schedule;

import java.io.Serializable;

public class SeminarEvent implements Serializable{

    private String id;
    private String title;
    private String startTime;
    private String endTime;
    private String location;
    private String type;

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
}
