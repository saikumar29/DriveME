package driveme.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestMapping;

public class logout {

	@RequestMapping("/logout")
	public String logout(HttpServletRequest request, HttpSession session, HttpServletResponse response) {
		String ret = "";
		if (session.getAttribute("User") != null) {
			session = null;
			ret = "login";
		}
		
		return ret;

	}
}
