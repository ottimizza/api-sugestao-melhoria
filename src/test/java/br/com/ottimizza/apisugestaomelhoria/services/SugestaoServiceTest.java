package br.com.ottimizza.apisugestaomelhoria.services;

import org.junit.jupiter.api.TestMethodOrder;

import java.math.BigInteger;
import java.security.Principal;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.ottimizza.sugestaomelhoria.SugestaoMelhoriaApplication;
import br.com.ottimizza.sugestaomelhoria.domain.dtos.SugestaoDTO;
import br.com.ottimizza.sugestaomelhoria.models.Sugestao;
import br.com.ottimizza.sugestaomelhoria.services.SugestaoService;

@RunWith(SpringRunner.class)
@TestMethodOrder(OrderAnnotation.class)
@SpringBootTest(classes = SugestaoMelhoriaApplication.class)
public class SugestaoServiceTest {

	public static final String ADMINISTRATOR = "administrator@ottimizza.com.br";
    public static final String ACCOUNTANT = "accountant@ottimizza.com.br";
    public static final String CUSTOMER = "customer@ottimizza.com.br";
    
    @Mock
    private Principal principal;
    
    @Mock
    private OAuth2Authentication oauth2Authentication;
    
    @Autowired
    SugestaoService sugestaoService;
    
    SugestaoDTO sugestao = SugestaoDTO.builder()
    		.topicoId(BigInteger.ONE)
    		.usuario("Daniel")
    		.titulo("Ajustar alinhamento de botoes")
    		.descricaoSugestao("Botoes estao desalinhados")
    		.problemaResolvido("Melhora estetica da pagina")
    		.resultadoSuporte((short) 1)
    		.resultadoAutomacao((short) 1)
    		.resultadoProdutividade((short) 1)
    		.status(Sugestao.Status.ABERTO)
    		.numeroComentarios((short) 20)
    		.numeroLikes((short) 100)
    		.numeroDislikes((short) 10)
    	.build();
    		
    @Test
    @Order(1)
    public void dadoSugestaoDTO_quandoSalvaSugestao_entaoOK() throws Exception {
    	Mockito.when(principal.getName()).thenReturn(ADMINISTRATOR);
    	SugestaoDTO created = sugestaoService.salva(sugestao);
    	Assertions.assertNotNull(created);
    	Assertions.assertNotNull(created.getId());
    	Assertions.assertNotNull(created.getTopicoId());
    	Assertions.assertNotNull(created.getUsuario());
    	Assertions.assertNotNull(created.getDataCriacao());
    	Assertions.assertNotNull(created.getDataAtualizacao());
    	Assertions.assertNotNull(created.getTitulo());
    	Assertions.assertNotNull(created.getDescricaoSugestao());
    	Assertions.assertNotNull(created.getProblemaResolvido());
    	Assertions.assertNotNull(created.getResultadoSuporte());
    	Assertions.assertNotNull(created.getResultadoProdutividade());
    	Assertions.assertNotNull(created.getResultadoAutomacao());
    	Assertions.assertNotNull(created.getStatus());
    	Assertions.assertNotNull(created.getNumeroComentarios());
    	Assertions.assertNotNull(created.getNumeroLikes());
    	Assertions.assertNotNull(created.getNumeroDislikes());
    }
    
    /*public void dadoSugestaoDTO_quandoAtualizaSugestao_entaoOk() throws Exception {
    	Mockito.when(principal.getName()).thenReturn(ADMINISTRATOR);
    	
    	//Altera Campos
    	SugestaoDTO sugestao = new SugestaoDTO();
    	sugestao.setUsuario("Joao");
    	sugestao.setDescricaoSugestao("Atualizando");
    	sugestao.setId(BigInteger.ONE);
    	
    	SugestaoDTO created = sugestaoService.salva(sugestao);
    	Assertions.assertNotNull(created);
    	Assertions.assertNotNull(created.getId());
    	Assertions.assertNotNull(created.getTopicoId());
    	Assertions.assertNotNull(created.getUsuario());
    	Assertions.assertNotNull(created.getDataCriacao());
    	Assertions.assertNotNull(created.getDataAtualizacao());
    	Assertions.assertNotNull(created.getTitulo());
    	Assertions.assertNotNull(created.getDescricaoSugestao());
    	Assertions.assertNotNull(created.getProblemaResolvido());
    	Assertions.assertNotNull(created.getResultadoSuporte());
    	Assertions.assertNotNull(created.getResultadoProdutividade());
    	Assertions.assertNotNull(created.getResultadoAutomacao());
    	Assertions.assertNotNull(created.getStatus());
    	Assertions.assertNotNull(created.getNumeroComentarios());
    	Assertions.assertNotNull(created.getNumeroLikes());
    	Assertions.assertNotNull(created.getNumeroDislikes());
    }*/
	
}
