package com.springboot.todo.MyTodoProject.TodoList;

import java.time.LocalDate;
import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

@Controller	
@SessionAttributes("name")
public class TodoControllerJPA {  
	
	
	private TodoRepository todoRepository;
	
	public TodoControllerJPA(TodoRepository todoRepository) {
		super();
		this.todoRepository=todoRepository;
	}


	@RequestMapping("list-todos")
	public String ListAllTodos(ModelMap model) {
		String username= getLoggedInUsername();
		model.put("name", username);
		
		List<Todo> list=todoRepository.findByUsername(username);
		model.put("list", list);
		return "todolist";
	}


	
	
	@RequestMapping(value="add-todo", method=RequestMethod.GET)
	public String showNewTodoPage(ModelMap model) {
		String username=getLoggedInUsername();
		model.put("name", username);
		Todo todo=new Todo(0,username,"",LocalDate.now().plusYears(1),false);
		model.put("todo",todo);
		return "todo";
	}
	
	@RequestMapping(value="add-todo", method=RequestMethod.POST)
	public String addNewTodoPage(ModelMap model, @Valid Todo todo, BindingResult result) {
		if(result.hasErrors()) {
			return "todo";
		}
		String username=getLoggedInUsername();
		model.put("name", username);
		todo.setUsername(username);
		todoRepository.save(todo);
		return "redirect:list-todos";
	}
	
	@RequestMapping("delete-todo")
	public String deleteTodoById(@RequestParam int id) {
		todoRepository.deleteById(id);
		return "redirect:list-todos";
	}
	
	@RequestMapping(value="update-todo", method=RequestMethod.GET)
	public String showUpdateTodoPage(@RequestParam int id,ModelMap model) {
		Todo todo=todoRepository.findById(id).get();
		model.put("todo", todo);
		return "todo";
	}
	@RequestMapping(value="update-todo", method=RequestMethod.POST)
	public String updateTodoPage(@Valid Todo todo,BindingResult result) {
		if(result.hasErrors()) {
			return "todo";
		}
		todo.setUsername(getLoggedInUsername());
		todoRepository.save(todo);
		return "redirect:list-todos";
	}
	
	private String getLoggedInUsername() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		
		return authentication.getName();
	}
	
}
