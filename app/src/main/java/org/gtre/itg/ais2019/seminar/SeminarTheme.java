package org.gtre.itg.ais2019.seminar;

public class SeminarTheme {

    private String topic;
    private String details;

    public SeminarTheme() {
    }

    public SeminarTheme(String topic, String details) {
        this.topic = topic;
        this.details = details;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
