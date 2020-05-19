package br.com.ottimizza.sugestaomelhoria.repositories.topico;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import com.querydsl.jpa.impl.JPAQuery;

import br.com.ottimizza.sugestaomelhoria.domain.dtos.TopicoDTO;
import br.com.ottimizza.sugestaomelhoria.models.QTopico;
import br.com.ottimizza.sugestaomelhoria.models.Topico;

public class TopicoRepositoryImpl implements TopicoRepositoryCustom {

	@PersistenceContext
	private EntityManager em;

	QTopico topico = QTopico.topico;

	@Override
	public Page<Topico> featchAll(TopicoDTO filtro, Pageable pageable) {
		long totalElements = 0;

		JPAQuery<Topico> query = new JPAQuery<Topico>(em).from(topico);

		if (filtro.getId() != null) {
			query.where(topico.id.eq(filtro.getId()));
		}
		if (filtro.getNome() != null && filtro.getNome() != "") {
			query.where(topico.nome.contains(filtro.getNome()));
		}
		if (filtro.getAtivo() != null) {
			query.where(topico.ativo.eq(filtro.getAtivo()));
		}

		totalElements = query.fetchCount();
		return new PageImpl<Topico>(query.fetch(), pageable, totalElements);
	}

}
