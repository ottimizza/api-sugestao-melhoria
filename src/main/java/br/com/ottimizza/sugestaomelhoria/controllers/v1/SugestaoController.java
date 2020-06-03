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
import br.com.ottimizza.sugestaomelhoria.domain.dtos.SugestaoDTO;
import br.com.ottimizza.sugestaomelhoria.domain.responses.GenericPageableResponse;
import br.com.ottimizza.sugestaomelhoria.models.Sugestao;
import br.com.ottimizza.sugestaomelhoria.services.SugestaoService;

@RestController
@RequestMapping("/api/sugestao")
public class SugestaoController {
    
    @Inject
    SugestaoService sugestaoService;

    @PostMapping
    public ResponseEntity<?> saveSugestao(@RequestBody SugestaoDTO sugestao) throws Exception{
        return ResponseEntity.ok(sugestaoService.salva(sugestao));
    }   

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletaSugestao(@PathVariable("id") BigInteger id) throws Exception{
        return ResponseEntity.ok(sugestaoService.deletaPorId(id).toString());
    }

    @GetMapping("/{id}")
	public ResponseEntity<?> findSugestao(@PathVariable("id") BigInteger id) throws Exception{
		return ResponseEntity.ok(sugestaoService.buscaPorId(id));
    }
    
    @GetMapping
    public ResponseEntity<?> fetchAll(@Valid SugestaoDTO filtro,
    		 						  @Valid PageCriteria pageCriteria, 
                                      @RequestHeader("Authorization") String authorization) throws Exception{
        return ResponseEntity.ok(new GenericPageableResponse<SugestaoDTO>(sugestaoService.buscaPorFiltro(filtro, pageCriteria, authorization)));
    }

}