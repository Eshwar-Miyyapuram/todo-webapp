package com.springboot.todo.MyTodoProject.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
@SessionAttributes("name")
public class LoginController {
	
	@Autowired
	LoginAuthentication login;
	
	@RequestMapping(value="/random", method=RequestMethod.GET)
	public String getLogin() {
		return "login";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String getLoginPage(@RequestParam String name, @RequestParam String password, ModelMap model) {
		
		if(login.loginAuthentication(name,password)) {
			model.put("name",name);
			return "welcome";
		}
		model.put("error","Invalid Credentials!!!!");
		return "login";
	}

}
