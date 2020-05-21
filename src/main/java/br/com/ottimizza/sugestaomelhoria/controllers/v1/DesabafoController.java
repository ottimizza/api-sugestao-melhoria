package br.com.ottimizza.sugestaomelhoria.controllers.v1;

import java.math.BigInteger;
import java.util.Optional;

import javax.inject.Inject;
import javax.validation.Valid;

import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.ottimizza.sugestaomelhoria.domain.criterias.PageCriteria;
import br.com.ottimizza.sugestaomelhoria.domain.dtos.DesabafoDTO;
import br.com.ottimizza.sugestaomelhoria.domain.responses.GenericPageableResponse;
import br.com.ottimizza.sugestaomelhoria.models.Comentario;
import br.com.ottimizza.sugestaomelhoria.models.Desabafo;
import br.com.ottimizza.sugestaomelhoria.services.DesabafoService;

@RestController
@RequestMapping("/api/desabafo")
public class DesabafoController {

	@Inject
	DesabafoService desabafoService;
	
	@PostMapping
	public ResponseEntity<?> saveDesabafo(@RequestBody Desabafo desabafo) throws Exception {
		return ResponseEntity.ok(desabafoService.salva(desabafo));
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<?> deleteDesabafo(@PathVariable("id") BigInteger id) throws Exception {
		return ResponseEntity.ok(desabafoService.deletaPorId(id));
	}
	
	@GetMapping
	public ResponseEntity<?> findDesabafo(@Valid DesabafoDTO filtro, 
										  @Valid PageCriteria pageCriteria,
										  @RequestHeader("Authorization") String authorization) throws Exception{
		return ResponseEntity.ok(new GenericPageableResponse<Desabafo>(desabafoService.buscaPorFiltro(filtro, pageCriteria, authorization)));
	}
	
	@GetMapping("{id}")
	public ResponseEntity<?> findById(@PathVariable("id") BigInteger id) throws Exception {
		return ResponseEntity.ok(desabafoService.buscaPorId(id));
	}
	
	
	
	
}
