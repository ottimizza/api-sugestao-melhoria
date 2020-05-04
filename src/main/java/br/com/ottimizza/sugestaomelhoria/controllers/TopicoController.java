package br.com.ottimizza.sugestaomelhoria.controllers;

import java.math.BigInteger;

import javax.inject.Inject;
import javax.validation.Valid;

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

import br.com.ottimizza.sugestaomelhoria.domain.dtos.TopicoDTO;
import br.com.ottimizza.sugestaomelhoria.models.Topico;
import br.com.ottimizza.sugestaomelhoria.services.TopicoService;

@RestController
@RequestMapping("/topico")
public class TopicoController {

	@Inject
	TopicoService topicoService;

	@PostMapping
	public ResponseEntity<?> saveTopico(@RequestBody Topico topico) throws Exception {
		return ResponseEntity.ok(topicoService.salva(topico));
	}

	@GetMapping
	public ResponseEntity<?> findTopico(@Valid TopicoDTO filtro,
										@RequestParam(name = "page_index", defaultValue = "0") int pageIndex, 
										@RequestParam(name = "page_size", defaultValue = "10") int pageSize, 
										@RequestHeader("Authorization") String authorization) throws Exception{
		return ResponseEntity.ok(topicoService.buscaPorFiltro(filtro, pageIndex, pageSize, authorization));
	}
	
	@GetMapping("{id}")
	public ResponseEntity<?> findById(@PathVariable("id") BigInteger id) throws Exception {
		return ResponseEntity.ok(topicoService.buscaPorId(id));
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<?> deleteTopico(@PathVariable("id") BigInteger id) throws Exception{
		return ResponseEntity.ok(topicoService.deletaPorId(id));
	}
}
