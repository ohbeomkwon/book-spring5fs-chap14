package controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LogoutController {

	@RequestMapping("/logout")
	public String logout(HttpSession session) {
			session.invalidate();	// 세션의 정보를 무효화 한다.
			return "redirect:/main";
	}
}
