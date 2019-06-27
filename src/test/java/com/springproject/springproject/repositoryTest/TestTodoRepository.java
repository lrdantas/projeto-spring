package com.springproject.springproject.repositoryTest;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import javax.persistence.EntityManager;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestDatabase.Replace;
import org.springframework.test.context.junit4.SpringRunner;

import com.springproject.springproject.model.Todo;
import com.springproject.springproject.repository.TodoRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace=Replace.NONE)
public class TestTodoRepository {
	
	@Autowired
    TodoRepository todoRepository;
	
	@Autowired
	EntityManager entityManager;
	
	@Test
	public void testSalvar(){
	
		Todo work = new Todo("Estudar",false);
		Todo workSave = todoRepository.save(work);
		Assert.assertNotNull(workSave.getId());
		
		
	}
  
    @Test
    public void testBuscarTodos(){
    	Todo trabalhar = new Todo("trabalhar",false);
    	entityManager.persist(trabalhar);
    		
    	Todo estudar = new Todo("Estudar", false);
    	entityManager.persist(estudar);
    		
    		
    	List<Todo> lista = todoRepository.findAll();
    	assertThat(lista.get(0).getName()).isEqualTo(trabalhar.getName());
    	assertThat(lista.get(1).getName()).isEqualTo(estudar.getName());
    		
    }

}
