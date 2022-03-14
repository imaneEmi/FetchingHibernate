package com.technomaker.demohibernate.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.technomaker.demohibernate.simple.Participant;
import com.technomaker.demohibernate.simple.util.HibernateUtil;

import java.util.List;

public class ParticipantDao {

    public Long save(Participant participant) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        Long participantId = (Long) session.save(participant);

        transaction.commit();
        session.close();

        return participantId;
    }

    public Participant findById(Long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        Participant participant = (Participant) session.get(Participant.class, id);

        transaction.commit();
        session.close();

        return participant;
    }

    public List<Participant> findAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        List<Participant> participants = session.createCriteria(Participant.class).list();

        transaction.commit();
        session.close();

        return participants;
    }

    public void update(Participant participant) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        session.update(participant);

        transaction.commit();
        session.close();
    }

    public void delete(Participant participant) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        session.delete(participant);

        transaction.commit();
        session.close();
    }
}
