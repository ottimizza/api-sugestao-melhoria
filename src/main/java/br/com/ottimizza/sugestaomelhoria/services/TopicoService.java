package br.com.ottimizza.sugestaomelhoria.services;

import java.math.BigInteger;
import java.util.Optional;

import javax.inject.Inject;

import org.json.JSONObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import br.com.ottimizza.sugestaomelhoria.domain.criterias.PageCriteria;
import br.com.ottimizza.sugestaomelhoria.domain.dtos.TopicoDTO;
import br.com.ottimizza.sugestaomelhoria.models.Topico;
import br.com.ottimizza.sugestaomelhoria.repositories.topico.TopicoRepository;

@Service
public class TopicoService {

	
	@Inject
	TopicoRepository topicoRepository;
	
	
	public Topico salva(Topico topico) throws Exception {
		return topicoRepository.save(topico);
	}
	
	public Optional<Topico> buscaPorId(BigInteger id) throws Exception {
		return topicoRepository.findById(id);
	}
	
	public Page<Topico> buscaPorFiltro(TopicoDTO filtro, PageCriteria pageCriteria ,String authorization) throws Exception {
		return topicoRepository.featchAll(filtro, PageCriteria.getPageRequest(pageCriteria));
	}
	
	public JSONObject deletaPorId(BigInteger id) throws Exception {
		JSONObject response = new JSONObject();
		try{
			topicoRepository.deleteById(id);
			response.put("status", "sucess");
            response.put("message", "Topico excluido com sucesso!");
		}
		catch(Exception ex) {
			ex.getMessage();
			response.put("status", "Error");
            response.put("message", "Houve um problema ao excluir!");
		}
		return response;
	}
	
}
