package br.com.ottimizza.sugestaomelhoria.services;

import java.math.BigInteger;
import java.util.Optional;

import javax.inject.Inject;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

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
	
	public Page<Voto> buscaPorFiltro(VotoDTO filtro, int pageIndex, int pageSize, String authorization) throws Exception {
		return repository.fetchAll(filtro, PageRequest.of(pageIndex, pageSize));
	}
	
	public String deletePorId(BigInteger id) throws Exception {
		try {
			repository.deleteById(id);
		}
		catch(Exception ex) {
			ex.getMessage();
		}
		return "Voto apagado com sucesso";
	}
}
