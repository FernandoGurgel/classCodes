package com.edu.web_maven_jsf_hibernate.dao;

import com.edu.web_maven_jsf_hibernate.model.Livro;
import com.edu.web_maven_jsf_hibernate.utils.HibernateUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class LivroDao {

    public void save(Livro livro) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.save(livro);
        t.commit();
    }

    public Livro getLivro(long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        return (Livro) session.load(Livro.class, id);
    }

    public List<Livro> list() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        List lista = session.createQuery("from Livro").list();
        t.commit();
        return lista;
    }

    public void remove(Livro livro) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.delete(livro);
        t.commit();
    }

    public void update(Livro livro) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.update(livro);
        t.commit();
    }


    
}
