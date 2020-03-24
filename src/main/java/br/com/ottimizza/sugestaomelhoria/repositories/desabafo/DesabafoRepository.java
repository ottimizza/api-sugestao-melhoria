package br.com.ottimizza.sugestaomelhoria.repositories.desabafo;

import java.math.BigInteger;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.ottimizza.sugestaomelhoria.models.Desabafo;

@Repository
public interface DesabafoRepository extends JpaRepository<Desabafo, BigInteger>, DesabafoRepositoryCustom {

}
