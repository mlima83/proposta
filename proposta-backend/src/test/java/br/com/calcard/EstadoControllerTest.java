//package br.com.calcard;
//
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.http.MediaType;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.MockMvc;
//
//import br.com.calcard.api.controller.EstadoController;
//
//@RunWith(SpringRunner.class)
//@WebMvcTest(controllers = EstadoController.class)
//public class EstadoControllerTest {
//	@Autowired
//	private MockMvc mvc;
//    
//	@Test
//    public void getEstados() throws Exception {
//		this.mvc.perform(get("/api/estado").accept(MediaType.APPLICATION_JSON))
//			.andExpect(status().isOk())
//		/* .andExpect(content().) */;
//    }
//}
