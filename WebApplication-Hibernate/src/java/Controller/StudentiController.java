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
import pojo.Studenti;
import DAOImpl.StudentiDAOImpl;
/**
 *
 * @author Andrei
 */
public class StudentiController extends HttpServlet {

    Studenti student = new Studenti();
    StudentiDAOImpl studentDaoImpl = new StudentiDAOImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (request.getParameter("adaugaStudent") != null) {
            String nume = request.getParameter("nume");
            String prenume = request.getParameter("prenume");
            String grupa = request.getParameter("grupa");
            student.setNume(nume);
            student.setPrenume(prenume);
            student.setGrupa(grupa);
            studentDaoImpl.adaugaStudent(student);
            RequestDispatcher rd = request.getRequestDispatcher("adauga_Student.jsp");
            rd.forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (request.getParameter("afiseazaStudenti") != null) {
            List<Studenti> listaStudenti = new ArrayList();
            listaStudenti = studentDaoImpl.afiseazaStudenti();
            request.setAttribute("listaStudenti", listaStudenti);
            RequestDispatcher rd = request.getRequestDispatcher("tabela_Studenti.jsp");
            rd.forward(request, response);
        }

        if (request.getParameter("modificaStudent") != null) {
            int id1 = Integer.parseInt(request.getParameter("idstudenti"));
            String nume = request.getParameter("nume");
            String prenume = request.getParameter("prenume");
            String grupa = request.getParameter("grupa");
            studentDaoImpl.modificaStudent(id1, nume, prenume, grupa);
            RequestDispatcher rd = request.getRequestDispatcher("adauga_Student.jsp");
            rd.forward(request, response);

        }

        if (request.getParameter("stergeStudent") != null) {
            int id2 = Integer.parseInt(request.getParameter("idstudenti"));
            student.setIdstudenti(id2);
            studentDaoImpl.stergeStudent(student);
            RequestDispatcher rd = request.getRequestDispatcher("adauga_Student.jsp");
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
