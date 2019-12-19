package ru.skvrez.forum.start;

import org.hibernate.Session;

public class Main {
    public static void main(String[] args) {

        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        session.beginTransaction();

        GenerateForumObjects forum = GenerateForumObjects.getInstance();

        forum.getUserList().forEach(session::save);
        forum.getTopicList().forEach(session::save);
        forum.getMessageList().forEach(session::save);
        session.getTransaction().commit();
        session.close();

    }
}
