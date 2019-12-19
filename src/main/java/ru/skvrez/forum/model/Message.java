package ru.skvrez.forum.model;

import javax.persistence.*;
import java.util.Date;
@Entity
@Table
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne(targetEntity = User.class)
    private User user;
    @ManyToOne(targetEntity = Topic.class)
    private Topic topic;
    @Column
    private Date date;
    @Column
    private String message;

    public Message() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", user=" + user +
                ", topic=" + topic +
                ", date=" + date +
                ", message='" + message + '\'' +
                '}';
    }
}
