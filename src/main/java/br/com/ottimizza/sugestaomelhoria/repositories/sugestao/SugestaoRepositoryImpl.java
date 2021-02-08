package br.com.ottimizza.sugestaomelhoria.repositories.sugestao;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

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
    public PageImpl<SugestaoDTO> fetchAll(SugestaoDTO filter, PageCriteria criteria) {
        long totalElements = 0;
        StringBuilder sql = new StringBuilder();
		
        sql.append("SELECT s.* 				");
        sql.append("FROM sugestoes s		");
        sql.append("WHERE s.fk_topicos_id = :topicoId ");
        
		if(filter.getId() != null)										
			sql.append("AND s.id = :id ");
        if(filter.getDataCriacao() != null)  
        	sql.append("AND s.data_criacao = :dataCriacao ");
        if(filter.getDataAtualizacao() != null)                         
        	sql.append("AND s.data_atualizacao = :dataAtualizacao ");
        if(filter.getUsuario() != null && !filter.getUsuario().equals(""))   
        	sql.append("AND s.usuario ILIKE(:usuario) ");
        if(filter.getTitulo() != null && !filter.getTitulo().equals(""))    
        	sql.append("AND s.titulo ILIKE(:titulo) ");
        if(filter.getDescricaoSugestao() != null && !filter.getDescricaoSugestao().equals(""))     
        	sql.append("AND s.descricao_sugestao ILIKE(% :descricaoSugestao %) ");
        if(filter.getProblemaResolvido() != null && !filter.getProblemaResolvido().equals(""))    
        	sql.append("AND s.problema_resolvido ILIKE(% :problemaResolvido %) ");
        if(filter.getStatus() != null)         
        	sql.append("AND s.status = :status ");
        if(filter.getNumeroComentarios() != null)      
        	sql.append("AND s.numero_comentarios >= :numeroComentarios ");
        if(filter.getNumeroLikes() != null)                   
        	sql.append("AND s.numero_likes >= :numeroLikes ");
        if(filter.getNumeroDislikes() != null)                
        	sql.append("AND s.numero_dislikes >= :numeroDislikes ");
        if(filter.getLidaPorTareffa() != null)
        	sql.append("AND s.lida_por_tareffa = :lidaPorTareffa ");
        
        if(filter.getOrderBy() != null && filter.getOrderBy() == 0)
        	sql.append("ORDER BY s.data_criacao DESC ");
        else if(filter.getOrderBy() != null && filter.getOrderBy() == 1)
        	sql.append("ORDER BY s.data_atualizacao DESC ");
        else if(filter.getOrderBy() != null && filter.getOrderBy() == 2)
        	sql.append("ORDER BY s.numero_comentarios DESC ");
        else
        	sql.append("ORDER BY s.numero_likes DESC ");
        	
        Query query = em.createNativeQuery(sql.toString(), Sugestao.class);

        query.setParameter("topicoId", filter.getTopicoId());
        
        if(filter.getId() != null)										
        	query.setParameter("id", filter.getId());
        
        if(filter.getDataCriacao() != null)  
        	query.setParameter("dataCriacao", filter.getDataCriacao());
        
        if(filter.getDataAtualizacao() != null)                      
        	query.setParameter("dataAtualizacao", filter.getDataAtualizacao());
        
        if(filter.getUsuario() != null && !filter.getUsuario().equals(""))   
        	query.setParameter("usuario", "%"+filter.getUsuario()+"%");
        
        if(filter.getTitulo() != null && !filter.getTitulo().equals(""))  
        	query.setParameter("titulo", "%"+filter.getTitulo()+"%");
        
        if(filter.getDescricaoSugestao() != null && !filter.getDescricaoSugestao().equals("")) 
        	query.setParameter("descricaoSugestao", filter.getDescricaoSugestao());
        
        if(filter.getProblemaResolvido() != null && !filter.getProblemaResolvido().equals("")) 
        	query.setParameter("problemaResolvido", filter.getProblemaResolvido());
        
        if(filter.getStatus() != null)         
        	query.setParameter("status", filter.getStatus());
        
        if(filter.getNumeroComentarios() != null)      
        	query.setParameter("numeroComentarios", filter.getNumeroComentarios());
        
        if(filter.getNumeroLikes() != null)           
        	query.setParameter("numeroLikes", filter.getNumeroLikes());
        
        if(filter.getNumeroDislikes() != null)      
        	query.setParameter("numeroDislikes", filter.getNumeroDislikes());
        
        if(filter.getLidaPorTareffa() != null)
        	query.setParameter("lidaPorTareffa", filter.getLidaPorTareffa());
        
        totalElements = query.getResultList().size();
		query.setFirstResult(criteria.getPageIndex() * criteria.getPageSize());
		query.setMaxResults(criteria.getPageSize());
		
		List<Sugestao> resultados = query.getResultList();
		
		List<SugestaoDTO> sugestoes = resultados.stream().map(SugestaoMapper::fromEntity).collect(Collectors.toCollection(ArrayList::new));
		try{
    		for(SugestaoDTO sugestao : sugestoes) {
    			Boolean deuLike = votoRepository.findByUserIdAndSugestaoId(filter.getUserId(), sugestao.getId());
    			if(deuLike == true) {
    				sugestao.setDeuLike(true);
    				sugestao.setDeuDislike(false);
    			}
    			else if(deuLike == false){
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
		return new PageImpl<SugestaoDTO>(sugestoes, PageCriteria.getPageRequest(criteria), totalElements);
	}


}