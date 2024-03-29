package it.beije.mockito;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.fasterxml.jackson.databind.ObjectMapper;

import it.beije.mockito.dto.ProvaDTO;
import it.beije.mockito.dto.TodoListDTO;
import it.beije.mockito.model.ToDoList;
import it.beije.mockito.repository.ToDoListRepository;
import it.beije.mockito.service.ServiceTest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.assertj.core.api.Assertions;

import static java.util.Arrays.asList;

import org.hamcrest.Matchers;

@SpringBootTest(webEnvironment = WebEnvironment.MOCK)
@AutoConfigureMockMvc
class MockitoApplicationTests {

	@MockBean
	private ServiceTest service;

	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	private ToDoListRepository realRepo;
	
//	@Disabled
	@Test
	@DisplayName("With Mockito.mock()")
	public void countNoteTest() throws Exception{
		
	    ToDoListRepository localMockRepository = Mockito.mock(ToDoListRepository.class);
	    Mockito.when(localMockRepository.count()).thenReturn(15L);

	    long noteCount = localMockRepository.count();
	    long realCount = realRepo.count();
	    
	    System.out.println("noteCount -> "+noteCount);
	    System.out.println("realCount -> "+realCount);

	    Assertions.assertThat(15L == noteCount);
//	    Mockito.verify(localMockRepository, Mockito.times(1)).count();
	    Mockito.verify(localMockRepository).count();
	}

//	@Disabled
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

//	@Disabled
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
//		Mockito.when(service.addNote(Mockito.any(ToDoList.class))).thenReturn(Mockito.any(TodoListDTO.class));

		String json = new ObjectMapper().writeValueAsString(todoList);

//		MvcResult mvc = 
		mockMvc.perform(post("http://localhost:8080/add").contentType(MediaType.APPLICATION_JSON_VALUE).content(json))
				.andExpect(status().is(200));
//				.andReturn();

//		String response = mvc.getResponse().getContentAsString();
//		Assertions.assertThat(response).isEmpty();

	}
	
}
