package org.gtre.itg.ais2019.schedule;

import java.io.Serializable;

public class SeminarSpeaker implements Serializable{

    private String name;
    private String position;
    private String displayPicture;
    private String talkId;
    private String talkTitle;
    private String talkType;
    private String talkDate;
    private String talkTime;
    private String talkLocation;

    public SeminarSpeaker() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getDisplayPicture() {
        return displayPicture;
    }

    public void setDisplayPicture(String displayPicture) {
        this.displayPicture = displayPicture;
    }

    public String getTalkId() {
        return talkId;
    }

    public void setTalkId(String talkId) {
        this.talkId = talkId;
    }

    public String getTalkTitle() {
        return talkTitle;
    }

    public void setTalkTitle(String talkTitle) {
        this.talkTitle = talkTitle;
    }

    public String getTalkType() {
        return talkType;
    }

    public void setTalkType(String talkType) {
        this.talkType = talkType;
    }

    public String getTalkDate() {
        return talkDate;
    }

    public void setTalkDate(String talkDate) {
        this.talkDate = talkDate;
    }

    public String getTalkTime() {
        return talkTime;
    }

    public void setTalkTime(String talkTime) {
        this.talkTime = talkTime;
    }

    public String getTalkLocation() {
        return talkLocation;
    }

    public void setTalkLocation(String talkLocation) {
        this.talkLocation = talkLocation;
    }
}
