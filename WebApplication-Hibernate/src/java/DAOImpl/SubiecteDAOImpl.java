/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOImpl;
import java.util.*;
import javax.persistence.*;
import org.hibernate.*;
import pojo.Subiecte;
import DAO.SubiecteDAO;
/**
 *
 * @author Andrei
 */
public class SubiecteDAOImpl {
        public void adaugaSubiect(Subiecte subiect) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(subiect);
        transaction.commit();
        session.close();
    }

    public List<Subiecte> afiseazaSubiecte() {
        List<Subiecte> listaSubiecte = new ArrayList();
        Session session = HibernateUtil.getSessionFactory().openSession();
        org.hibernate.Query query = session.createQuery("From Subiecte");
        listaSubiecte = query.list();
        return listaSubiecte;
    }

    public void modificaSubiect(int idsubiecte, String tip, String nr_intrebari) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Subiecte detaliisubiecte = (Subiecte) session.load(Subiecte.class, idsubiecte);
        detaliisubiecte.setTip(tip);
        detaliisubiecte.setNrIntrebari(nr_intrebari);
        session.update(detaliisubiecte);
        transaction.commit();
        session.close();
    }

    public void stergeSubiect(Subiecte subiect) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(subiect);
        transaction.commit();
        session.close();
    }

}
