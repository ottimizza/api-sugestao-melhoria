package br.com.ottimizza.sugestaomelhoria.controllers;

import java.math.BigInteger;
import java.util.Optional;

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

import br.com.ottimizza.sugestaomelhoria.domain.dtos.VotoDTO;
import br.com.ottimizza.sugestaomelhoria.models.Voto;
import br.com.ottimizza.sugestaomelhoria.services.VotoService;

@RestController
@RequestMapping("/voto")
public class VotoController {

	@Inject
	VotoService votoService;

	@PostMapping
	public ResponseEntity<?> saveVoto(@RequestBody Voto voto) throws Exception {
		return ResponseEntity.ok(votoService.salva(voto));
	}

	@DeleteMapping("{id}")
	public ResponseEntity<?> deleteVoto(@PathVariable("id") BigInteger id) throws Exception {
		return ResponseEntity.ok(votoService.deletePorId(id));
	}

	@GetMapping
	public ResponseEntity<?> findVoto(@Valid VotoDTO filtro,
									  @RequestParam(name = "page_index", defaultValue = "0") int pageIndex,
									  @RequestParam(name = "page_size", defaultValue = "10") int pageSize,
									  @RequestHeader("Authorization") String authorization) throws Exception {
		return ResponseEntity.ok(votoService.buscaPorFiltro(filtro, pageIndex, pageSize, authorization));
	}
	
	@GetMapping("{id}")
	public ResponseEntity<?> findById(@PathVariable("id")BigInteger id) throws Exception {
		return ResponseEntity.ok(votoService.buscaPorId(id));
	}
}
