/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.springproject.springproject.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author rodrigo
 */

@Entity
public class Persona {
    
    @Id @GeneratedValue
    private long id;
    
    private String name;
    
    @Column(nullable=false, length = 70)
    private String email;
    
    @Column(nullable=false, length = 20)
    private String password;
    

    public Persona(String NewName, String NewEmail, String NewPassword) {
    	this.name = NewName;
    	this.email=NewEmail;
    	this.password=NewPassword;
	}
    
    public Persona() {
    	
    }

	public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
    
}
