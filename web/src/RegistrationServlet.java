import services.DatabaseService;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


public class RegistrationServlet extends HttpServlet {

    private DatabaseService dbService = new DatabaseService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try (PrintWriter serverOut = response.getWriter()) {

            String username = request.getParameter("username");
            String password = request.getParameter("password");
            String repeatedPass = request.getParameter("password-rpt");

            System.out.println(dbService.userExists(username));

            if(password.equals(repeatedPass) && !(dbService.userExists(username))) {
                serverOut.print("Valid username and passwords!");
            } else {
                serverOut.print("Username already exists");
            }
        }
    }

}
