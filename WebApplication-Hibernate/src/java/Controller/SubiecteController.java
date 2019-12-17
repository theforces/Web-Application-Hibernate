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
import DAO.SubiecteDAO;
import pojo.Subiecte;
import DAOImpl.SubiecteDAOImpl;
/**
 *
 * @author Andrei
 */
public class SubiecteController extends HttpServlet {

    Subiecte subiect = new Subiecte();
    SubiecteDAOImpl subiectDaoImpl = new SubiecteDAOImpl();
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (request.getParameter("adaugaSubiect") != null) {
            String tip = request.getParameter("tip");
            String nr_intrebari = request.getParameter("nr_intrebari");
            subiect.setTip(tip);
            subiect.setNrIntrebari(nr_intrebari);
            subiectDaoImpl.adaugaSubiect(subiect);
            RequestDispatcher rd = request.getRequestDispatcher("adauga_Subiect.jsp");
            rd.forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (request.getParameter("afiseazaSubiecte") != null) {
            List<Subiecte> listaSubiecte = new ArrayList();
            listaSubiecte = subiectDaoImpl.afiseazaSubiecte();
            request.setAttribute("listaSubiecte", listaSubiecte);
            RequestDispatcher rd = request.getRequestDispatcher("tabela_Subiecte.jsp");
            rd.forward(request, response);
        }

        if (request.getParameter("modificaSubiect") != null) {
            int id1 = Integer.parseInt(request.getParameter("idsubiecte"));
            String tip = request.getParameter("tip");
            String nr_intrebari = request.getParameter("nr_intrebari");
            subiectDaoImpl.modificaSubiect(id1, tip, nr_intrebari);
            RequestDispatcher rd = request.getRequestDispatcher("adauga_Subiect.jsp");
            rd.forward(request, response);

        }

        if (request.getParameter("stergeSubiect") != null) {
            int id2 = Integer.parseInt(request.getParameter("idsubiecte"));
            subiect.setIdsubiecte(id2);
            subiectDaoImpl.stergeSubiect(subiect);
            RequestDispatcher rd = request.getRequestDispatcher("adauga_Subiect.jsp");
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
