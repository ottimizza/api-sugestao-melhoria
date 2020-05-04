package br.com.ottimizza.sugestaomelhoria.services;

import java.math.BigInteger;
import java.util.Optional;

import javax.inject.Inject;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import br.com.ottimizza.sugestaomelhoria.domain.dtos.ComentarioDTO;
import br.com.ottimizza.sugestaomelhoria.models.Comentario;
import br.com.ottimizza.sugestaomelhoria.repositories.comentario.ComentarioRepository;

@Service
public class ComentarioService {

	@Inject
	ComentarioRepository repository;

	public Comentario save(Comentario comentario) throws Exception {
		return repository.save(comentario);
	}

	public Optional<Comentario> buscaPorId(BigInteger id) throws Exception {
		return repository.findById(id);
	}

	public Page<Comentario> buscaPorFiltro(ComentarioDTO filtro, int pageIndex, int pageSize, String authorization) throws Exception {
		return repository.fetchAll(filtro,  PageRequest.of(pageIndex, pageSize));
	}
	
	public String deletaPorId(BigInteger id) throws Exception {
		try{
			repository.deleteById(id);
		}
		catch(Exception ex){
			ex.getMessage();
		}
		return "Comentario apagado com sucesso!";
	}

}
