package ru.skvrez.forum.model;

import javax.persistence.*;
import java.util.Date;
@Entity
@Table
public class Topic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String description;
    @Column
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
