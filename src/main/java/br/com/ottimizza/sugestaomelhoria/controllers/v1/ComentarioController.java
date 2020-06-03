package br.com.ottimizza.sugestaomelhoria.controllers.v1;

import java.math.BigInteger;

import javax.inject.Inject;
import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ottimizza.sugestaomelhoria.domain.criterias.PageCriteria;
import br.com.ottimizza.sugestaomelhoria.domain.dtos.ComentarioDTO;
import br.com.ottimizza.sugestaomelhoria.domain.mappers.SugestaoMapper;
import br.com.ottimizza.sugestaomelhoria.domain.responses.GenericPageableResponse;
import br.com.ottimizza.sugestaomelhoria.models.Comentario;
import br.com.ottimizza.sugestaomelhoria.models.Sugestao;
import br.com.ottimizza.sugestaomelhoria.services.ComentarioService;
import br.com.ottimizza.sugestaomelhoria.services.SugestaoService;

@RestController
@RequestMapping("/api/comentario")
public class ComentarioController {
	
	@Inject
	ComentarioService comentarioService;
	
	@Inject
	SugestaoService sugestaoService;
	
	@GetMapping("{id}")
	public ResponseEntity<?> buscaPorId(@PathVariable("id") BigInteger id) throws Exception {
		return ResponseEntity.ok(comentarioService.buscaPorId(id));
	}
	
	@GetMapping
	public ResponseEntity<?> buscaPorFiltro(@Valid ComentarioDTO filtro, 
											@Valid PageCriteria pageCriteria) throws Exception {
		return ResponseEntity.ok(new GenericPageableResponse<Comentario>(comentarioService.buscaPorFiltro(filtro,  pageCriteria)));				
	}
	
	@PostMapping
	public ResponseEntity<?> save(@RequestBody Comentario comentario) throws Exception {
		return ResponseEntity.ok(comentarioService.save(comentario));
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<?> delete(@PathVariable("id")BigInteger id) throws Exception {
		return ResponseEntity.ok(comentarioService.deletaPorId(id).toString());
	}
	

}
