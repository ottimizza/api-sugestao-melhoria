package br.com.ottimizza.sugestaomelhoria.services;

import java.math.BigInteger;
import java.util.Optional;

import javax.inject.Inject;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import br.com.ottimizza.sugestaomelhoria.domain.criterias.PageCriteria;
import br.com.ottimizza.sugestaomelhoria.domain.dtos.VotoDTO;
import br.com.ottimizza.sugestaomelhoria.models.Sugestao;
import br.com.ottimizza.sugestaomelhoria.models.Voto;
import br.com.ottimizza.sugestaomelhoria.repositories.sugestao.SugestaoRepository;
import br.com.ottimizza.sugestaomelhoria.repositories.voto.VotoRepository;

@Service
public class VotoService {

	@Inject
	VotoRepository repository;
	
	@Inject
	SugestaoRepository sugestaoRepository;
	
	public Voto salva(Voto voto) throws Exception {
		Sugestao sugestao = sugestaoRepository.findById(voto.getSugestaoId()).get();
		Short numLikes = sugestao.getNumeroLikes();
		Short numDislikes = sugestao.getNumeroDislikes();
		if(voto.getAprovado() == true) {
			numLikes = (short) (numLikes + 1);
			sugestao.setNumeroLikes(numLikes);
			sugestaoRepository.save(sugestao);
		}
		else {
			numDislikes = (short) (numDislikes + 1);
			sugestao.setNumeroDislikes(numDislikes);
			sugestaoRepository.save(sugestao);
		}
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
			Voto voto = repository.findById(id).get();
			Sugestao sugestao = sugestaoRepository.findById(voto.getSugestaoId()).get();
			Short numLikes = sugestao.getNumeroLikes();
			Short numDislikes = sugestao.getNumeroDislikes();
			if(voto.getAprovado() == true) {
				sugestao.setNumeroLikes((short) (numLikes - 1));
				sugestaoRepository.save(sugestao);
			}
			else {
				sugestao.setNumeroDislikes((short) (numDislikes - 1));
				sugestaoRepository.save(sugestao);
			}
			repository.deleteById(id);
		}
		catch(Exception ex) {
			ex.getMessage();
		}
		return "Voto apagado com sucesso!";
	}
	
	public String deletePorUserId(BigInteger userId, BigInteger sugestaoId) throws Exception {
		try {
			Voto voto = repository.findVotoByUserIdAndSugestaoId(userId, sugestaoId);
			Sugestao sugestao = sugestaoRepository.findById(sugestaoId).get();
			Short numLikes 	  = sugestao.getNumeroLikes();
			Short numDislikes = sugestao.getNumeroDislikes();
			if(voto.getAprovado() == true) {
				sugestao.setNumeroLikes((short) (numLikes - 1));
				sugestaoRepository.save(sugestao);
			}
			else {
				sugestao.setNumeroDislikes((short) (numDislikes - 1));
				sugestaoRepository.save(sugestao);
			}
			repository.deleteById(voto.getId());
		}catch(Exception ex) {
			ex.getMessage();
		}
		return "Voto apagado com sucesso!";
	}
}
