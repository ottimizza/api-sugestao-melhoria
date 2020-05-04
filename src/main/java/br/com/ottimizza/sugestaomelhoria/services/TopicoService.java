package br.com.ottimizza.sugestaomelhoria.services;

import java.math.BigInteger;
import java.util.Optional;

import javax.inject.Inject;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

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
	
	public Page<Topico> buscaPorFiltro(TopicoDTO filtro, int pageIndex, int pageSize,String authorization) throws Exception {
		return topicoRepository.featchAll(filtro, PageRequest.of(pageIndex, pageSize));
	}
	
	public String deletaPorId(BigInteger id) throws Exception {
		try{
			topicoRepository.deleteById(id);
		}
		catch(Exception ex) {
			ex.getMessage();
		}
		return "Apagado com sucesso";
	}
	
}
