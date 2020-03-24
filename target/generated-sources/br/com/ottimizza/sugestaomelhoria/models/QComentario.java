package br.com.ottimizza.sugestaomelhoria.models;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QComentario is a Querydsl query type for Comentario
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QComentario extends EntityPathBase<Comentario> {

    private static final long serialVersionUID = -1418294717L;

    public static final QComentario comentario = new QComentario("comentario");

    public final DatePath<java.time.LocalDate> dataAtualizacao = createDate("dataAtualizacao", java.time.LocalDate.class);

    public final DatePath<java.time.LocalDate> dataCriacao = createDate("dataCriacao", java.time.LocalDate.class);

    public final NumberPath<java.math.BigInteger> id = createNumber("id", java.math.BigInteger.class);

    public final NumberPath<java.math.BigInteger> sugestaoId = createNumber("sugestaoId", java.math.BigInteger.class);

    public final StringPath texto = createString("texto");

    public final StringPath usuario = createString("usuario");

    public QComentario(String variable) {
        super(Comentario.class, forVariable(variable));
    }

    public QComentario(Path<? extends Comentario> path) {
        super(path.getType(), path.getMetadata());
    }

    public QComentario(PathMetadata metadata) {
        super(Comentario.class, metadata);
    }

}

