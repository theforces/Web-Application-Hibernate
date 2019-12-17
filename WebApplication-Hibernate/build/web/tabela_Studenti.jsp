<%-- 
    Document   : tabela_Studenti
    Created on : Dec 31, 2018, 3:13:08 PM
    Author     : Andrei
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
        <title>Studenti</title>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script>
            $(document).ready(function () {
                $("#stergeStudent").hide();
                $("#modificaStudent").hide();

                $("#update").click(function () {
                    $("#modificaStudent").show();
                    $("#stergeStudent").hide();
                });
                $("#delete").click(function () {
                    $("#stergeStudent").show();
                    $("#modificaStudent").hide();
                });
            });
        </script>

    </head>
    <body style="background-color: black; color: white" class="w3-container w3-center">
        <h1 class="w3-panel w3-topbar w3-bottombar w3-border-red w3-pale-red" align="center"> Tabela Studenti:</h1> 
        <table border="1" align="center">
            <tr>
                <td><b>IdStudent:</b></td>
                <td><b>Nume:</b></td>
                <td><b>Prenume:</b></td>
                <td><b>Grupa:</b></td>
            </tr>
            <c:forEach var="studenti" items="${listaStudenti}">
                <tr class = "w3-hover-blue">
                    <td>${studenti.getIdstudenti()}</td>
                    <td>${studenti.getNume()}</td>
                    <td>${studenti.getPrenume()}</td>
                    <td>${studenti.getGrupa()}</td>

                </tr>
            </c:forEach>
        </table>
        <form action="StudentiController" method="POST">
            <p align="center">
                Modifica: <input type="checkbox" id="update"> Sterge: <input type="checkbox" id="delete" onclick="document.getElementById('nume').disabled = this.checked;
                        document.getElementById('prenume').disabled = this.checked;
                        document.getElementById('grupa').disabled = this.checked;"><br><br>
                <select name="idstudenti">
                    <c:forEach items="${listaStudenti}" var="studenti">
                        <option value="${studenti.getIdstudenti()}">${studenti.getIdstudenti()}</option>
                    </c:forEach>
                </select>
                <br><br>
                Modifica Nume: <input id="nume" type="text" name="nume"><br><br>
                Modifica Prenume: <input id="prenume" type="text" name="prenume"> <br><br>
                Modifica Grupa: <input id="grupa" type="text" name="grupa"> <br><br>
                <button type="submit" id="modificaStudent" name="modificaStudent"> Modifica</button> <br> <br>
                <button type="submit" id="stergeStudent" name="stergeStudent"> Sterge </button>
            </p>
        </form>
        <p align="center">
            <a class="w3-button w3-border w3-hover-teal w3-button w3-round-xlarge" href="index.html"><b>Home</b></a>
        </p>
    </body>
</html>
