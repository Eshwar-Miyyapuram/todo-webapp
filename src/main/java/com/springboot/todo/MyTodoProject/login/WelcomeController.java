package com.springboot.todo.MyTodoProject.login;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;


@Controller
@SessionAttributes("name")
public class WelcomeController {
	
	@RequestMapping("/")
    public String getWelcomePage(ModelMap model){
		model.put("name",getLoggedUsername());
	    return "welcome";
    }
	
	private String getLoggedUsername() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		
		return authentication.getName();
		
	}

}
