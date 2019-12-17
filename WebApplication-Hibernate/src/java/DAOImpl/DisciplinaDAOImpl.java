/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOImpl;
import java.util.*;
import javax.persistence.*;
import org.hibernate.*;
import pojo.*;
import DAO.DisciplinaDAO;
/**
 *
 * @author Andrei
 */
public class DisciplinaDAOImpl {
    public void adaugaDisciplina(Disciplina disciplina) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(disciplina);
        transaction.commit();
        session.close();
    }

    public List<Disciplina> afiseazaDisciplina() {
        List<Disciplina> listaDisciplina = new ArrayList();
        Session session = HibernateUtil.getSessionFactory().openSession();
        org.hibernate.Query query = session.createQuery("From Disciplina");
        listaDisciplina = query.list();
        return listaDisciplina;
    }
    public void modificaDisciplina(Integer idDisciplina, Studenti student, Subiecte subiect, Date dataExamen, Integer puncteCredit) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Disciplina detaliidisciplina;
        detaliidisciplina = (Disciplina) session.load(Disciplina.class, idDisciplina);
        detaliidisciplina.setStudentiByIdstudenti(student);
        detaliidisciplina.setSubiecte(subiect);
        detaliidisciplina.setDataExamen(dataExamen);
        detaliidisciplina.setPuncteCredit(puncteCredit);
        session.update(detaliidisciplina);
        transaction.commit();
        session.close();
    }

    public void stergeDisciplina(Disciplina disciplina) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(disciplina);
        transaction.commit();
        session.close();
    }

}
