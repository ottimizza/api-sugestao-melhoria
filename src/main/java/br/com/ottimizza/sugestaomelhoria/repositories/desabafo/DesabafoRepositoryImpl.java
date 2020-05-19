package br.com.ottimizza.sugestaomelhoria.repositories.desabafo;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import com.querydsl.jpa.impl.JPAQuery;

import br.com.ottimizza.sugestaomelhoria.domain.dtos.DesabafoDTO;
import br.com.ottimizza.sugestaomelhoria.models.Desabafo;
import br.com.ottimizza.sugestaomelhoria.models.QDesabafo;

public class DesabafoRepositoryImpl implements DesabafoRepositoryCustom{

	@PersistenceContext
	private EntityManager em;
	
	QDesabafo desabafo = QDesabafo.desabafo;
	
	@Override
	public Page<Desabafo> fetchAll(DesabafoDTO filter, Pageable pageable) {
		long totalElements = 0;
		JPAQuery<Desabafo> query = new JPAQuery<Desabafo>(em).from(desabafo);
		
		if(filter.getId() != null) query.where(desabafo.id.eq(filter.getId()));
		if(filter.getTexto() != null && filter.getTexto() != "") {
			query.where(desabafo.texto.contains(filter.getTexto()));
		}
		if(filter.getTopicoId() != null) query.where(desabafo.topicoId.eq(filter.getTopicoId()));
		if(filter.getUsuario() != null && filter.getUsuario() != "") {
			query.where(desabafo.usuario.eq(filter.getUsuario()));
		}
		if(filter.getDataCriacao() != null) {
			query.where(desabafo.dataCriacao.eq(filter.getDataCriacao()));
		}
		if(filter.getDataAtualizacao() != null) {
			query.where(desabafo.dataAtualizacao.eq(filter.getDataAtualizacao()));
		}
		totalElements = query.fetchCount();
		
		return new PageImpl<Desabafo>(query.fetch(), pageable, totalElements);
	}

}
