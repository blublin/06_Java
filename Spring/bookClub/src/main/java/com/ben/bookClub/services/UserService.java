package com.ben.bookClub.services;

import java.util.List;
import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.ben.bookClub.models.LoginUser;
import com.ben.bookClub.models.User;
import com.ben.bookClub.repos.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository uRep;
	
    public User register(User userFromReg, BindingResult result) {
        
        // Reject if email is taken (present in database)
    	Optional<User> userCheck = uRep.findByEmail( userFromReg.getEmail() );
    	if (userCheck.isPresent()) {
    		result.rejectValue("email", "regError", "Email already exists");
    		//	Test if identical keywords work    		
    		result.rejectValue("email", "regError", "Email already exists STILL");
    	}
    	
        // Reject if password doesn't match confirmation
    	if(!userFromReg.getPassword().equals(userFromReg.getConfirm())) {
    	    result.rejectValue("confirm", "Matches", "The Confirm Password must match Password!");
    	}
    	
        // Return null if result has errors
    	if (result.hasErrors()) {
    		return null;
    	}
    
    	//	No Errors found, register user    	
        // Hash and set password
    	String hashedPassword = BCrypt.hashpw(userFromReg.getPassword(), BCrypt.gensalt());
    	userFromReg.setPassword(hashedPassword);
    	// Save user to database
    	User validUser = uRep.save(userFromReg);
        return validUser;
    }
    
    
    public User login(LoginUser userFromLogin , BindingResult result) {
    	
    	Optional<User> userCheck = uRep.findByEmail( userFromLogin.getEmail() );
    	//	Check if user exists    	
    	if (userCheck.isEmpty()) {
    		result.rejectValue("email", "loginError", "Invalid Login");
    		return null;
    	}
    	//	And check if passwords match    	
    	else if( !BCrypt.checkpw( userFromLogin.getPassword(), userCheck.get().getPassword() )) {
    	    result.rejectValue("password", "loginError", "Invalid Login");
            return null;
    	}
    	else {
    		//	Login Email and Password match
    		return userCheck.get();
    	}
    }

//	|--- Get All ---|
	public List<User> getAll() {
		return uRep.findAll();
	}

//	|--- Get One By ID ---|
	public User readOne(Long id) {
		Optional<User> userOpt = uRep.findById(id);
		return userOpt.isPresent() ? userOpt.get() : null;
	}

//	|--- Create One ---|
	public User create(User u) {
		return uRep.save(u);
	}


//	|--- Update One ---|
	public User updateOne(User u) {
		return uRep.save(u);
	}

//	|--- Delete One ---|
	public void deleteOne(Long id) {
		uRep.deleteById(id);
	}
}