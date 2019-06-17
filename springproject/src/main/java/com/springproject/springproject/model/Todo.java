package com.springproject.springproject.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Todo {
	
	    @Id 
	    @GeneratedValue
	    private long id;
	    
	    private String name;
	    
	    @Column(nullable=false)
	    private boolean done;
	    
	    public Todo() {
			
		}

		public Todo(String name, boolean done) {
			super();
			this.name = name;
			this.done = done;
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

		public boolean isDone() {
			return done;
		}

		public void setDone(boolean done) {
			this.done = done;
		}
		    

}
