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

	private boolean modoEdicao=false;
	
	@PostConstruct
	public void init() {
		setTodos(todoRepository.findAll());
	}
	public void salvar(){
		
		todoRepository.save(todo);
		if(!isModoEdicao())
			todos.add(todo);
		todo = new Todo();
		setModoEdicao(false);
	}

	public void excluir(Todo todo){
		todoRepository.delete(todo);
		todos.remove(todo);
	}
	
	public void editar(Todo todo){
		setTodo(todo);
		setModoEdicao(true);
	}
	
	public void cancelar(){
		todo = new Todo();
		setModoEdicao(false);
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
	public boolean isModoEdicao() {
		return modoEdicao;
	}
	public void setModoEdicao(boolean modoEdicao) {
		this.modoEdicao = modoEdicao;
	}
	

}
