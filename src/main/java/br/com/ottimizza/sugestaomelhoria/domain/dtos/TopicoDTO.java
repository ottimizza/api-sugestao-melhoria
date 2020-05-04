package br.com.ottimizza.sugestaomelhoria.domain.dtos;

import java.math.BigInteger;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor @AllArgsConstructor
@Builder
public class TopicoDTO {
 

	private BigInteger id;
	
	private String nome;
	
	private Boolean ativo;
}
