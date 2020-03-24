package br.com.ottimizza.sugestaomelhoria.domain.dtos;

import java.math.BigInteger;
import java.time.LocalDate;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor @AllArgsConstructor
@Builder
public class DesabafoDTO {

	private BigInteger id;
	
	private BigInteger topicoId;
	
	private String texto;
	
	private LocalDate dataCriacao;
	
	private LocalDate dataAtualizacao;
	
	private String usuario;
	
	private Date dataRetornoCliente;
	
	
}
