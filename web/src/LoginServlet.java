import services.CryptoService;
import services.DatabaseService;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.NoSuchAlgorithmException;


public class LoginServlet extends HttpServlet {

    private DatabaseService dbService = new DatabaseService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try (PrintWriter serverOut = response.getWriter()) {

            String username = request.getParameter("username");
            String password = request.getParameter("password");

            if(!(username == null || "".equals(username) || password == null || "".equals(password))){

                String salt = dbService.retrieveEntry("SALT", "USERS",
                                                  "USERNAME", username);
                String hashedPass = CryptoService.generateDigest(salt, password);

                if(CryptoService.isExpectedPass(salt, password, hashedPass)){
                    serverOut.print("Welcome, " + username + ". Redirecting you to the homepage.");

                    HttpSession newSession = request.getSession(true); //Start a new session (flag to true)
                    newSession.setAttribute("username", username);

                    response.setHeader("Refresh", "3;url=/index.jsp");
                } else {
                    serverOut.print("Login failed. Wrong password.");
                    response.setHeader("Refresh", "3;url=/login.html");
                }
            } else {
                serverOut.print("Login failed. Invalid credentials format.");
                response.setHeader("Refresh", "3;url=/login.html");
            }

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

}
