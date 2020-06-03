package br.com.ottimizza.sugestaomelhoria.repositories.sugestao;

import org.springframework.data.domain.Page;

import br.com.ottimizza.sugestaomelhoria.domain.criterias.PageCriteria;
import br.com.ottimizza.sugestaomelhoria.domain.dtos.SugestaoDTO;

public interface SugestaoRepositoryCustom { //SugestaoRepositoryImpl

    Page<SugestaoDTO> fetchAll(SugestaoDTO filter, PageCriteria pageCriteria);
    
    
}