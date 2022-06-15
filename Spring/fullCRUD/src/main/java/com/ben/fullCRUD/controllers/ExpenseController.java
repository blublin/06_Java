package com.ben.fullCRUD.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.ben.fullCRUD.models.Expense;
import com.ben.fullCRUD.services.ExpenseService;

@Controller
public class ExpenseController {
	
	@Autowired
	private ExpenseService expServ;

//	|--- INDEX ---|
	@GetMapping("/")
	public String index(@ModelAttribute("expense") Expense exp,
						Model model) {
		List<Expense> expenses = expServ.readAll();
		model.addAttribute("expenses", expenses);
		return "index.jsp";
	}
	
//	|--- CREATE ROUTE HANDLER ---|
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
	
	@GetMapping("/expenses/{id}")
	public String oneExpense(@PathVariable Long id, Model model) {
		Expense exp = expServ.readOne(id);
		if (exp != null) {
			model.addAttribute("exp", exp);
			return "oneExpense.jsp";
		}
		else {
			return "redirect:/";
		}
	}
	
//	|--- EDIT 1 ---|
	@GetMapping("/expenses/{id}/edit")
	public String edit(@PathVariable Long id, Model model) {
		Expense exp = expServ.readOne(id);
		if (exp != null) {
			model.addAttribute("expense", exp);
			return "edit.jsp";
		}
		else {
			return "redirect:/";
		}
	}
	
//	|--- UPDATE ROUTE HANDLER ---|
    @PutMapping("/expenses/{id}")
    public String update(@Valid @ModelAttribute("expense") Expense exp, BindingResult result) {
        if (result.hasErrors()) {
            return "/books/edit.jsp";
        } else {
            expServ.updateOne(exp);
            return "redirect:/";
        }
    }
//  |--- DELETE ROUTE HANDLER ---|
	@DeleteMapping("/expenses/{id}")
	public String destroy(@PathVariable Long id) {
	    expServ.deleteOne(id);
	    return "redirect:/";
	}
}
