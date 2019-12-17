<%-- 
    Document   : tabela_Subiecte
    Created on : Dec 31, 2018, 3:20:03 PM
    Author     : Andrei
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
        <title>Medici</title>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script>
            $(document).ready(function () {
                $("#stergeSubiect").hide();
                $("#modificaSubiect").hide();

                $("#update").click(function () {
                    $("#modificaSubiect").show();
                    $("#stergeSubiect").hide();
                });
                $("#delete").click(function () {
                    $("#stergeSubiect").show();
                    $("#modificaSubiect").hide();
                });
            });
        </script>

    </head>
    <body style="background-color: black; color: white" class="w3-container w3-center">
        <h1 class="w3-panel w3-topbar w3-bottombar w3-border-red w3-pale-red" align="center"> Tabela Subiecte:</h1> 
        <table class="w3-table-all" border="1" align="center">
            <tr class="w3-light-grey w3-hover-red">
                <td> <b>IdSubiect:</b></td>
                <td><b>Tip subiect:</b></td>
                <td><b>Numar intrebari:</b></td>
            </tr>
            <c:forEach var="subiecte" items="${listaSubiecte}">
                <tr class = "w3-hover-blue">
                    <td>${subiecte.getIdsubiecte()}</td>
                    <td>${subiecte.getTip()}</td>
                    <td>${subiecte.getNrIntrebari()}</td>
                 

                </tr>
            </c:forEach>
        </table>
        <form action="SubiecteController" method="POST">
            <p align="center">
                Modifica: <input type="checkbox" id="update"> Sterge: <input type="checkbox" id="delete" onclick="document.getElementById('tip').disabled = this.checked;
                        document.getElementById('nr_intrebari').disabled = this.checked;"><br><br>
                <select name="idsubiecte">
                    <c:forEach items="${listaSubiecte}" var="subiecte">
                        <option value="${subiecte.getIdsubiecte()}">${subiecte.getIdsubiecte()}</option>
                    </c:forEach>
                </select>
                <br><br>
                Modifica Tip: <input id="tip" type="text" name="tip"><br><br>
                Modifica Numar Intrebari: <input id="nr_intrebari" type="text" name="nr_intrebari"> <br><br>
                <button type="submit" id="modificaSubiect" name="modificaSubiect"> Modifica</button> <br> <br>
                <button type="submit" id="stergeSubiect" name="stergeSubiect"> Sterge </button>
            </p>
        </form>
        <p align="center">
            <a class="w3-button w3-border w3-hover-teal w3-button w3-round-xlarge" href="index.html"><b>Home</b></a>
        </p>
    </body>
</html>
