package br.com.ottimizza.sugestaomelhoria.repositories.topico;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.ottimizza.sugestaomelhoria.domain.dtos.TopicoDTO;
import br.com.ottimizza.sugestaomelhoria.models.Topico;

public interface TopicoRepositoryCustom {

	Page<Topico> featchAll(TopicoDTO filtro, Pageable pageable); 
}

