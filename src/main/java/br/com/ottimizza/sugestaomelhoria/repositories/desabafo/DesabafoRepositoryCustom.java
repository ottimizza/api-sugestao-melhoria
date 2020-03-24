package br.com.ottimizza.sugestaomelhoria.repositories.desabafo;

import java.security.Principal;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.ottimizza.sugestaomelhoria.domain.dtos.DesabafoDTO;
import br.com.ottimizza.sugestaomelhoria.models.Desabafo;

public interface DesabafoRepositoryCustom {

	Page<Desabafo> fetchAll(DesabafoDTO filter, Pageable pageable);
}
