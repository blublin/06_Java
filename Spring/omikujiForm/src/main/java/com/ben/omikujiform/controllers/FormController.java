package com.ben.omikujiform.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FormController {

	@GetMapping("/")
	public String homeForm() {
		return "form.jsp";
	}
	
	@PostMapping("/processForm")
	public String formProcess(@RequestParam("selNum") int selNum,
							  @RequestParam("city") String city,
							  @RequestParam("person") String person,
							  @RequestParam("endeavor") String endeavor,
							  @RequestParam("livingThing") String livingThing,
							  @RequestParam("nice") String nice,
							  HttpSession seshRogen) {
		seshRogen.setAttribute("selNum", selNum);
		seshRogen.setAttribute("city", city);
		seshRogen.setAttribute("person", person);
		seshRogen.setAttribute("endeavor", endeavor);
		seshRogen.setAttribute("livingThing", livingThing);
		seshRogen.setAttribute("nice", nice);
		return "redirect:/showForm";
	}
	
	@GetMapping("/showForm")
	public String showForm(HttpSession seshRogen) {
		if (seshRogen.getAttribute("nice") == null) {
			return "redirect:/";
		}
		else {
			return "showForm.jsp";
		}
	}
}
