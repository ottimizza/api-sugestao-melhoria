package br.com.ottimizza.sugestaomelhoria.services;

import java.math.BigInteger;
import java.util.Optional;

import javax.inject.Inject;

import org.json.JSONObject;
import org.springframework.data.domain.Page;
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
    
    public SugestaoDTO patch(BigInteger id,SugestaoDTO sugestaoDto) throws Exception {
    	Sugestao sugestao = sugestaoDto.patch(repository.findById(id).orElse(null));
    	return (SugestaoMapper.fromEntity(repository.save(sugestao)));
    }

    public Optional<Sugestao> buscaPorId(BigInteger sugestaoId) throws Exception{
        return repository.findById(sugestaoId);
    }

    public Page<SugestaoDTO> buscaPorFiltro(SugestaoDTO filtro, PageCriteria pageCriteria, String authorization) throws Exception{
    	return repository.fetchAll(filtro, pageCriteria);
    }

    public JSONObject deletaPorId(BigInteger sugestaoId) throws Exception{
    	JSONObject response = new JSONObject();
    	try{
            repository.deleteById(sugestaoId);
            response.put("status", "sucess");
            response.put("message", "Sugestao excluida com sucesso!");
        }catch(Exception e){
            e.getMessage();
            response.put("status", "Error");
            response.put("message", "Houve um problema ao excluir!");
        }
        return response;
    }

}