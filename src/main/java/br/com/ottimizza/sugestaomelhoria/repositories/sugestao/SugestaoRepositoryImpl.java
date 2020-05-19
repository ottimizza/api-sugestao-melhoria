package br.com.ottimizza.sugestaomelhoria.repositories.sugestao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.querydsl.jpa.impl.JPAQuery;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import br.com.ottimizza.sugestaomelhoria.domain.dtos.SugestaoDTO;
import br.com.ottimizza.sugestaomelhoria.models.QSugestao;
import br.com.ottimizza.sugestaomelhoria.models.Sugestao;

public class SugestaoRepositoryImpl implements SugestaoRepositoryCustom {

    @PersistenceContext
    private EntityManager em;

    QSugestao sugestao = QSugestao.sugestao;
    
    @Override
    public Page<Sugestao> fetchAll(SugestaoDTO filter, Pageable pageable) {
        long totalElements = 0;
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

		totalElements = query.fetchCount();
		query.limit(pageable.getPageSize());
		query.offset(pageable.getPageSize() * pageable.getPageNumber());
		return new PageImpl<Sugestao>(query.fetch(), pageable, totalElements);
	}


}