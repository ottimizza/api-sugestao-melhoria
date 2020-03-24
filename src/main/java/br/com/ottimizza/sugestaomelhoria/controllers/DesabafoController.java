package br.com.ottimizza.sugestaomelhoria.controllers;

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

import br.com.ottimizza.sugestaomelhoria.domain.dtos.DesabafoDTO;
import br.com.ottimizza.sugestaomelhoria.models.Desabafo;
import br.com.ottimizza.sugestaomelhoria.services.DesabafoService;

@RestController
@RequestMapping("/desabafo")
public class DesabafoController {

	@Inject
	DesabafoService desabafoService;
	
	@PostMapping
	public ResponseEntity<Desabafo> saveDesabafo(@RequestBody Desabafo desabafo) throws Exception {
		return ResponseEntity.ok(desabafoService.salva(desabafo));
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteDesabafo(@PathVariable("id") BigInteger id) throws Exception {
		return ResponseEntity.ok(desabafoService.deletaPorId(id));
	}
	
	@GetMapping
	public ResponseEntity<?> findDesabafo(@Valid DesabafoDTO filtro, 
										  @RequestParam(name = "page_index", defaultValue = "0") int pageIndex, 
										  @RequestParam(name = "page_size", defaultValue = "10") int pageSize, 
										  @RequestHeader("Authorization") String authorization) throws Exception{
		return ResponseEntity.ok(desabafoService.buscaPorFiltro(filtro, pageIndex, pageSize, authorization));
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Optional<Desabafo>> findById(@PathVariable("id") BigInteger id) throws Exception {
		return ResponseEntity.ok(desabafoService.buscaPorId(id));
	}
	
	
	
	
}
