package br.com.ottimizza.sugestaomelhoria.domain.mappers;

import br.com.ottimizza.sugestaomelhoria.domain.dtos.SugestaoDTO;
import br.com.ottimizza.sugestaomelhoria.models.Sugestao;

public class SugestaoMapper {

	public static Sugestao fromDto(SugestaoDTO sugestao) {
		return Sugestao.builder()
				.id(sugestao.getId())
				.topicoId(sugestao.getTopicoId())
				.dataCriacao(sugestao.getDataCriacao())
				.dataAtualizacao(sugestao.getDataAtualizacao())
				.usuario(sugestao.getUsuario())
				.titulo(sugestao.getTitulo())
				.descricaoSugestao(sugestao.getDescricaoSugestao())
				.problemaResolvido(sugestao.getProblemaResolvido())
				.resultadoSuporte(sugestao.getResultadoSuporte())
				.resultadoProdutividade(sugestao.getResultadoProdutividade())
				.resultadoAutomacao(sugestao.getResultadoAutomacao())
				.status(sugestao.getStatus())
				.numeroComentarios(sugestao.getNumeroComentarios())
				.numeroLikes(sugestao.getNumeroLikes())
				.numeroDislikes(sugestao.getNumeroDislikes())
				.status(sugestao.getStatus())
			.build();
	}
	
	public static SugestaoDTO fromEntity(Sugestao sugestao) {
		return SugestaoDTO.builder()
				.id(sugestao.getId())
				.topicoId(sugestao.getTopicoId())
				.dataCriacao(sugestao.getDataCriacao())
				.dataAtualizacao(sugestao.getDataAtualizacao())
				.usuario(sugestao.getUsuario())
				.titulo(sugestao.getTitulo())
				.descricaoSugestao(sugestao.getDescricaoSugestao())
				.problemaResolvido(sugestao.getProblemaResolvido())
				.resultadoSuporte(sugestao.getResultadoSuporte())
				.resultadoProdutividade(sugestao.getResultadoProdutividade())
				.resultadoAutomacao(sugestao.getResultadoAutomacao())
				.status(sugestao.getStatus())
				.numeroComentarios(sugestao.getNumeroComentarios())
				.numeroLikes(sugestao.getNumeroLikes())
				.numeroDislikes(sugestao.getNumeroDislikes())
				.status(sugestao.getStatus())
			.build();
	}
}
