package br.com.ottimizza.sugestaomelhoria.services;

import java.math.BigInteger;
import java.util.Optional;

import javax.inject.Inject;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import br.com.ottimizza.sugestaomelhoria.domain.criterias.PageCriteria;
import br.com.ottimizza.sugestaomelhoria.domain.dtos.VotoDTO;
import br.com.ottimizza.sugestaomelhoria.models.Voto;
import br.com.ottimizza.sugestaomelhoria.repositories.voto.VotoRepository;

@Service
public class VotoService {

	@Inject
	VotoRepository repository;
	
	public Voto salva(Voto voto) throws Exception {
		
		
		return repository.save(voto);
	}
	
	public Optional<Voto> buscaPorId(BigInteger id) throws Exception {
		return repository.findById(id);
	}
	
	public Page<Voto> buscaPorFiltro(VotoDTO filtro, PageCriteria pageCriteria, String authorization) throws Exception {
		return repository.fetchAll(filtro, PageCriteria.getPageRequest(pageCriteria));
	}
	
	public String deletePorId(BigInteger id) throws Exception {
		try {
			repository.deleteById(id);
		}
		catch(Exception ex) {
			ex.getMessage();
		}
		return "Voto apagado com sucesso!";
	}
	
	public String deletePorUserId(BigInteger userId) throws Exception {
		try {
			repository.deletePorUserId(userId);
		}catch(Exception ex) {
			ex.getMessage();
		}
		return "Voto apagado com sucesso!";
	}
}
