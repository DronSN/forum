package ru.skvrez.forum.start;

import ru.skvrez.forum.model.GenerateMessagesParameters;
import ru.skvrez.forum.model.Message;
import ru.skvrez.forum.model.Topic;
import ru.skvrez.forum.model.User;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class GenerateForumObjects {
    private static int randomSeed = 64;
    private final int NUMBER_OF_USERS = 10;
    private final int NUMBER_OF_TOPICS = 10;
    private final int NUMBER_OF_MESSAGES = 20;
    private List<User> userList;
    private List<Topic> topicList;
    private List<Message> messageList;

    private static GenerateForumObjects singleInstance = null;

    public List<User> getUserList() {
        return userList;
    }

    public List<Topic> getTopicList() {
        return topicList;
    }

    public List<Message> getMessageList() {
        return messageList;
    }

    public static GenerateForumObjects getInstance(){
        if (singleInstance == null){
            singleInstance = new GenerateForumObjects();
        }
        return singleInstance;
    }
    private GenerateForumObjects() {
        generateObjects();
    }

    private void generateObjects() {
        userList = generateUsers(NUMBER_OF_USERS);
        topicList = generateTopics(NUMBER_OF_TOPICS);
        messageList = generateMessages(new GenerateMessagesParameters(userList, topicList, NUMBER_OF_MESSAGES));
    }

    private List<User> generateUsers(int numberOfUsers){
        List<User> userList = new ArrayList<User>();
        for (int index = 0; index < numberOfUsers; index++){
            Random randomAge = new Random(index);
            User user = new User();
            user.setAge(10 + randomAge.nextInt(90));
            user.setFirstName(index + "FirstUserName");
            user.setSecondName(index + "SecondUserName");
            userList.add(user);
        }
        return userList;
    }

    private List<Topic> generateTopics(int numberOfTopics){
        List<Topic> topicList = new ArrayList<>();
        for (int index = 0; index < numberOfTopics; index++){
            Topic topic = new Topic();
            topic.setDate(new Date(System.currentTimeMillis()));
            topic.setDescription("Topic" + index + generateText(30));
            topicList.add(topic);
        }
        return topicList;
    }

    private List<Message> generateMessages(GenerateMessagesParameters parameters){
        List<Message> messageList = new ArrayList<>();
        int numberOfMessages = parameters.getNumberOfMessages();
        for (int index = 0; index < numberOfMessages; index ++){
            Message message = new Message();
            message.setDate(new Date(System.currentTimeMillis()));
            message.setMessage("Message" + index + generateText(40));
            message.setTopic(returnRandomListElement(parameters.getTopicList()));
            message.setUser(returnRandomListElement(parameters.getUserList()));
            messageList.add(message);
        }
        return messageList;
    }

    private String generateText(int numberOfChars){
        Random randomInt = new Random(getRandomSeed());
        StringBuilder resultString  = new StringBuilder();
        for (int index = 0; index < numberOfChars; index++){
            int numberRussiansChars = 66;
            int charCode = 0x410 + randomInt.nextInt(numberRussiansChars);
            resultString.append((char) charCode);
        }
        return resultString.toString();
    }

    private static <T> T returnRandomListElement(List<T> list){
        Random randomNumber = new Random(getRandomSeed());
        int elementNumber = randomNumber.nextInt(list.size());
        return list.get(elementNumber);
    }

    private static int getRandomSeed(){
        return randomSeed++;
    }
}
