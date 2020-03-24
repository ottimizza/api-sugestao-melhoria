package br.com.ottimizza.sugestaomelhoria.models;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QSugestao is a Querydsl query type for Sugestao
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QSugestao extends EntityPathBase<Sugestao> {

    private static final long serialVersionUID = -142965775L;

    public static final QSugestao sugestao = new QSugestao("sugestao");

    public final DatePath<java.time.LocalDate> dataAtualizacao = createDate("dataAtualizacao", java.time.LocalDate.class);

    public final DatePath<java.time.LocalDate> dataCriacao = createDate("dataCriacao", java.time.LocalDate.class);

    public final StringPath descricaoSugestao = createString("descricaoSugestao");

    public final NumberPath<java.math.BigInteger> id = createNumber("id", java.math.BigInteger.class);

    public final NumberPath<Short> numeroComentarios = createNumber("numeroComentarios", Short.class);

    public final NumberPath<Short> numeroDislikes = createNumber("numeroDislikes", Short.class);

    public final NumberPath<Short> numeroLikes = createNumber("numeroLikes", Short.class);

    public final StringPath problemaResolvido = createString("problemaResolvido");

    public final NumberPath<Short> resultadoAutomacao = createNumber("resultadoAutomacao", Short.class);

    public final NumberPath<Short> resultadoProdutividade = createNumber("resultadoProdutividade", Short.class);

    public final NumberPath<Short> resultadoSuporte = createNumber("resultadoSuporte", Short.class);

    public final NumberPath<Short> status = createNumber("status", Short.class);

    public final StringPath titulo = createString("titulo");

    public final NumberPath<java.math.BigInteger> topicoId = createNumber("topicoId", java.math.BigInteger.class);

    public final StringPath usuario = createString("usuario");

    public QSugestao(String variable) {
        super(Sugestao.class, forVariable(variable));
    }

    public QSugestao(Path<? extends Sugestao> path) {
        super(path.getType(), path.getMetadata());
    }

    public QSugestao(PathMetadata metadata) {
        super(Sugestao.class, metadata);
    }

}

