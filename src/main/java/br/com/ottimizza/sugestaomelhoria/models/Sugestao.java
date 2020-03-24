package br.com.ottimizza.sugestaomelhoria.models;

import java.math.BigInteger;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "sugestoes")
@Getter
@Setter
@Builder
@NoArgsConstructor @AllArgsConstructor
public class Sugestao {

	@Id
	@Column(name = "id", nullable = false)
	@SequenceGenerator(name = "sugestao_sequence", sequenceName = "sugestao_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sugestao_sequence")
	private BigInteger id;
	
	@Column(name = "fk_topicos_id" , nullable = false)
	private BigInteger topicoId;
	
	@Column(name = "data_criacao")
	private LocalDate dataCriacao;
	
	@Column(name = "data_atualizacao")
	private LocalDate dataAtualizacao;
	
	@Column(name = "usuario", nullable = false)
	private String usuario;
	
	@Column(name = "titulo", nullable = false)
	private String titulo;
	
	@Column(name = "descricao_sugestao", nullable = false)
	private String descricaoSugestao;
	
	@Column(name = "problema_resolvido", nullable = false)
	private String problemaResolvido;
	
	@Column(name = "resultado_suporte")
	private Short resultadoSuporte;

	@Column(name = "resultado_produtividade")
	private Short resultadoProdutividade;
	
	@Column(name = "resultado_automacao")
	private Short resultadoAutomacao;
	
	@Column(name = "status", nullable = false)
	private Short status;
	
	@Column(name = "numero_comentarios")
	private Short numeroComentarios;
	
	@Column(name = "numero_likes")
	private Short numeroLikes;
	
	@Column(name = "numero_dislikes")
	private Short numeroDislikes;
	
	public static class Status{
		
		public static final int ABERTO = 1;
		
		public static final int ARQUIVADO = 2;
		
		public static final int APROVADO = 3;
	}
	
	@PrePersist
    @PreUpdate
    public void preUpdate() {
        if (this.dataCriacao == null) {
            this.dataCriacao = LocalDate.now();
        }      
        this.dataAtualizacao = LocalDate.now();
    }
}
