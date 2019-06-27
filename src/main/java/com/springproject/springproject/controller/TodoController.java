package com.springproject.springproject.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;

import com.springproject.springproject.model.Todo;
import com.springproject.springproject.repository.TodoRepository;

@Named
@ViewScoped
public class TodoController {
	
	@Autowired
	private TodoRepository todoRepository;
	
	private List<Todo> todos;
	
	private Todo todo =  new Todo();
	
	private String status = "Pendente";

	private boolean updating=false;
	
	@PostConstruct
	public void init() {
		setTodos(todoRepository.findAll());
	}
	public void salvar(){		
		todoRepository.save(todo);
		if(!isUpdating())
			todos.add(todo);
		todo = new Todo();
		setUpdating(false);
	}

	public void excluir(Todo todo){
		todoRepository.delete(todo);
		todos.remove(todo);
	}
	
	public void editar(Todo todo){
		setTodo(todo);
		setUpdating(true);
	}
	
	public void cancelar(){
		todo = new Todo();
		setUpdating(false);
	}

	public Todo getTodo() {
		return todo;
	}

	public void setTodo(Todo todo) {
		this.todo = todo;
	}
	public List<Todo> getTodos() {
		return todos;
	}
	public void setTodos(List<Todo> todos) {
		this.todos = todos;
	}
	public boolean isUpdating() {
		return updating;
	}
	public void setUpdating(boolean updating) {
		this.updating = updating;
	}
	public TodoRepository getTodoRepository() {
		return todoRepository;
	}
	public void setTodoRepository(TodoRepository todoRepository) {
		this.todoRepository = todoRepository;
	}
	public String getStatus() {
		if(todo.isDone())
			return "Realizado";
		else
			return "Pendente";
	}
	
}
