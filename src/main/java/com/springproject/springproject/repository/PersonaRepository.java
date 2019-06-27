/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.springproject.springproject.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.springproject.springproject.model.Persona;


/**
 *
 * @author rodrigo
 */

public interface PersonaRepository extends JpaRepository<Persona, Long>{
    
	@Query("select p from Persona p where p.email=:email")
	public Persona findByEmail(@Param("email") String email);
	
	@Query("select p from Persona p")
	public List<Persona> buscarTodos();
	
	
    
}
