package br.com.ottimizza.sugestaomelhoria.models;

import java.math.BigInteger;
import java.time.LocalDate;
import java.util.Date;

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
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "desabafos")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Desabafo {

	@Id
	@Column(name = "id", nullable = false)
	@SequenceGenerator(name = "desabafos_sequence", sequenceName = "desabafos_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "desabafos_sequence")
	private BigInteger id;
	
	@Column(name = "fk_topicos_id" , nullable = false)
	private BigInteger topicoId;
	
	@Column(name = "texto", nullable = false)
	private String texto;
	
	@Column(name = "data_criacao")
	private LocalDate dataCriacao;
	
	@Column(name = "data_atualizacao")
	private LocalDate dataAtualizacao;
	
	@Column(name = "user_id", nullable = false)
	private BigInteger userId;

	@Column(name = "usuario", nullable = false)
	private String usuario;
	
	@Column(name = "data_retorno_cliente")
	private LocalDate dataRetornoCliente;
	
	@PrePersist
    @PreUpdate
    public void preUpdate() {
        if (this.dataCriacao == null) {
            this.dataCriacao = LocalDate.now();
        }      
        this.dataAtualizacao = LocalDate.now();
    }
}
