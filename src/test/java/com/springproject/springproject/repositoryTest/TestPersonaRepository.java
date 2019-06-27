package com.springproject.springproject.repositoryTest;


import javax.persistence.EntityManager;

import com.springproject.springproject.model.Persona;
import com.springproject.springproject.repository.PersonaRepository;


import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
/**
 *
 * @author rodrigo
 */


@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace=Replace.NONE)
public class TestPersonaRepository {
    
    @Autowired
    PersonaRepository personaRepository;
	
	@Autowired
	EntityManager entityManager;
	
	@Test
	public void testSalvar(){
	
		Persona user = new Persona("luis", "luis@esig.com", "123");
		Persona userSave = personaRepository.save(user);
		Assert.assertNotNull(userSave.getId());
		
		
	}
        
    @Test
	public void testBuscarPorEmail(){
        Persona user = new Persona("luis", "luis@esig.com", "123");
		entityManager.persist(user);
		
		Persona cliEncontrado = personaRepository.findByEmail("luis@esig.com");
		
		assertThat(cliEncontrado.getName()).isEqualTo(user.getName());
		assertThat(cliEncontrado.getEmail()).isEqualTo(user.getEmail());
		assertThat(cliEncontrado.getPassword()).isEqualTo(user.getPassword());
                                            
	}
        
    @Test
    public void testBuscarTodos(){
    	Persona luis = new Persona("luis","luis@esig.com", "123");
    	entityManager.persist(luis);
    		
    	Persona rodrigo = new Persona("rodrigo","rodrigo@esig.com", "12345");
    	entityManager.persist(rodrigo);
    		
    		
    	List<Persona> lista = personaRepository.buscarTodos();
    	assertThat(lista.get(0).getName()).isEqualTo(luis.getName());
    	assertThat(lista.get(1).getName()).isEqualTo(rodrigo.getName());
    		
    }

}
