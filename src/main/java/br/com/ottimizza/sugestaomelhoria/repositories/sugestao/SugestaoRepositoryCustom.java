package br.com.ottimizza.sugestaomelhoria.repositories.sugestao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.ottimizza.sugestaomelhoria.domain.dtos.SugestaoDTO;
import br.com.ottimizza.sugestaomelhoria.models.Sugestao;

public interface SugestaoRepositoryCustom { //SugestaoRepositoryImpl

    Page<Sugestao> fetchAll(SugestaoDTO filter, Pageable pageable);
    
    
}