package it.beije.mockito;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.fasterxml.jackson.databind.ObjectMapper;

import it.beije.mockito.dto.ProvaDTO;
import it.beije.mockito.dto.TodoListDTO;
import it.beije.mockito.model.ToDoList;
import it.beije.mockito.service.ServiceTest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.assertj.core.api.Assertions;

import static java.util.Arrays.asList;

import org.hamcrest.Matchers;

@SpringBootTest
@AutoConfigureMockMvc
class MockitoApplicationTests {

	@MockBean
	private ServiceTest service;

	@Autowired
	private MockMvc mockMvc;

	@Disabled
	@Test
	@DisplayName("Get test")
	public void shouldDummy() throws Exception {
		Mockito.when(service.findUser(1)).thenReturn(new ProvaDTO(1, "Pinco", "Pallino"));
		Mockito.when(service.findUser(2)).thenReturn(new ProvaDTO(2, "Mario", "Rossi"));

		mockMvc.perform(get("http://localhost:8080/user/1").contentType(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().is(200)).andExpect(content().contentTypeCompatibleWith("application/json"))
				.andExpect(jsonPath("$.id", Matchers.is(1)));

		mockMvc.perform(get("http://localhost:8080/user/2").contentType(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().is(200)).andExpect(content().contentTypeCompatibleWith("application/json"))
				.andExpect(jsonPath("$.id", Matchers.is(2))).andExpect(jsonPath("$.name", Matchers.is("Mario")));

	}

	@Disabled
	@Test
	@DisplayName("To Do List demo: simple get")
	public void toDoGetDemo() throws Exception {
		TodoListDTO todoList = new TodoListDTO();
		todoList.setUsername("Luigi");
		String note1 = "Ciao";
		String note2 = "Hola";
		String note3 = "Hello";
		todoList.setNotes(asList(note1, note2, note3));
		
		Mockito.when(service.findNotesByUsername("Luigi")).thenReturn(todoList);

		mockMvc.perform(get("http://localhost:8080/notes?username=Luigi")).andExpect(status().is(200))
				.andExpect(content().contentTypeCompatibleWith("application/json"))
				.andExpect(jsonPath("$.username", Matchers.is(todoList.getUsername())))
				.andExpect(jsonPath("$.notes", Matchers.is(todoList.getNotes())));
	}

	/*
	 * This is a sample code that tests the creation of a user using the POST
	 * method. The code uses the Spring Framework’s MockMvcRequestBuilders.post()
	 * method to create a POST request. The request is then sent to the server using
	 * the mockMvc.perform() method. The response is then checked for correctness
	 * using the status() and jsonPath() methods.
	 */
	@Test
	@DisplayName("To Do List demo: simple post")
	public void toDoPostDemo() throws Exception {

		ToDoList todoList = new ToDoList();
		todoList.setId(0);
		todoList.setUsername("Mary");
		todoList.setNote("Prova mock");

		TodoListDTO response = new TodoListDTO();
		response.setUsername("Mary");
		response.setNotes(asList(todoList.getNote()));
		
		Mockito.when(service.addNote(todoList)).thenReturn(response);
//		Mockito.when(service.addNote(Mockito.any(ToDoList.class))).thenReturn(response);

		String json = new ObjectMapper().writeValueAsString(todoList);

//		MvcResult mvc = 
		mockMvc.perform(post("http://localhost:8080/add").contentType(MediaType.APPLICATION_JSON_VALUE).content(json))
				.andExpect(status().is(200));
//				.andReturn();

//		String response = mvc.getResponse().getContentAsString();
//		Assertions.assertThat(response).isEmpty();

		/*
		 * 
1. `shouldDummy`: questo test esegue una chiamata GET a `/user` con ID 1 e 2 e verifica che i risultati siano corretti. In particolare, utilizza il framework Mockito per simulare la risposta del servizio `ServiceTest` e verifica che il risultato della chiamata contenga i valori attesi.
2. `toDoGetDemo`: questo test esegue una chiamata GET a `/notes` con il parametro `username` impostato su "Luigi". Anche in questo caso, utilizza Mockito per simulare la risposta del servizio e verifica che il risultato della chiamata contenga i valori attesi.
3. `toDoPostDemo`: questo test esegue una chiamata POST a `/add` con un oggetto `ToDoList` e verifica che la chiamata restituisca uno stato 200. Anche in questo caso, utilizza Mockito per simulare la risposta del servizio.

Le annotazioni `@SpringBootTest` e `@AutoConfigureMockMvc` vengono utilizzate per configurare l'applicazione Spring Boot e il framework MVC per i test. La classe `ServiceTest` viene simulata utilizzando l'annotazione `@MockBean`. Viene inoltre utilizzata la classe `MockMvc` per simulare le chiamate HTTP. Infine, ogni test è annotato con `@Disabled` per evitare che vengano eseguiti durante la demo.
		 */
	}
}
