<%-- 
    Document   : adauga_Disciplina
    Created on : Dec 31, 2018, 2:59:43 PM
    Author     : Andrei
--%>

<%@page import="DAOImpl.SubiecteDAOImpl"%>
<%@page import="DAOImpl.StudentiDAOImpl"%>
<%@page import="pojo.Subiecte"%>
<%@page import="java.util.ArrayList"%>
<%@page import="pojo.Studenti"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
        <title>Disciplina</title>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    </head>
    <body style="background-color: black; color: white" >
<%
        StudentiDAOImpl studentDaoImpl = new StudentiDAOImpl();
        SubiecteDAOImpl subiectDaoImpl = new SubiecteDAOImpl();
        List<Studenti> listaStudenti = new ArrayList();
        listaStudenti = studentDaoImpl.afiseazaStudenti();
        List<Subiecte> listaSubiecte = new ArrayList();
        listaSubiecte = subiectDaoImpl.afiseazaSubiecte();
        request.setAttribute("listaStudenti", listaStudenti);
        request.setAttribute("listaSubiecte", listaSubiecte);
%>
        <div id="add">
            <h1 class="w3-panel w3-border-left w3-pale-red w3-border-red"> Adauga o noua disciplina </h1>
            <form action="DisciplinaController" method="GET">
                <table>
                    <tr class="w3-panel w3-border w3-border-red w3-hover-border-green">
                        <td class="w3-panel w3-leftbar w3-border-blue w3-pale-blue"> Student: </td>
                        <td>
                            <select name="idstudenti">
                                <c:forEach items="${listaStudenti}" var="studenti">
                                    <option value="${studenti.getIdstudenti()}">${studenti.getIdstudenti()}, ${studenti.getNume()}, ${studenti.getPrenume()}, ${studenti.getGrupa()}</option>
                                </c:forEach>
                            </select>
                        </td>
                    </tr>
                    <tr class="w3-panel w3-border w3-border-red w3-hover-border-green">
                        <td class="w3-panel w3-leftbar w3-border-blue w3-pale-blue"> Medic: </td>
                        <td>
                            <select name="idsubiecte">
                                <c:forEach items="${listaSubiecte}" var="subiecte">
                                    <option value="${subiecte.getIdsubiecte()}">${subiecte.getIdsubiecte()}, ${subiecte.getTip()}, ${subiecte.getNrIntrebari()}</option>
                                </c:forEach>
                            </select>
                        </td>
                    </tr>
                    <tr class="w3-panel w3-border w3-border-red w3-hover-border-green">
                        <td class="w3-panel w3-leftbar w3-border-blue w3-pale-blue"> Data Examen: </td>
                        <td><input type="text" name="dataExamen"></td>
                    </tr>
                    <tr class="w3-panel w3-border w3-border-red w3-hover-border-green">
                        <td class="w3-panel w3-leftbar w3-border-blue w3-pale-blue"> Puncte Credit: </td>
                        <td><input type="text" name="puncteCredit"></td>
                    </tr>
                    <tr>
                        <td><input type="submit" name="adaugaDisciplina" value="Adauga"></td>

                    </tr>
                </table>
            </form>
        </div>

        <form action="DisciplinaController" method="POST">
            <input type="submit" name="afiseazaDisciplina" value="Afiseaza"> &nbsp; &nbsp;<br>
        </form>
        <br>
        <a class="w3-button w3-border w3-hover-teal w3-button w3-round-xlarge" href="index.html"><b>Home</b></a>
    </body>
</html>
