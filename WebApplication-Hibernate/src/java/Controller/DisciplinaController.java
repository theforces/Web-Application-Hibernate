/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;
import java.util.*;
import pojo.*;
import DAOImpl.HibernateUtil;
import DAOImpl.DisciplinaDAOImpl;
import java.text.*;
import org.hibernate.*;
/**
 *
 * @author Andrei
 */
public class DisciplinaController extends HttpServlet {

    Disciplina disciplina = new Disciplina();
    DisciplinaDAOImpl disciplinaDaoImpl = new DisciplinaDAOImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (request.getParameter("adaugaDisciplina") != null) {
            // preluarea parametrilor de interes
            Integer idstudenti = java.lang.Integer.parseInt(request.getParameter("studenti_idstudenti"));
            Integer idsubiecte = java.lang.Integer.parseInt(request.getParameter("subiecte_idsubiecte"));
            System.out.println(idstudenti+" "+idsubiecte);
            Session session = HibernateUtil.getSessionFactory().openSession();
            Studenti student = (Studenti) session.get(Studenti.class, idstudenti);
            Subiecte subiect = (Subiecte) session.get(Subiecte.class, idsubiecte);
            
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            Date dataExamen = null;
            try {
                dataExamen = df.parse(request.getParameter("dataExamen"));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            Integer puncteCredit = java.lang.Integer.parseInt(request.getParameter("puncteCredit"));
           

            disciplina.setStudentiByStudentiIdstudenti(student);
            disciplina.setSubiecte(subiect);
            disciplina.setDataExamen(dataExamen);
            disciplina.setPuncteCredit(puncteCredit);
            

            disciplinaDaoImpl.adaugaDisciplina(disciplina);
            RequestDispatcher rd = request.getRequestDispatcher("adauga_Disciplina.jsp");
            rd.forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (request.getParameter("afiseazaDisciplina") != null) {
            List<Disciplina> listaDisciplina = new ArrayList();
            listaDisciplina = disciplinaDaoImpl.afiseazaDisciplina();
            request.setAttribute("listaDisciplina", listaDisciplina);
            RequestDispatcher rd = request.getRequestDispatcher("tabela_Discipline.jsp");
            rd.forward(request, response);
        }

        if (request.getParameter("modificaDisciplina") != null) {
            Integer id1 = java.lang.Integer.parseInt(request.getParameter("idDisciplina"));
            // preluarea parametrilor de interes
            Integer idstudenti = java.lang.Integer.parseInt(request.getParameter("studenti_idstudenti"));
            Integer idsubiecte = java.lang.Integer.parseInt(request.getParameter("subiecte_idsubiecte"));
            Session session = HibernateUtil.getSessionFactory().openSession();
            Studenti student = (Studenti) session.get(Studenti.class, idstudenti);
            Subiecte subiect = (Subiecte) session.get(Subiecte.class, idsubiecte);

            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            Date dataExamen = null;
            try {
                dataExamen = df.parse(request.getParameter("dataExamen"));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            Integer puncteCredit = java.lang.Integer.parseInt(request.getParameter("puncteCredit"));
            

            disciplinaDaoImpl.modificaDisciplina(id1, student, subiect, dataExamen, puncteCredit);
            RequestDispatcher rd = request.getRequestDispatcher("adauga_Disciplina.jsp");
            rd.forward(request, response);

        }

        if (request.getParameter("stergeDisciplina") != null) {
            Integer id2 = Integer.parseInt(request.getParameter("idDisciplina"));
            disciplina.setIdDisciplina(id2);
            disciplinaDaoImpl.stergeDisciplina(disciplina);
            RequestDispatcher rd = request.getRequestDispatcher("adauga_Disciplina.jsp");
            rd.forward(request, response);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
