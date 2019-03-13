import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class LogoutServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        HttpSession userSession = request.getSession();
        userSession.invalidate();
        response.setHeader("Refresh", "0;url=/index.jsp"); //Redirect to home
    }

}
