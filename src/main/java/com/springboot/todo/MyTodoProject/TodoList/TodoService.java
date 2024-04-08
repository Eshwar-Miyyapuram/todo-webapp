package com.springboot.todo.MyTodoProject.TodoList;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

import jakarta.validation.Valid;

@Service
public class TodoService {
	
	private static List<Todo> todos=new ArrayList<>();
	private static int todocount=0;
	
	static {
		todos.add(new Todo(++todocount,"eshwar","Learn AWS",LocalDate.now().plusYears(1),false));
		todos.add(new Todo(++todocount,"eshwar","Learn K8's",LocalDate.now().plusYears(2),false));
		todos.add(new Todo(++todocount,"Admin","Learn Stack",LocalDate.now().plusYears(3),false));
	}
	
	public List<Todo> findByUsername(String name){
		Predicate<? super Todo> predicate= todo-> todo.getUsername().equalsIgnoreCase(name);
		List<Todo> currentUserList=todos.stream().filter(predicate).toList();
		return currentUserList;
	}
	
	public void addTodo(String username,String description,LocalDate date,boolean done) {
		Todo newTodo= new Todo(++todocount,username,description,date,done);
		todos.add(newTodo);		
	}
	
	public void deleteById(int id) {
		
		Predicate<? super Todo> predicate=todo -> todo.getId()==id;
		todos.removeIf(predicate);
		
	}
	
    

	public Todo findById(int id) {
		// TODO Auto-generated method stub
		Predicate<? super Todo> predicate=todo -> todo.getId()==id;
		Todo todo=todos.stream().filter(predicate).findFirst().get();
		return todo;
	}

	public void updateTodo(@Valid Todo currentTodo) {
		// TODO Auto-generated method stub
		Predicate<? super Todo> predicate=todo -> todo.getId()==currentTodo.getId();
		Todo todo=todos.stream().filter(predicate).findFirst().get();
		todo.setDescription(currentTodo.getDescription());
		todo.setDate(currentTodo.getDate());
	}


	
	

}
