package br.com.ottimizza.sugestaomelhoria.repositories.comentario;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import com.querydsl.jpa.impl.JPAQuery;

import br.com.ottimizza.sugestaomelhoria.domain.dtos.ComentarioDTO;
import br.com.ottimizza.sugestaomelhoria.models.Comentario;
import br.com.ottimizza.sugestaomelhoria.models.QComentario;

public class ComentarioRepositoryImpl implements ComentarioRepositoryCustom{

	@PersistenceContext
	EntityManager em;
	
	QComentario comentario = QComentario.comentario;
	
	@Override
	public Page<Comentario> fetchAll(ComentarioDTO filtro, Pageable pageable) {
		long totalElements = 0;
		JPAQuery<Comentario> query = new JPAQuery<Comentario>(em).from(comentario);
		if(filtro.getId() != null) 
			query.where(comentario.id.eq(filtro.getId()));
		if(filtro.getSugestaoId() != null) 
			query.where(comentario.sugestaoId.eq(filtro.getSugestaoId()));
		if(filtro.getTexto() != null && filtro.getTexto() != "")
			query.where(comentario.texto.contains(filtro.getTexto()));
		if(filtro.getUsuario() != null && filtro.getUsuario() != "")
			query.where(comentario.usuario.eq(filtro.getUsuario()));
		if(filtro.getDataCriacao() != null)
			query.where(comentario.dataCriacao.eq(filtro.getDataCriacao()));
		if(filtro.getDataAtualizacao() != null)
			query.where(comentario.dataAtualizacao.eq(filtro.getDataAtualizacao()));
		
		totalElements = query.fetchCount();
		query.orderBy(comentario.dataCriacao.desc());
		
		return new PageImpl<Comentario>(query.fetch(), pageable, totalElements);
	}

}
