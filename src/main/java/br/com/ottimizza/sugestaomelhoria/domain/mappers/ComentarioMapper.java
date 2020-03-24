package br.com.ottimizza.sugestaomelhoria.domain.mappers;

import br.com.ottimizza.sugestaomelhoria.domain.dtos.ComentarioDTO;
import br.com.ottimizza.sugestaomelhoria.models.Comentario;

public class ComentarioMapper {

	public static Comentario fromDto(ComentarioDTO comentario) {
		Comentario c = Comentario.builder()
				.id(comentario.getId())
				.usuario(comentario.getUsuario())
				.sugestaoId(comentario.getSugestaoId())
				.dataCriacao(comentario.getDataCriacao())
				.dataAtualizacao(comentario.getDataAtualizacao())
				.texto(comentario.getTexto())
			.build();
		return c;
	}
	
	public static ComentarioDTO fromEntity(Comentario comentario) {
		ComentarioDTO c = ComentarioDTO.builder()
				.id(comentario.getId())
				.usuario(comentario.getUsuario())
				.sugestaoId(comentario.getSugestaoId())
				.dataCriacao(comentario.getDataCriacao())
				.dataAtualizacao(comentario.getDataAtualizacao())
				.texto(comentario.getTexto())
			.build();
		return c;
	}
}
