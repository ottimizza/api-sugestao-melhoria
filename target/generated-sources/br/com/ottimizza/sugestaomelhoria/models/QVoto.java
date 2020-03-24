package br.com.ottimizza.sugestaomelhoria.models;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QVoto is a Querydsl query type for Voto
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QVoto extends EntityPathBase<Voto> {

    private static final long serialVersionUID = -405149994L;

    public static final QVoto voto = new QVoto("voto");

    public final BooleanPath aprovado = createBoolean("aprovado");

    public final StringPath comentario = createString("comentario");

    public final DatePath<java.time.LocalDate> dataAtualizacao = createDate("dataAtualizacao", java.time.LocalDate.class);

    public final DatePath<java.time.LocalDate> dataCriacao = createDate("dataCriacao", java.time.LocalDate.class);

    public final NumberPath<java.math.BigInteger> id = createNumber("id", java.math.BigInteger.class);

    public final NumberPath<Short> resultadoAutomacao = createNumber("resultadoAutomacao", Short.class);

    public final NumberPath<Short> resultadoProdutividade = createNumber("resultadoProdutividade", Short.class);

    public final NumberPath<Short> resultadoSuporte = createNumber("resultadoSuporte", Short.class);

    public final NumberPath<java.math.BigInteger> sugestaoId = createNumber("sugestaoId", java.math.BigInteger.class);

    public final StringPath usuario = createString("usuario");

    public QVoto(String variable) {
        super(Voto.class, forVariable(variable));
    }

    public QVoto(Path<? extends Voto> path) {
        super(path.getType(), path.getMetadata());
    }

    public QVoto(PathMetadata metadata) {
        super(Voto.class, metadata);
    }

}

