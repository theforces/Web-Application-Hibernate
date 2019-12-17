<%-- 
    Document   : adauga_Student
    Created on : Dec 31, 2018, 2:52:43 PM
    Author     : Andrei
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
        <title>Studenti</title>
    </head>
    <body style="background-color: black; color: white">

        <div id="add">
            <h1 class="w3-panel w3-border-left w3-pale-red w3-border-red"> Adauga student </h1>
            <form action="StudentiController" method="GET">
                <table>
                    <tr class="w3-panel w3-border w3-border-red w3-hover-border-green">
                        <td class="w3-panel w3-leftbar w3-border-blue w3-pale-blue"> Nume Student: </td>
                        <td><input type="text" name="nume"></td>
                    </tr>
                    <tr class="w3-panel w3-border w3-border-red w3-hover-border-green">
                        <td class="w3-panel w3-leftbar w3-border-blue w3-pale-blue"> Prenume Student: </td>
                        <td><input type="text" name="prenume"></td>
                    </tr>
                    <tr class="w3-panel w3-border w3-border-red w3-hover-border-green">
                        <td class="w3-panel w3-leftbar w3-border-blue w3-pale-blue"> Grupa Student: </td>
                        <td><input type="text" name="grupa"></td>
                    </tr>
                    <tr>
                        <td><input type="submit" name="adaugaStudent" value="Adauga"></td>

                    </tr>
                </table>
            </form>
        </div>

        <form action="StudentiController" method="POST">
            <input type="submit" name="afiseazaStudenti" value="Afiseaza"> &nbsp; &nbsp;<br>
        </form>
        <br>
        <a class="w3-button w3-border w3-hover-teal w3-button w3-round-xlarge" href="index.html"><b>Home</b></a>
    </body>
</html>
