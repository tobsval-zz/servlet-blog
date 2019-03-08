import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.NoSuchAlgorithmException;


public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try (PrintWriter serverOut = response.getWriter()) {
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            DatabaseService dbService = new DatabaseService();

            String salt = dbService.retrieveEntry("SALT", "USERNAME", username);
            String hashedPass = CryptoService.generateDigest(salt, password);
            System.out.println(hashedPass + " - " + CryptoService.generateDigest(salt, password));

            if(CryptoService.isExpectedPass(salt, password, hashedPass)){
                serverOut.print("Welcome, " + username);
            } else {
                serverOut.print("Login failed");
            }

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

}
