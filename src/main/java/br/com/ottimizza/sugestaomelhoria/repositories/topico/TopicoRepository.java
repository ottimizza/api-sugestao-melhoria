package br.com.ottimizza.sugestaomelhoria.repositories.topico;

import java.math.BigInteger;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.ottimizza.sugestaomelhoria.models.Topico;

@Repository
public interface TopicoRepository extends JpaRepository<Topico, BigInteger>, TopicoRepositoryCustom{

}