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
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ottimizza.sugestaomelhoria.domain.criterias.PageCriteria;
import br.com.ottimizza.sugestaomelhoria.domain.dtos.VotoDTO;
import br.com.ottimizza.sugestaomelhoria.domain.responses.GenericPageableResponse;
import br.com.ottimizza.sugestaomelhoria.models.Voto;
import br.com.ottimizza.sugestaomelhoria.services.SugestaoService;
import br.com.ottimizza.sugestaomelhoria.services.VotoService;

@RestController
@RequestMapping("/api/voto")
public class VotoController {

	@Inject
	VotoService votoService;
	
	@Inject
	SugestaoService sugestaoService;

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
									  @Valid PageCriteria pageCriteria,
									  @RequestHeader("Authorization") String authorization) throws Exception {
		return ResponseEntity.ok(new GenericPageableResponse<Voto>(votoService.buscaPorFiltro(filtro, pageCriteria, authorization)));
	}
	
	@GetMapping("{id}")
	public ResponseEntity<?> findById(@PathVariable("id")BigInteger id) throws Exception {
		return ResponseEntity.ok(votoService.buscaPorId(id));
	}
	
	@DeleteMapping("/{idSugestao}/{idUsuario}")
	public ResponseEntity<?> deleteVotoPorUserId(@PathVariable("idUsuario") BigInteger idUsuario, @PathVariable("idSugestao") BigInteger sugestaoId) throws Exception {
		return ResponseEntity.ok(votoService.deletePorUserId(idUsuario, sugestaoId));
	}
}
