package com.ben.springCounter.counterController;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CounterController {
	
	@RequestMapping("/counter")
	 public String counter() {
		return "counter.jsp";
	}
	
}
