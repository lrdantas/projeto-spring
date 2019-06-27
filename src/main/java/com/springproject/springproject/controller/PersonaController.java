package com.springproject.springproject.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;

import com.springproject.springproject.model.Persona;
import com.springproject.springproject.repository.PersonaRepository;



@Named
@ViewScoped
public class PersonaController {

	@Autowired
	private PersonaRepository personaRepository;
	
	private List<Persona> personas;
	
	private Persona persona =  new Persona();

	private boolean modoEdicao=false;
	
	@PostConstruct
	public void init() {
		setPersonas(personaRepository.buscarTodos());
	}
	public void salvar(){
		
		personaRepository.save(persona);
		if(!isModoEdicao())
			personas.add(persona);
		persona = new Persona();
		setModoEdicao(false);
	}

	public void excluir(Persona persona){
		personaRepository.delete(persona);
		personas.remove(persona);
	}
	
	public void editar(Persona persona){
		setPersona(persona);
		setModoEdicao(true);
	}
	
	public void cancelar(){
		persona = new Persona();
		setModoEdicao(false);
	}

	public Persona getPersona() {
		return persona;
	}


	public void setPersona(Persona persona) {
		this.persona = persona;
	}
	public List<Persona> getPersonas() {
		return personas;
	}
	public void setPersonas(List<Persona> personas) {
		this.personas = personas;
	}
	public boolean isModoEdicao() {
		return modoEdicao;
	}
	public void setModoEdicao(boolean modoEdicao) {
		this.modoEdicao = modoEdicao;
	}
}

