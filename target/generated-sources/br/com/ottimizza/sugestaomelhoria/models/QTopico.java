package br.com.ottimizza.sugestaomelhoria.models;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QTopico is a Querydsl query type for Topico
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QTopico extends EntityPathBase<Topico> {

    private static final long serialVersionUID = 1435499650L;

    public static final QTopico topico = new QTopico("topico");

    public final BooleanPath ativo = createBoolean("ativo");

    public final NumberPath<java.math.BigInteger> id = createNumber("id", java.math.BigInteger.class);

    public final StringPath nome = createString("nome");

    public QTopico(String variable) {
        super(Topico.class, forVariable(variable));
    }

    public QTopico(Path<? extends Topico> path) {
        super(path.getType(), path.getMetadata());
    }

    public QTopico(PathMetadata metadata) {
        super(Topico.class, metadata);
    }

}

