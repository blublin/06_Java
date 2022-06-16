package com.ben.dojosAndNinjas.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.ben.dojosAndNinjas.models.Dojo;
import com.ben.dojosAndNinjas.services.DojoServ;
import com.ben.dojosAndNinjas.services.NinjaServ;

@Controller
public class DojoController {
	
	@Autowired
	private DojoServ dServ;
	@Autowired
	private NinjaServ nServ;
	
	@GetMapping("dojos/new")
	public String createDojo(@ModelAttribute Dojo dojo) {
		return "newDojo.jsp";
	}
	
	@GetMapping("/dojos/{id}")
	public String viewDojo(@PathVariable String id, Model model)  {
		Long nId;
		try{
            nId = Long.parseLong(id);
        }
        catch (NumberFormatException ex){
            ex.printStackTrace();
            return "redirect:/dojos/new";
        }
		Dojo d = dServ.readOne(nId);
		model.addAttribute("dojo", d );
		return "viewDojo.jsp";
		
	}
	
	@PostMapping("/dojos/processForm")
	public String processForm(@Valid @ModelAttribute Dojo dojo,
			BindingResult res) {
		System.out.println("Hello");
		if (res.hasErrors()) {
			return "newDojo.jsp";
		}
		else {
			dServ.create(dojo);
			Long id = dojo.getId();
			return "redirect:/dojos/" + id;
		}
	}
}
