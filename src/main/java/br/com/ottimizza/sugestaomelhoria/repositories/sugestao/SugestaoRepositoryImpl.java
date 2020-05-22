package br.com.ottimizza.sugestaomelhoria.repositories.sugestao;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.querydsl.jpa.impl.JPAQuery;

import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import br.com.ottimizza.sugestaomelhoria.domain.criterias.PageCriteria;
import br.com.ottimizza.sugestaomelhoria.domain.dtos.SugestaoDTO;
import br.com.ottimizza.sugestaomelhoria.domain.mappers.SugestaoMapper;
import br.com.ottimizza.sugestaomelhoria.models.QSugestao;
import br.com.ottimizza.sugestaomelhoria.models.Sugestao;
import br.com.ottimizza.sugestaomelhoria.repositories.voto.VotoRepository;

public class SugestaoRepositoryImpl implements SugestaoRepositoryCustom {

    @PersistenceContext
    private EntityManager em;
    
    @Inject
    private VotoRepository votoRepository;

    QSugestao sugestao = QSugestao.sugestao;
    
    @Override
    public PageImpl<SugestaoDTO> fetchAll(SugestaoDTO filter, PageCriteria pageCriteria) {
        long totalElements = 0;
        Pageable pageable = PageCriteria.getPageRequest(pageCriteria);
        
		JPAQuery<Sugestao> query = new JPAQuery<Sugestao>(em).from(sugestao);
		
		if(filter.getId() != null)                                      query.where(sugestao.id.eq(filter.getId()));
		if(filter.getTopicoId() != null)                                query.where(sugestao.topicoId.eq(filter.getTopicoId()));
        if(filter.getDataCriacao() != null)                             query.where(sugestao.dataCriacao.eq(filter.getDataAtualizacao()));
        if(filter.getDataAtualizacao() != null)                         query.where(sugestao.dataAtualizacao.eq(filter.getDataAtualizacao()));
        if(filter.getUsuario() != null && filter.getUsuario() != "")    query.where(sugestao.usuario.eq(filter.getUsuario()));
        if(filter.getTitulo() != null && filter.getTitulo() != "")      query.where(sugestao.titulo.containsIgnoreCase(filter.getTitulo()));
        if(filter.getDescricaoSugestao() != null)                       query.where(sugestao.descricaoSugestao.containsIgnoreCase(filter.getDescricaoSugestao()));
        if(filter.getProblemaResolvido() != null)                       query.where(sugestao.problemaResolvido.containsIgnoreCase(filter.getProblemaResolvido()));
        if(filter.getResultadoSuporte() != null)                        query.where(sugestao.resultadoSuporte.eq(filter.getResultadoSuporte()));
        if(filter.getResultadoAutomacao() != null)                      query.where(sugestao.resultadoAutomacao.eq(filter.getResultadoAutomacao()));
        if(filter.getStatus() != null)                                  query.where(sugestao.status.eq(filter.getStatus()));
        if(filter.getNumeroComentarios() != null)                       query.where(sugestao.numeroComentarios.eq(filter.getNumeroComentarios()));
        if(filter.getNumeroLikes() != null)                             query.where(sugestao.numeroLikes.eq(filter.getNumeroLikes()));
        if(filter.getNumeroDislikes() != null)                          query.where(sugestao.numeroDislikes.eq(filter.getNumeroDislikes()));
        
        query.orderBy(sugestao.numeroLikes.desc());
        	
		totalElements = query.fetchCount();
		query.limit(pageable.getPageSize());
		query.offset(pageable.getPageSize() * pageable.getPageNumber());
		
		List<SugestaoDTO> sugestoes = query.fetch().stream().map(SugestaoMapper::fromEntity).collect(Collectors.toCollection(ArrayList::new));
		try{
    		for(SugestaoDTO sugestao : sugestoes) {
    			boolean deuLike = votoRepository.findByUserIdAndSugestaoId(filter.getUserId(), sugestao.getId());
    			if(deuLike = true) {
    				sugestao.setDeuLike(true);
    				sugestao.setDeuDislike(false);
    			}
    			else if(deuLike = false){
    				sugestao.setDeuLike(false);
    				sugestao.setDeuDislike(true);
    			}
    			else {
    				sugestao.setDeuLike(false);
    				sugestao.setDeuDislike(false);
    			}
    			}
    	}catch(Exception ex) {
    		ex.getMessage();
    	}
		return new PageImpl<SugestaoDTO>(sugestoes, pageable, totalElements);
	}


}