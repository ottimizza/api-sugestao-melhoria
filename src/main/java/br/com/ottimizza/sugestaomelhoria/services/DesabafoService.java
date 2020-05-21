package br.com.ottimizza.sugestaomelhoria.services;

import java.math.BigInteger;
import java.util.Optional;

import javax.inject.Inject;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import br.com.ottimizza.sugestaomelhoria.domain.criterias.PageCriteria;
import br.com.ottimizza.sugestaomelhoria.domain.dtos.DesabafoDTO;
import br.com.ottimizza.sugestaomelhoria.models.Desabafo;
import br.com.ottimizza.sugestaomelhoria.repositories.desabafo.DesabafoRepository;

@Service
public class DesabafoService {

	@Inject
	private DesabafoRepository repository;
	
	
	public Desabafo salva(Desabafo desabafo) throws Exception{
		return repository.save(desabafo);
	}
	
	public Optional<Desabafo> buscaPorId(BigInteger desabafoId) throws Exception{
		return repository.findById(desabafoId);
	}
	
	public Page<Desabafo> buscaPorFiltro(DesabafoDTO filtro, PageCriteria pageCriteria, String auhtorization) throws Exception{
		return repository.fetchAll(filtro, PageCriteria.getPageRequest(pageCriteria));
	}
	
	public String deletaPorId(BigInteger desabafoId) throws Exception{
		try{
			repository.deleteById(desabafoId);
		}catch(Exception ex) {
			ex.getMessage();
		}
		return "Apagado com sucesso";
	}
}
