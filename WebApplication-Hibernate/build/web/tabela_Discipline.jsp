<%-- 
    Document   : tabela_Discipline
    Created on : Dec 31, 2018, 3:28:37 PM
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
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script>
            $(document).ready(function () {
                $("#stergeDisciplina").hide();
                $("#modificaDisciplina").hide();

                $("#update").click(function () {
                    $("#modificaDisciplina").show();
                    $("#stergeDisciplina").hide();
                });
                $("#delete").click(function () {
                    $("#stergeDisciplina").show();
                    $("#modificaDisciplina").hide();
                });
            });
        </script>

    </head>
    <body style="background-color: black; color: white" class="w3-container w3-center">
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
        <h1 class="w3-panel w3-topbar w3-bottombar w3-border-red w3-pale-red" align="center"> Tabela Discipline:</h1> 
        <table class="w3-table-all" border="1" align="center">
            <tr class="w3-light-grey w3-hover-red">
                <td><b>Id Disciplina:</b></td>
                <td><b>Id Student:</b></td>
                <td><b>Nume Student:</b></td>
                <td><b>Prenume Student:</b></td>
                <td><b>Grupa Student:</b></td>
                <td><b>Id Subiect:</b></td>
                <td><b>Tip Subiect:</b></td>
                <td><b>Numar intrebari:</b></td>
                <td><b>Data Examen:</b></td>
                <td><b>Puncte Credit:</b></td>
            </tr>
            <c:forEach var="disciplina" items="${listaDisciplina}">
                <tr class = "w3-hover-blue">
                    <td>${disciplina.getIdDisciplina()}</td>
                    <td>${disciplina.getStudentiByStudentiIdstudenti().getIdstudenti()}</td>
                    <td>${disciplina.getStudentiByStudentiIdstudenti().getNume()}</td>
                    <td>${disciplina.getStudentiByStudentiIdstudenti().getPrenume()}</td>
                    <td>${disciplina.getStudentiByStudentiIdstudenti().getGrupa()}</td>
                    <td>${disciplina.getSubiecte().getIdsubiecte()}</td>
                    <td>${disciplina.getSubiecte().getTip()}</td>
                    <td>${disciplina.getSubiecte().getNrIntrebari()}</td>
                    <td>${disciplina.getDataExamen()}</td>
                    <td>${disciplina.getPuncteCredit()}</td>
                </tr>
            </c:forEach>
        </table>
        <form action="DisciplinaController" method="POST">
            <p align="center">
                Modifica: <input type="checkbox" id="update"> Sterge: <input type="checkbox" id="delete" onclick="document.getElementById('studenti_idstudenti').disabled = this.checked;
                        document.getElementById('subiecte_idsubiecte').disabled = this.checked;
                        document.getElementById('dataExamen').disabled = this.checked;
                        document.getElementById('puncteCredit').disabled = this.checked;"><br><br>
                idDisciplina:
                <select name="idDisciplina:">
                    <c:forEach items="${listaDisciplina}" var="disciplina">
                        <option value="${disciplina.getIdDisciplina()}">${disciplina.getIdDisciplina()}</option>
                    </c:forEach>
                </select>
                <br><br>
                idStudent:
                <select name="idstudenti">
                    <c:forEach items="${listaStudenti}" var="studenti">
                        <option value="${studenti.getIdstudenti()}">${studenti.getIdstudenti()}, ${studenti.getNume()}, ${studenti.getPrenume()}, ${studenti.getGrupa()}</option>
                    </c:forEach>
                </select>
                <br><br>
                idSubiect:
                <select name="idsubiecte">
                    <c:forEach items="${listaSubiecte}" var="subiecte">
                        <option value="${subiecte.getIdsubiecte()}">${subiecte.getIdsubiecte()}, ${subiecte.getTip()}, ${subiecte.getNrIntrebari()}</option>
                    </c:forEach>
                </select>
                <br><br>
                Modifica data examenului: <input id="dataExamen" type="text" name="dataExamen"><br><br>
                Modifica punctele credit: <input id="puncteCredit" type="text" name="puncteCredit"> <br><br>
                <button type="submit" id="modificaDisciplina" name="modificaDisciplina"> Modifica</button> <br> <br>
                <button type="submit" id="stergeDisciplina" name="stergeDisciplina"> Sterge </button>
            </p>
        </form>
        <br>
        <p align="center">
            <a class="w3-button w3-border w3-hover-teal w3-button w3-round-xlarge" href="index.html"><b>Home</b></a>
        </p>
    </body>
</html>
