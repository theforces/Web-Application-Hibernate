/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOImpl;
import java.util.*;
import javax.persistence.*;
import org.hibernate.*;
import pojo.Studenti;
import DAO.StudentiDAO;
/**
 *
 * @author Andrei
 */
public class StudentiDAOImpl {
    public void adaugaStudent(Studenti student) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(student);
        transaction.commit();
        session.close();
    }

    public List<Studenti> afiseazaStudenti() {
        List<Studenti> listaStudenti = new ArrayList();
        Session session = HibernateUtil.getSessionFactory().openSession();
        org.hibernate.Query query = session.createQuery("From Studenti");
        listaStudenti = query.list();
        return listaStudenti;
    }

    public void modificaStudent(int idstudenti, String nume, String prenume, String grupa) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Studenti detaliistudenti = (Studenti) session.load(Studenti.class, idstudenti);
        detaliistudenti.setNume(nume);
        detaliistudenti.setPrenume(prenume);
        detaliistudenti.setGrupa(grupa);
        session.update(detaliistudenti);
        transaction.commit();
        session.close();
    }

    public void stergeStudent(Studenti student) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(student);
        transaction.commit();
        session.close();
    }

}
