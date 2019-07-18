package br.com.calcard;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.calcard.api.entity.Cliente;
import br.com.calcard.api.entity.Estado;
import br.com.calcard.api.entity.EstadoCivil;
import br.com.calcard.api.entity.Proposta;
import br.com.calcard.api.entity.Sexo;
import br.com.calcard.api.repository.ClienteRepository;
import br.com.calcard.api.repository.PropostaRepository;
import br.com.calcard.api.service.PropostaService;

@RunWith(SpringRunner.class)
@SpringBootTest() 
public class PropostaControllerTest {
	
	private Proposta proposta;
	
	@Autowired
	private PropostaService propostaService;
	
	@MockBean
	private PropostaRepository propostaRepository;
	
	@MockBean
	private ClienteRepository clienteRepository;
//	
//	@MockBean
//	private EntityManagerFactory emf; 
	
	@Before
	public void config() {
		proposta = new Proposta();
    	proposta.setRenda(3000L);
    	proposta.setCliente(new Cliente());
    	proposta.getCliente().setNome("Nome");
    	proposta.getCliente().setCpf("99999999999");
    	proposta.getCliente().setDependentes(0);
    	proposta.getCliente().setEstado(Estado.AC);
    	proposta.getCliente().setEstadoCivil(EstadoCivil.CASADO);
    	proposta.getCliente().setIdade(33);
    	proposta.getCliente().setSexo(Sexo. M);
	}
    
    @Test
    public void cadastrarProposta() throws Exception {
    	
    	when(this.propostaRepository.save(isA(Proposta.class)))
			.thenReturn(proposta);
    	
    	when(this.clienteRepository.save(isA(Cliente.class)))
			.thenReturn(proposta.getCliente());
    	
    	 assertEquals(propostaService.createOrUpdate(proposta), proposta);
    }
//    
//    @Test
//    public void cadastrarPropostaErro() throws Exception {
//    	Proposta proposta = new Proposta();
//        ResponseEntity<String> response = restTemplate.postForEntity(
//			new URL("http://localhost:" + port + "/api/proposta").toString(),
//			proposta,
//			String.class);
//        Response<PropostaResponse> entity = new Gson().fromJson(response.getBody(), new Response<PropostaResponse>().getClass());
//        assertNotEquals(0, entity.getErrors().size());
//    } 
//    
//    @Test
//    public void buscarProposta() throws Exception {
//        ResponseEntity<String> response = restTemplate.getForEntity(
//			new URL("http://localhost:" + port + "/api/proposta/find/99999999999").toString(),
//			String.class);
//        Response<PropostaResponse> entity = new Gson().fromJson(response.getBody(), new Response<PropostaResponse>().getClass());
//        assertEquals(0, entity.getErrors().size());
//    } 
//    
//    @Test
//    public void buscarPropostaErro() throws Exception {
//        ResponseEntity<String> response = restTemplate.getForEntity(
//			new URL("http://localhost:" + port + "/api/proposta/find/55555555555").toString(),
//			String.class);
//        Response<PropostaResponse> entity = new Gson().fromJson(response.getBody(), new Response<PropostaResponse>().getClass());
//        assertNotEquals(0, entity.getErrors().size());
//    }
}
