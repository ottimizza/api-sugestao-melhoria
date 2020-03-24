package br.com.ottimizza.sugestaomelhoria.domain.dtos;

import java.math.BigInteger;
import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor @AllArgsConstructor
public class VotoDTO {

	private BigInteger id;

	private BigInteger sugestaoId;

	private String usuario;

	private LocalDate dataCriacao;

	private LocalDate dataAtualizacao;

	private String comentario;

	private Boolean aprovado;

	private Short resultadoSuporte;

	private Short resultadoProdutividade;

	private Short resultadoAutomacao;

}
