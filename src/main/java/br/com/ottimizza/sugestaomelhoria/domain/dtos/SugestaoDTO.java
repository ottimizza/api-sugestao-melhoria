package br.com.ottimizza.sugestaomelhoria.domain.dtos;

import java.math.BigInteger;
import java.time.LocalDate;

import br.com.ottimizza.sugestaomelhoria.models.Sugestao;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor @AllArgsConstructor
@Builder
@Getter @Setter
public class SugestaoDTO { 

    private BigInteger id;

    private BigInteger topicoId;

    private LocalDate dataCriacao;

    private LocalDate dataAtualizacao;

    private BigInteger userId;
    
    private String usuario;

    private String titulo;

    private String descricaoSugestao;

    private String problemaResolvido;

    private Short resultadoSuporte;
    
    private Short resultadoAutomacao;
    
    private Short resultadoProdutividade;

    private Short status;

    private Short numeroComentarios;

    private Short numeroLikes;

    private Short numeroDislikes;
    
    private boolean deuLike;
    
    private boolean deuDislike;
    
    private Boolean lidaPorTareffa;

    private Short orderBy;

    public Sugestao patch(Sugestao sugestao) {
    	
    	if(status != null)
    		sugestao.setStatus(status);
    	
    	if(titulo != null && !titulo.equals(""))
    		sugestao.setTitulo(titulo);
    	
    	if(lidaPorTareffa != null)
    		sugestao.setLidaPorTareffa(lidaPorTareffa);
    	
    	return sugestao;
    }
    
}