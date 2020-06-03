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
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "votos")
@Data
@Builder
@NoArgsConstructor @AllArgsConstructor
public class Voto {

	
	@Id
    @Column(name = "id", nullable = false)
    @SequenceGenerator(name = "votos_sequence", sequenceName = "votos_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "votos_sequence")
    private BigInteger id;
	
	@Column(name = "fk_sugestao_id", nullable = false)
	private BigInteger sugestaoId;
	
	@Column(name = "user_id", nullable = false)
	private BigInteger userId;
	
	@Column(name = "usuario", nullable = false)
	private String usuario;
	
	@Column(name = "data_criacao")
	private LocalDate dataCriacao;
	
	@Column(name = "data_atualizacao")
	private LocalDate dataAtualizacao;
	
	@Column(name = "comentario")
	private String comentario;
	
	@Column(name = "aprovado")
	private Boolean aprovado;
	
	@Column(name = "resultado_suporte")
	private Short resultadoSuporte;
	
	@Column(name = "resultado_produtividade")
	private Short resultadoProdutividade;
	
	@Column(name = "resultado_automacao")
	private Short resultadoAutomacao;
	
	@PrePersist
    @PreUpdate
    public void preUpdate() {
        if (this.dataCriacao == null) {
            this.dataCriacao = LocalDate.now();
        }      
        this.dataAtualizacao = LocalDate.now();
    }
}
