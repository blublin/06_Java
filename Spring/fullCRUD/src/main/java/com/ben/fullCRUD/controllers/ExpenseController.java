package com.ben.fullCRUD.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.ben.fullCRUD.models.Expense;
import com.ben.fullCRUD.services.ExpenseService;

@Controller
public class ExpenseController {
	
	@Autowired
	private ExpenseService expServ;

	@GetMapping("/")
	public String index(@ModelAttribute("expense") Expense exp,
						Model model) {
		List<Expense> expenses = expServ.readAll();
		model.addAttribute("expenses", expenses);
		return "index.jsp";
	}
	
	@PostMapping("/")
	public String handleForm(@Valid @ModelAttribute("expense") Expense exp,
			BindingResult result) {
		System.out.println("****" + result);
		if (result.hasErrors()) {
			return "index.jsp";
		}
		else {
			expServ.create(exp);
			return "redirect:/";
		}
	}
}
