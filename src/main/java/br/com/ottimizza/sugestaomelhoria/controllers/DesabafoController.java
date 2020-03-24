package br.com.ottimizza.sugestaomelhoria.controllers;

import java.math.BigInteger;

import javax.inject.Inject;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ottimizza.sugestaomelhoria.domain.dtos.DesabafoDTO;
import br.com.ottimizza.sugestaomelhoria.models.Desabafo;
import br.com.ottimizza.sugestaomelhoria.services.DesabafoService;

@RestController
@RequestMapping("/desabafo")
public class DesabafoController {

	@Inject
	DesabafoService desabafoService;
	
	@PostMapping("/save")
	public ResponseEntity<Desabafo> saveDesabafo(@RequestBody Desabafo desabafo) throws Exception {
		return ResponseEntity.ok(desabafoService.salva(desabafo));
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteDesabafo(@PathVariable("id") BigInteger id) throws Exception {
		return ResponseEntity.ok(desabafoService.deletaPorId(id));
	}
	
	@GetMapping
	public ResponseEntity<?> findDesabafo(DesabafoDTO filtro){
		return null;
	}
	
	
	
}
