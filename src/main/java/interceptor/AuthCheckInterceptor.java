package interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;

public class AuthCheckInterceptor implements HandlerInterceptor{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		HttpSession session = request.getSession(false);		// session을 얻는다. session이 없는경우 null을 리턴한다.
		if(session != null ) {
			Object authInfo = session.getAttribute("authInfo");
			if(authInfo != null) {
				return true;
			}
		}
		
		response.sendRedirect(request.getContextPath()+"/login");
		return false;
		
	}
}
