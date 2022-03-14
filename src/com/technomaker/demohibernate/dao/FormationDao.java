package com.technomaker.demohibernate.dao;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.technomaker.demohibernate.simple.Formation;
import com.technomaker.demohibernate.simple.util.HibernateUtil;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class FormationDao {

    public Long save(Formation formation) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        Long formationId = (Long) session.save(formation);

        transaction.commit();
        session.close();

        return formationId;
    }

    public Formation findById(Long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        Formation formation = (Formation) session.get(Formation.class, id);

        transaction.commit();
        session.close();

        return formation;
    }

    public Formation findByTheme(String theme) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        Criteria criteria = session.createCriteria(Formation.class);
        Formation formation = (Formation) criteria.add(Restrictions.eq("theme", theme)).setMaxResults(1)
                .uniqueResult();

        transaction.commit();
        session.close();

        return formation;
    }

    public List<Formation> findAll(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        List<Formation> formations =  session.createCriteria(Formation.class).list();

        transaction.commit();
        session.close();

        return formations;
    }

    public void update(Formation formation) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

         session.update(formation);

        transaction.commit();
        session.close();
    }

    public void delete(Long idFormation){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        String hql = "delete from Formation where id= :idFormation";
        Query query = session.createQuery(hql);
        query.setLong("idFormation", idFormation);
        query.executeUpdate();

        transaction.commit();
        session.close();
    }
}
