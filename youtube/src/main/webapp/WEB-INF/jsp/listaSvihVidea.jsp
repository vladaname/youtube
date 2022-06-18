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
        <td>pregledaj video</td>


    </tr>
    <c:forEach var="video" items="${listaSvihVidea}">
        <tr>
            <td>${video.naslov}</td>
            <td><iframe width="320" height="215"
                        src="${video.link}">
            </iframe></td>
            <td>${video.opis}</td>
            <td>
                <%--@elvariable id="videoIdDto" type=""--%>
                <form:form method="post" action="/lajkujVideo" modelAttribute="videoIdDto">
                    <input type="hidden" name="idVideo" value="${video.idVideo}">
                    <input type="hidden" name="vrednost" value=1>

                    <input type="submit" value="+">
                </form:form>
            </td>

            <td>${video.brLajkova}</td>
            <td>
                    <%--@elvariable id="videoIdDto" type=""--%>
                <form:form method="post" action="/lajkujVideo" modelAttribute="videoIdDto">
                    <input type="hidden" name="idVideo" value="${video.idVideo}">
                    <input type="hidden" name="vrednost" value=-1>

                    <input type="submit" value="-">
                </form:form>
            </td>

            <td>${video.brDislajkova}</td>

            <td>
            <%--@elvariable id="pregledajVideoDto" type=""--%>
            <form:form method="post" action="/pregledajVideo" modelAttribute="pregledajVideoDto">
            <input type="hidden" name="idVideo" value="${video.idVideo}">
            <input type="submit" value="pregledaj">
            </form:form>
            </td>

    </c:forEach>
</table>
</body>
</html>