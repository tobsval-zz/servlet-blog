import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

class SessionService {

    HttpSession createNewSession(HttpServletRequest request){
        return request.getSession(true);
    }

    HttpSession getExistingSession(HttpServletRequest request){
        return request.getSession();
    }
}
