package com.ben.daikichiRoutes.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
	
	@RequestMapping(value="/daikichi", method=RequestMethod.GET)
	public String welcome() {
		return "Welcome!";
	}
	
	@RequestMapping(value="/daikichi/today", method=RequestMethod.GET)
	public String todayForutune() {
		return "Today you will find luck in all your endeavors!";
	}
	
	@RequestMapping(value="/daikichi/tomorrow", method=RequestMethod.GET)
	public String tomorrowFortune() {
		return "Tomorrow, an opportunity will arise, so be sure to be open to new ideas!";
	}
	
	@RequestMapping(value="daikichi/travel/{location}", method=RequestMethod.GET)
	public String travelRoute(@PathVariable("location") String location) {
		return "Congratulations! You will soon travel to " + location;
	}
	
	@RequestMapping(value="daikichi/lotto/{num}", method=RequestMethod.GET)
	public String lottoRoute(@PathVariable("num") String strNum) {
		int num;
		try{
            num = Integer.parseInt(strNum);
        }
        catch (NumberFormatException error){
            return "Tsk tsk. That is not a number!";
        }
		
		if (num % 2 == 0) {
			return "You will take a grand journey in the near future, but be weary of tempting offers";
		}
		else {
			return "You have enjoyed the fruits of your labor but now is a great time to spend time with family and friends.";
		}
	}
	
	
}
