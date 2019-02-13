package org.gtre.itg.ais2019.contact;

import java.io.Serializable;

public class ContactPerson implements Serializable{

    private String category;
    private String name;
    private String mobile;

    public ContactPerson() {
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}
