package br.com.ottimizza.sugestaomelhoria.domain.dtos;

import java.math.BigInteger;
import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ComentarioDTO {

	private BigInteger id;

	private BigInteger userId;
	
	private String usuario;

	private BigInteger sugestaoId;

	private LocalDate dataCriacao;

	private LocalDate dataAtualizacao;

	private String texto;


}
