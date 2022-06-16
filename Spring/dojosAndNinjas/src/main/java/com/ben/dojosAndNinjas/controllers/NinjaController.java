package com.ben.dojosAndNinjas.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.ben.dojosAndNinjas.models.Dojo;
import com.ben.dojosAndNinjas.models.Ninja;
import com.ben.dojosAndNinjas.services.DojoServ;
import com.ben.dojosAndNinjas.services.NinjaServ;


@Controller
public class NinjaController {
	
	@Autowired
	private NinjaServ nServ;
	@Autowired
	private DojoServ dServ;
	
	@GetMapping("/")
	public String index() {
		return "redirect:/ninjas/new";
	}

	@GetMapping("/ninjas/new")
	public String createNinja(@ModelAttribute("ninja") Ninja ninja,
							  Model model) {
		List<Dojo> dojos = dServ.getAll();
		model.addAttribute("dojos", dojos);
		return "newNinja.jsp";
	}
	
	@PostMapping("/ninjas/processForm")
	public String processForm(@Valid @ModelAttribute("ninja") Ninja ninja,
			BindingResult res, Model model) {
		if (res.hasErrors()) {
			List<Dojo> dojos = dServ.getAll();
			model.addAttribute("dojos", dojos);
			return "newNinja.jsp";
		}
		else {
			nServ.create(ninja);
			Long id = ninja.getDojo().getId();
			return "redirect:/dojos/" + id;
		}
	}
	
	
}
