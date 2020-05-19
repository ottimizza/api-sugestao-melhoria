package br.com.ottimizza.sugestaomelhoria.services;

import java.math.BigInteger;
import java.util.Optional;

import javax.inject.Inject;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.ottimizza.sugestaomelhoria.domain.criterias.PageCriteria;
import br.com.ottimizza.sugestaomelhoria.domain.dtos.SugestaoDTO;
import br.com.ottimizza.sugestaomelhoria.domain.mappers.SugestaoMapper;
import br.com.ottimizza.sugestaomelhoria.models.Sugestao;
import br.com.ottimizza.sugestaomelhoria.repositories.sugestao.SugestaoRepository;

@Service
public class SugestaoService {

    @Inject
    private SugestaoRepository repository;

    public SugestaoDTO salva(SugestaoDTO sugestaoDto) throws Exception{
    	Sugestao sugestao = SugestaoMapper.fromDto(sugestaoDto);
        return SugestaoMapper.fromEntity(repository.save(sugestao));
    }

    public Optional<Sugestao> buscaPorId(BigInteger sugestaoId) throws Exception{
        return repository.findById(sugestaoId);
    }

    public Page<Sugestao> buscaPorFiltro(SugestaoDTO filtro, PageCriteria pageCriteria, String authorization) throws Exception{
        return repository.fetchAll(filtro, PageCriteria.getPageRequest(pageCriteria));
    }

    public String deletaPorId(BigInteger sugestaoId) throws Exception{
        try{
            repository.deleteById(sugestaoId);
        }catch(Exception e){
            e.getMessage();
        }
        return "Apagado com sucesso";
    }

}