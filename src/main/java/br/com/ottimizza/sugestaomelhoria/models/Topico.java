package br.com.ottimizza.sugestaomelhoria.models;

import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "topicos")
@Data
@Builder
@NoArgsConstructor @AllArgsConstructor
public class Topico {

	@Id
	@Column(name = "id", nullable = false)
	@SequenceGenerator(name = "topicos_sequence", sequenceName = "topicos_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "topicos_sequence")
	private BigInteger id;
	
	@Column(name = "nome", nullable = false, length = 255)
	private String nome;
	
	@Column(name = "ativo",  columnDefinition = "boolean default true")
	private Boolean ativo;
}
