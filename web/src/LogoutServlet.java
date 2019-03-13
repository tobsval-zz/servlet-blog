import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;


public class LogoutServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try (PrintWriter serverOut = response.getWriter()) {
            HttpSession userSession = request.getSession();
            userSession.invalidate();
            response.setHeader("Refresh", "1;url=/index.jsp");
        }
    }

}
