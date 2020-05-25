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
	 @Query("delete from Voto v where v.userId = :userId and v.id = :sugestaoId")
	 Integer deletePorUserId(@Param("userId") BigInteger userId, @Param("sugestaoId") BigInteger votoId);
	
	 
	 @Query("SELECT v.aprovado 		                   "
		 	  + "FROM Voto v      		  		       "
		 	  + "WHERE v.userId     = :userId 	 	   "
		 	  + "AND   v.sugestaoId = :sugestaoId	   ")
	 Boolean findByUserIdAndSugestaoId(@Param("userId") BigInteger userId, @Param("sugestaoId") BigInteger sugestaoId);
		 
	 @Query(value = 
			   "SELECT *	                   		       "
		 	  + "FROM votos v      		  		           "
		 	  + "WHERE v.user_id        = :userId 	 	   "
		 	  + "AND   v.fk_sugestao_id = :sugestaoId	   ", nativeQuery = true)
	 Voto findVotoByUserIdAndSugestaoId(@Param("userId") BigInteger userId, @Param("sugestaoId") BigInteger sugestaoId);
	
}
