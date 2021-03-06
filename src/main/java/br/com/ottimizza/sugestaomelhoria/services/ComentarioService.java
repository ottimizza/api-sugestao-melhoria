package br.com.ottimizza.sugestaomelhoria.services;

import java.math.BigInteger;
import java.util.Optional;

import javax.inject.Inject;

import org.json.JSONObject;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import br.com.ottimizza.sugestaomelhoria.domain.criterias.PageCriteria;
import br.com.ottimizza.sugestaomelhoria.domain.dtos.ComentarioDTO;
import br.com.ottimizza.sugestaomelhoria.models.Comentario;
import br.com.ottimizza.sugestaomelhoria.models.Sugestao;
import br.com.ottimizza.sugestaomelhoria.repositories.comentario.ComentarioRepository;
import br.com.ottimizza.sugestaomelhoria.repositories.sugestao.SugestaoRepository;

@Service
public class ComentarioService {

	@Inject
	ComentarioRepository repository;
	
	@Inject
	SugestaoRepository sugestaoRepository;

	public Comentario save(Comentario comentario) throws Exception {
		Sugestao sugestao = sugestaoRepository.findById(comentario.getSugestaoId()).get();
		Short numComentario = sugestao.getNumeroComentarios();
		sugestao.setNumeroComentarios((short) (numComentario+1));
		sugestaoRepository.save(sugestao);
		return repository.save(comentario);
	}

	public Optional<Comentario> buscaPorId(BigInteger id) throws Exception {
		return repository.findById(id);
	}

	public Page<Comentario> buscaPorFiltro(ComentarioDTO filtro, PageCriteria  pageCriteria) throws Exception {
		return repository.fetchAll(filtro,  PageCriteria.getPageRequest(pageCriteria));
	}
	
	public JSONObject deletaPorId(BigInteger id) throws Exception {
		JSONObject response = new JSONObject();
		try{
			Comentario comentario = repository.findById(id).get();
			Sugestao sugestao = sugestaoRepository.findById(comentario.getSugestaoId()).get();
			Short numComentario = sugestao.getNumeroComentarios();
			sugestao.setNumeroComentarios((short) (numComentario - 1));
			sugestaoRepository.save(sugestao);
			repository.deleteById(id);
			response.put("status", "sucess");
            response.put("message", "Comentario excluido com sucesso!");
		}
		catch(Exception ex){
			ex.getMessage();
			response.put("status", "Error");
            response.put("message", "Houve um problema ao excluir!");
		}
		return response;
	}

}
