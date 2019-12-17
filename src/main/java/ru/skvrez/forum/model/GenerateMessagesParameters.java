package ru.skvrez.forum.model;

import java.util.List;

public class GenerateMessagesParameters {
    private List<User> userList;
    private List<Topic> topicList;
    private int numberOfMessages;

    public GenerateMessagesParameters(List<User> userList, List<Topic> topicList, int numberOfMessages) {
        this.userList = userList;
        this.topicList = topicList;
        this.numberOfMessages = numberOfMessages;
    }

    public List<User> getUserList() {
        return userList;
    }

    public List<Topic> getTopicList() {
        return topicList;
    }

    public int getNumberOfMessages() {
        return numberOfMessages;
    }
}
