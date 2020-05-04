package br.com.ottimizza.sugestaomelhoria.repositories.sugestao;

import java.math.BigInteger;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.ottimizza.sugestaomelhoria.models.Sugestao;

@Repository
public interface SugestaoRepository extends JpaRepository<Sugestao, BigInteger>, SugestaoRepositoryCustom {

}
