package com.ben.springCounter.counterController;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CounterController {
	
	@RequestMapping("/counter")
	 public String counter() {
		return "counter.jsp";
	}
	
	@RequestMapping(value="/reset", method=RequestMethod.GET)
	public String reset(HttpSession session) {
		session.setAttribute("count", 0);
		return "redirect:/counter";
	}
}
