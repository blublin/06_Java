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
        model.addAttribute("regObj", new User()); // This goes to the register form
        model.addAttribute("loginObj", new LoginUser()); // This goes to the login form
        return "loginReg.jsp";
    }
    
    @PostMapping("/register")
    public String register(@Valid @ModelAttribute("regObj") User regObj, 
            BindingResult result, Model model, HttpSession seshRogen) {
        
    	//	Use Service to validate and conditionally register 
    	User validUser = uServ.register(regObj, result);
 
        // to do some extra validations and create a new user!
        if (validUser == null || result.hasErrors() ) {
    		//	Re-rendering, need to provide another newLogin object.
        	model.addAttribute("loginObj", new LoginUser());
    		//	newUser from ModelAttribute still exists and will be sent forward
    		return "loginReg.jsp";
    	}        	
        
        // No errors!
        //	Store user ID in session        
        seshRogen.setAttribute("user_id", regObj.getId());
    
        return "redirect:/dashboard";
    }
    
    @PostMapping("/login")
    public String login(@Valid @ModelAttribute("loginObj") LoginUser loginObj, 
            BindingResult bRes, Model model, HttpSession seshRogen) {
        
        // Add once service is implemented:
		User userCheck = uServ.login(loginObj, bRes);
		
        if(userCheck == null || bRes.hasErrors()) {
            model.addAttribute("regObj", new User());
            return "loginReg.jsp";
        }
        // No errors! 
//    	Store user ID in session        
        seshRogen.setAttribute("user_id", userCheck.getId());
   
        return "redirect:/dashboard";
    }
    
    @GetMapping("/logout")
    public String logout(HttpSession seshRogen) {
    	seshRogen.invalidate();
    	return "redirect:/";
    }
}
