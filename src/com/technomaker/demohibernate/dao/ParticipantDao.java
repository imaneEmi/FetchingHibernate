package com.technomaker.demohibernate.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.technomaker.demohibernate.simple.Participant;
import com.technomaker.demohibernate.simple.util.HibernateUtil;

public class ParticipantDao {

    public Long save(Participant participant) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        Long participantId = (Long) session.save(participant);

        transaction.commit();
        session.close();

        return participantId;
    }

    public void update(Participant participant) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

       session.update(participant);

        transaction.commit();
        session.close();
    }
}
