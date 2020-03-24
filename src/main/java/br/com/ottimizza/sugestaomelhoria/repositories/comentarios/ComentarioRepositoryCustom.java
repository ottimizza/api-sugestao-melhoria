package br.com.ottimizza.sugestaomelhoria.repositories.comentarios;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.ottimizza.sugestaomelhoria.domain.dtos.ComentarioDTO;
import br.com.ottimizza.sugestaomelhoria.models.Comentario;

public interface ComentarioRepositoryCustom {

	Page<Comentario> fetchAll(ComentarioDTO filtro , Pageable pageable);
}
