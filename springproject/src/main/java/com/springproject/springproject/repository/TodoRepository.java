package com.springproject.springproject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.springproject.springproject.model.Todo;

public interface TodoRepository extends JpaRepository<Todo, Long>{
	
	@Query("select t from Todo t")
	public List<Todo> findTodos();
}


