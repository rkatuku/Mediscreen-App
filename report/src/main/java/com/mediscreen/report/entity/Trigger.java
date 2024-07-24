package com.mediscreen.report.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document
public class Trigger {
    @Id
    private int id;
    private String triggerCriteria;
    private Date created;

    public Trigger(String triggerCriteria) {
        this.triggerCriteria = triggerCriteria;
    }

    public Trigger() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTriggerCriteria() {
        return triggerCriteria;
    }

    public void setTriggerCriteria(String triggerCriteria) {
        this.triggerCriteria = triggerCriteria;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }
}
