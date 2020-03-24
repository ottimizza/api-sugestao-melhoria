package br.com.ottimizza.sugestaomelhoria.repositories.voto;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.ottimizza.sugestaomelhoria.domain.dtos.VotoDTO;
import br.com.ottimizza.sugestaomelhoria.models.Voto;

public interface VotoRepositoryCustom {

	public Page<Voto> fetchAll(VotoDTO filtro, Pageable pageable);
	
}
