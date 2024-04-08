package com.springboot.todo.MyTodoProject.login;

import org.springframework.stereotype.Service;

@Service
public class LoginAuthentication {
	
	public boolean loginAuthentication(String username,String password) {
		
		String user=username.toLowerCase();
		
		boolean userCheck=user.equals("eshwar");
		boolean passwordCheck=password.equals("Dummy");
		
		return userCheck&&passwordCheck;
		
	}

}
