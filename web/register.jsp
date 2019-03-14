<%--
  Created by IntelliJ IDEA.
  User: Tobia
  Date: 14/03/2019
  Time: 21:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>Tob Log - Register</title>
    </head>
    <body>
    <form id="registration-form" method="post" action="${pageContext.request.contextPath}/RegistrationServlet">
        <p><label>
            Username (Max. 30 Characters): <input name="username" type="text">
        </label></p>
        <p><label>
            Password (8 to 30 Characters): <input name="password" type="password">
        </label></p>
        <p><label>
            Repeat Password: <input name="password-rpt" type="password">
        </label></p>
        <button type="submit">Register</button>
    </form>
    </body>
</html>
