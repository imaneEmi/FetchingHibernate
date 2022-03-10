package com.technomaker.demohibernate.simple.util;

import org.hibernate.*;
import org.hibernate.cfg.*;

public class HibernateUtil {

    private static final SessionFactory sessionFactory;

    static {
        try {
            sessionFactory = new Configuration().configure().buildSessionFactory();
        }catch (Throwable throwable){
            System.err.println("Echec de création de la sessionFactory");
            throw new ExceptionInInitializerError(throwable);
        }
    }
    public static SessionFactory getSessionFactory(){
        return sessionFactory;
    }
}
