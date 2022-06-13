package com.ben.springCounter.counterController;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class indexController {

	@RequestMapping("/")
	public String indexRoute(HttpSession session) {
		if (session.getAttribute("count") == null) {
			session.setAttribute("count", 0);
		}
		else {
			Integer c = (Integer) session.getAttribute("count");
			session.setAttribute("count", c + 1);
		}
		
		return "<h1 style='margin: 30px 0; text-align: center;'>Welcome User!</h1>";
	}
	
	@RequestMapping("/double")
	public String doubleRoute(HttpSession session) {
		if (session.getAttribute("count") == null) {
			session.setAttribute("count", 0);
		}
		else {
			Integer c = (Integer) session.getAttribute("count");
			session.setAttribute("count", c + 2);
		}
		return "<h1 style='margin: 30px 0; text-align: center;'>You found the bonus double page!</h1>";
	}
}
