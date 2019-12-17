package ru.skvrez.forum.model;

import java.util.Date;

public class Topic {
    private int id;
    private String description;
    private Date date;

    public Topic() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Topic{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", date=" + date +
                '}';
    }
}
