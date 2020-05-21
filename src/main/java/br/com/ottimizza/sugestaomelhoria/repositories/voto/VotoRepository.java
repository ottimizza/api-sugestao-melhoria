package br.com.ottimizza.sugestaomelhoria.repositories.voto;

import java.math.BigInteger;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.ottimizza.sugestaomelhoria.models.Voto;

@Repository
public interface VotoRepository extends JpaRepository<Voto, BigInteger>, VotoRepositoryCustom{

	
	 @Modifying
	    @Transactional
	    @Query("delete from Voto v where v.userId = :userId")
	    Integer deletePorUserId(@Param("userId") BigInteger userId);
	
}
