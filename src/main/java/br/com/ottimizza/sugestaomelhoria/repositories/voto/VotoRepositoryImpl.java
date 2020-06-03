package br.com.ottimizza.sugestaomelhoria.repositories.voto;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import com.querydsl.jpa.impl.JPAQuery;

import br.com.ottimizza.sugestaomelhoria.domain.dtos.VotoDTO;
import br.com.ottimizza.sugestaomelhoria.models.QVoto;
import br.com.ottimizza.sugestaomelhoria.models.Voto;

public class VotoRepositoryImpl implements VotoRepositoryCustom{

	@PersistenceContext
	EntityManager em;
	
	QVoto voto = QVoto.voto;
	
	@Override
	public Page<Voto> fetchAll(VotoDTO filtro, Pageable pageable) {
		long totalElements = 0;
		JPAQuery<Voto> query = new JPAQuery<Voto>(em).from(voto);
		if(filtro.getId() != null)
			query.where(voto.id.eq(filtro.getId()));
		if(filtro.getSugestaoId() != null)
			query.where(voto.sugestaoId.eq(filtro.getSugestaoId()));
		if(filtro.getUserId() != null) 
			query.where(voto.userId.eq(filtro.getUserId()));
		if(filtro.getUsuario() != null && filtro.getUsuario() != "")
			query.where(voto.usuario.eq(filtro.getUsuario()));
		if(filtro.getDataCriacao() != null)
			query.where(voto.dataCriacao.eq(filtro.getDataCriacao()));
		if(filtro.getDataAtualizacao() != null)
			query.where(voto.dataAtualizacao.eq(filtro.getDataAtualizacao()));
		if(filtro.getComentario() != null && filtro.getComentario() != "")
			query.where(voto.comentario.containsIgnoreCase(filtro.getComentario()));
		if(filtro.getAprovado() != null)
			query.where(voto.aprovado.eq(filtro.getAprovado()));
		if(filtro.getResultadoSuporte() != null) 
			query.where(voto.resultadoSuporte.eq(filtro.getResultadoSuporte()));
		if(filtro.getResultadoProdutividade() != null)
			query.where(voto.resultadoProdutividade.eq(filtro.getResultadoProdutividade()));
		if(filtro.getResultadoAutomacao() != null)
			query.where(voto.resultadoAutomacao.eq(filtro.getResultadoAutomacao()));
		
		totalElements = query.fetchCount();
		query.limit(pageable.getPageSize());
		query.offset(pageable.getPageSize() * pageable.getPageNumber());
		
		return new PageImpl<Voto>(query.fetch(), pageable, totalElements);
	}

}
