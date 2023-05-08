package it.beije.mockito;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import it.beije.mockito.controller.ControllerTest;
import it.beije.mockito.dto.ProvaDTO;
import it.beije.mockito.service.ServiceTest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.hamcrest.Matchers;

@SpringBootTest
@AutoConfigureMockMvc
//@WebMvcTest(controllers = ControllerTest.class)
class MockitoApplicationTests {

	@MockBean
	private ServiceTest service;

	@Autowired
	private MockMvc mockMvc;

	@Test
	@DisplayName("Boh")
	public void shouldDummy() throws Exception {
		
		ProvaDTO user = new ProvaDTO(1, "Pinco", "Pallino");
        Mockito.when(service.findUser(1)).thenReturn(user);

		mockMvc.perform(get("http://localhost:8080/1").contentType(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().is(200))
				.andExpect(content().contentTypeCompatibleWith("application/json"))
				.andExpect(jsonPath("$.id", Matchers.is(1)));

	}

}
