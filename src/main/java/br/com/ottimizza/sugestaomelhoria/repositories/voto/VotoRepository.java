package br.com.ottimizza.sugestaomelhoria.repositories.voto;

import java.math.BigInteger;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.ottimizza.sugestaomelhoria.models.Voto;

@Repository
public interface VotoRepository extends JpaRepository<Voto, BigInteger>, VotoRepositoryCustom{

}
