package br.com.ottimizza.sugestaomelhoria.models;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QDesabafo is a Querydsl query type for Desabafo
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QDesabafo extends EntityPathBase<Desabafo> {

    private static final long serialVersionUID = -1491142855L;

    public static final QDesabafo desabafo = new QDesabafo("desabafo");

    public final DatePath<java.time.LocalDate> dataAtualizacao = createDate("dataAtualizacao", java.time.LocalDate.class);

    public final DatePath<java.time.LocalDate> dataCriacao = createDate("dataCriacao", java.time.LocalDate.class);

    public final DatePath<java.time.LocalDate> dataRetornoCliente = createDate("dataRetornoCliente", java.time.LocalDate.class);

    public final NumberPath<java.math.BigInteger> id = createNumber("id", java.math.BigInteger.class);

    public final StringPath texto = createString("texto");

    public final NumberPath<java.math.BigInteger> topicoId = createNumber("topicoId", java.math.BigInteger.class);

    public final StringPath usuario = createString("usuario");

    public QDesabafo(String variable) {
        super(Desabafo.class, forVariable(variable));
    }

    public QDesabafo(Path<? extends Desabafo> path) {
        super(path.getType(), path.getMetadata());
    }

    public QDesabafo(PathMetadata metadata) {
        super(Desabafo.class, metadata);
    }

}

