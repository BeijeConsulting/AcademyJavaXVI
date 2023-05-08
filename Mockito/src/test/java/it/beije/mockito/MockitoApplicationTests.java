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

//        System.out.println(Mockito.when(service.dummyService(2)).thenReturn("Okay"));

        
        mockMvc.perform(get("/1"))
                .andExpect(status().is(200))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id", Matchers.is(1)))
                ;
        /*
        mockMvc.perform(get("/api/posts/"))
        .andExpect(status().is(200))
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
//        .andExpect(jsonPath("$.size()", Matchers.is(2)))
        .andExpect(jsonPath("$[0].id", Matchers.is(1)))
        .andExpect(jsonPath("$[0].name", Matchers.is("Pinco")))
        .andExpect(jsonPath("$[0].surname", Matchers.is("Pallino")));*/

    }

}
