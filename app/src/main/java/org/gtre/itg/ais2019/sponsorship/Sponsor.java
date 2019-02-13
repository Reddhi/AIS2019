package org.gtre.itg.ais2019.sponsorship;

import java.io.Serializable;

public class Sponsor implements Serializable{

    private String level;
    private String image;

    public Sponsor() {
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
