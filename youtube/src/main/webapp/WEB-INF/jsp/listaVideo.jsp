<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<!DOCTYPE html>
<html>
<head>

</head>
<body>
${poruka}
<!-- Second navbar for search -->

<h3 align="center">VIDEO</h3>


<table class="table table-striped">
    <tr>
        <td>naslov</td>
        <td>link</td>
        <td>opis</td>
        <td>pozitivno</td>
        <td>brLajkova</td>
        <td>negativno</td>
        <td>brDislajkova</td>
        <td>brisanje</td>

    </tr>
    <c:forEach var="video" items="${listaVideo}">
        <tr>
            <td>${video.naslov}</td>
            <td>${video.link}</td>
            <td>${video.opis}</td>
            <td>${video.brLajkova}</td>
            <td>${video.brDislajkova}</td>
            <td>
            <%--@elvariable id="obrisiVideoDto" type=""--%>
            <form:form method="post" action="/obrisiVideo" modelAttribute="obrisiVideoDto">
                <input type="hidden" name="idVideo" value="${listaOglasa.idVideo}">
                <input type="submit" value="obrisi">
            </form:form>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>