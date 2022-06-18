package com.ben.bookClub.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.ben.bookClub.models.LoginUser;
import com.ben.bookClub.models.User;
import com.ben.bookClub.services.UserService;

@Controller
public class UserController {
     @Autowired
     private UserService uServ;
    
    @GetMapping("/")
    public String index(Model model) {
    
        // Bind empty User and LoginUser objects to the JSP
        // to capture the form input
        model.addAttribute("newUser", new User());
        model.addAttribute("newLogin", new LoginUser());
        return "index.jsp";
    }
    
    @PostMapping("/register")
    public String register(@Valid @ModelAttribute("newUser") User newUser, 
            BindingResult result, Model model, HttpSession seshRogen) {
        
    	//	Use Service to validate and conditionally register 
    	User validUser = uServ.register(newUser, result);
 
        // to do some extra validations and create a new user!
        if (validUser == null || result.hasErrors() ) {
    		//	Re-rendering, need to provide another newLogin object.
        	model.addAttribute("newLogin", new LoginUser());
    		//	newUser from ModelAttribute still exists and will be sent forward
    		return "index.jsp";
    	}        	
        
        // No errors!
        //	Store user ID in session        
        seshRogen.setAttribute("user_id", newUser.getId());
    
        return "redirect:/home";
    }
    
    @PostMapping("/login")
    public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin, 
            BindingResult bRes, Model model, HttpSession seshRogen) {
        
        // Add once service is implemented:
		User userCheck = uServ.login(newLogin, bRes);
		
        if(userCheck == null || bRes.hasErrors()) {
            model.addAttribute("newUser", new User());
            return "index.jsp";
        }
        // No errors! 
//    	Store user ID in session        
        seshRogen.setAttribute("user_id", userCheck.getId());
   
        return "redirect:/home";
    }
}
