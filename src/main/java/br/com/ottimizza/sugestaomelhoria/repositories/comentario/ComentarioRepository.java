package br.com.ottimizza.sugestaomelhoria.repositories.comentario;

import java.math.BigInteger;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.ottimizza.sugestaomelhoria.models.Comentario;

@Repository
public interface ComentarioRepository extends JpaRepository<Comentario, BigInteger>, ComentarioRepositoryCustom{

}
