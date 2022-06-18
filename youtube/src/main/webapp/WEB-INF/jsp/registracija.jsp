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

<%--@elvariable id="akauntDto" type=""--%>
<form:form method="post" action="/createAkaunt"
           modelAttribute="akauntDto">
    <table>
        <tr>
            <td><form:label path="ime">ime</form:label></td>
            <td><form:input path="ime" /></td>
        </tr>

        <tr>
            <td><form:label path="prezime">prezime</form:label></td>
            <td><form:input path="prezime" /></td>
        </tr>

        <tr>
            <td><form:label path="nick">nick</form:label></td>
            <td><form:input path="nick" /></td>
        </tr>

        <tr>
            <td><form:label path="adresa">adresa</form:label></td>
            <td><form:input path="adresa" /></td>
        </tr>

        <tr>
            <td><form:label path="godine">godine</form:label></td>
            <td><form:input path="godine" /></td>
        </tr>

        <tr>
            <td><form:label path="username">username</form:label></td>
            <td><form:input path="username" /></td>
        </tr>
        <tr>
            <td><form:label path="pass">password</form:label></td>
            <td><form:input path="pass" /></td>
        </tr>
        <tr>
            <td><input type="submit" value="Submit" /></td>
        </tr>
    </table>


</form:form>

</body>
</html>