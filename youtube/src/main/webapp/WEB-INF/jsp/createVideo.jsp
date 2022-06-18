<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Insert title here</title>
</head>
<body>
Poruka:${poruka}

<%--@elvariable id="videoDto" type=""--%>
<form:form method="post" action="/createVideo"
           modelAttribute="videoDto">
    <table>
        <tr>
            <td><form:label path="naslov">naslov</form:label></td>
            <td><form:input path="naslov" /></td>
        </tr>

        <tr>
            <td><form:label path="opis">opis</form:label></td>
            <td><form:input path="opis" /></td>
        </tr>

        <tr>
            <td><form:label path="link">link</form:label></td>
            <td><form:input path="link" /></td>
        </tr>

        <tr>
            <td><form:label path="uzrast">uzrast</form:label></td>
            <td><form:input path="uzrast" /></td>
        </tr>
        <tr>
            <td><input type="submit" value="Submit" /></td>
        </tr>
    </table>


</form:form>

</body>
</html>