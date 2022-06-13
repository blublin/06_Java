package com.ben.ninjagold.goldcontroller;

import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GoldController {

	@GetMapping("/")
	public String index(HttpSession seshRogen, Model model) {
		if (seshRogen.getAttribute("actions") == null) {
//			Array List to store all actions in session
			ArrayList<String> actions = new ArrayList<String>();
			seshRogen.setAttribute("actions", actions);
		}
		if (seshRogen.getAttribute("gold") == null) {
//			Attribute to continually store player gold
			seshRogen.setAttribute("gold", 0);
		}

		return "index.jsp";
	}

	@PostMapping("/find/{location}")
	public String determineGold(@RequestParam("location") String location,
			HttpSession seshRogen) {
		if (seshRogen.getAttribute("actions") == null) {
//			Safety check to prevent actions before ready
			return "redirect:/";
		}
		
		int newGold = 0;
		boolean gainGold = true;
		String action = "";
		switch (location) {
//		Determine which form was sent
			case "farm":
				newGold = genGold(10, 20);
				action = "You entered a farm and earned";
				break;
			case "cave":
				newGold = genGold(5, 10);
				action = "You entered a cave and earned";
				break;
			case "house":
				newGold = genGold(2, 5);
				action = "You entered a house and earned";
				break;
			case "quest":
				newGold = genGold(0, 50);
				boolean success = questSuccess();
				if (!success) {
					action = "You failed a quest and lost";
					gainGold = false;
				}
				else {
					action = "You completed a quest and earned";
				}
				break;
		}
		int modGold = 0;
		if (gainGold) {
			modGold = (int) seshRogen.getAttribute("gold") + newGold;			
		}
		else {
			modGold = (int) seshRogen.getAttribute("gold") - newGold;
		}
		seshRogen.setAttribute("gold", modGold);
		
//		Concat string from switch with gold and date
		action += String.format(" %s gold. %s)", newGold, new Date());
		ArrayList<String> actions = (ArrayList<String>) seshRogen.getAttribute("actions");
//		Add to front (index 0)
		actions.add(0, action);
		seshRogen.setAttribute("actions", actions);
		
		return "redirect:/";
	}

	
	private int genGold(int start, int stop) {
		Random rand = new Random();
		int gold = rand.nextInt(start, stop + 1);
		return gold;
	}
	
	private boolean questSuccess() {
		double rand = Math.random();
		if (rand < 0.5) {
			return false;
		}
		else {
			return true;
		}
	}
}
