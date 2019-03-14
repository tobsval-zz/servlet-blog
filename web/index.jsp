<%--
  Created by IntelliJ IDEA.
  User: Toby
  Date: 22/02/2019
  Time: 19:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%String username = String.valueOf(session.getAttribute("username")); %>
<html>
    <head>
        <title>Tob Log</title>
        <meta charset = "UTF-8">
        <meta name="viewport" content="width=device-width">
    </head>
    <body>
    <div id="home-title">
        <h1>Tob Log - Tech Articles, Memes & More!</h1>
    </div>
    <hr>
    <marquee id="announcements">Welcome to the blog!</marquee>
    <hr>
    <p><%if (!username.equals("null")) {out.print("Welcome " + username + "!");}%></p>
    <%if (username.equals("null")) { //User is not logged in:
        out.print("<table>\n" +
            "           <td>\n" +
            "               <tr><a href=\"login.html\">Login</a></tr>\n" +
            "           </td>\n" +
            "           <td>\n" +
            "               <tr><a href=\"register.jsp\">Register</a></tr>\n" +
            "           </td>\n" +
            "      </table>");
    } else { //User is logged in:
        out.print("<form method=\"post\" action=\"LogoutServlet\">\n" +
                  "    <button value=\"logout\" type=\"submit\">Logout</button>\n" +
                  "</form>");
    }%>
    <hr>
    <!-- TODO Add Posts Below -->
    </body>
    <link rel="stylesheet" href="css/index.css">
</html>
