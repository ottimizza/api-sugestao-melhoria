package br.com.ottimizza.sugestaomelhoria.domain.mappers;

import br.com.ottimizza.sugestaomelhoria.domain.dtos.VotoDTO;
import br.com.ottimizza.sugestaomelhoria.models.Voto;

public class VotoMapper {
	
	public static VotoDTO fromEntity(Voto voto) {
		return VotoDTO.builder()
				.id(voto.getId())
				.sugestaoId(voto.getSugestaoId())
				.userId(voto.getUserId())
				.usuario(voto.getUsuario())
				.dataCriacao(voto.getDataCriacao())
				.dataAtualizacao(voto.getDataAtualizacao())
				.comentario(voto.getComentario())
				.aprovado(voto.getAprovado())
				.resultadoSuporte(voto.getResultadoSuporte())
				.resultadoProdutividade(voto.getResultadoProdutividade())
				.resultadoAutomacao(voto.getResultadoAutomacao())
			.build();
	}
	
	public static Voto fromDto(VotoDTO voto) {
		return Voto.builder()
				.id(voto.getId())
				.sugestaoId(voto.getSugestaoId())
				.userId(voto.getUserId())
				.usuario(voto.getUsuario())
				.dataCriacao(voto.getDataCriacao())
				.dataAtualizacao(voto.getDataAtualizacao())
				.comentario(voto.getComentario())
				.aprovado(voto.getAprovado())
				.resultadoSuporte(voto.getResultadoSuporte())
				.resultadoProdutividade(voto.getResultadoProdutividade())
				.resultadoAutomacao(voto.getResultadoAutomacao())
			.build();
	}

}
