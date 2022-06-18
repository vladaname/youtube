<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<!DOCTYPE html>
<html>
<head>

</head>
<body>
<h3 align="center">VIDEO</h3>

${poruka}
<table class="table table-striped">
    <tr>
        <td>naslov</td>
        <td>link</td>
        <td>opis</td>
        <td>komentar</td>
    </tr>
    <tr>
        <td>${video.naslov}</td>
        <td>
            <iframe width="420" height="315"
            src="${video.link}">
            </iframe>
        </td>
        <td>${video.opis}</td>

        <td>
            <%--@elvariable id="komentarDto" type=""--%>
            <form:form method="post" action="/createKomentar" modelAttribute="komentarDto">
                <input type="text" name="sadrzaj">

                <input type="hidden" name="idVideo" value="${video.idVideo}">
                <input type="submit" value="komentar">
            </form:form>
        </td>

</table>

/////////
<table class="table table-striped">
    <tr>
        <td>komentar</td>
        <td>pozitivno</td>
        <td>brLajkova</td>
        <td>negativno</td>
        <td>brDislajkova</td>

    </tr>
    <c:forEach var="lista" items="${listaKomentara}">
        <tr>
            <td>${lista.sadrzaj}</td>
            <td>
                <%--@elvariable id="komentarDto" type=""--%>
                <form:form method="post" action="/lajkuj" modelAttribute="lajkovanjeDto">
                    <input type="hidden" name="idKomentar" value="${lista.idKomentar}">
                    <input type="hidden" name="idVideo" value="${video.idVideo}">
                    <input type="hidden" name="vrednost" value=1>

                    <input type="submit" value="+">
                </form:form>
            </td>

            <td>${lista.brLajkova}</td>
            <td>
                    <%--@elvariable id="lajkovanjeDto" type=""--%>
                <form:form method="post" action="/lajkuj" modelAttribute="lajkovanjeDto">
                    <input type="hidden" name="idKomentar" value="${lista.idKomentar}">
                    <input type="hidden" name="idVideo" value="${video.idVideo}">
                    <input type="hidden" name="vrednost" value=-1>

                    <input type="submit" value="-">
                </form:form>
            </td>

            <td>${lista.brDislajkova}</td>


        </tr>
    </c:forEach>
</table>

///////////

</body>
</html>