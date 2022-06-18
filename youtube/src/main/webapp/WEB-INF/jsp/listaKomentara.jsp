<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<!DOCTYPE html>
<html>
<head>

</head>
<body>
<h3 align="center">Komentari</h3>

${poruka}


/////////
<table class="table table-striped">
    <tr>
        <td>komentar</td>

    </tr>
    <c:forEach var="lista" items="${listaKomentara}">
        <tr>
            <td>${lista.sadrzaj}</td>

        </tr>
    </c:forEach>
</table>

///////////

</body>
</html>