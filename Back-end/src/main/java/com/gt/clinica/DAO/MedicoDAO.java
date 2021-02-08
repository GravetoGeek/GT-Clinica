/**
 * 
 */
package com.gt.clinica.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.gt.clinica.models.Medico;

/**
 * @author gravetogeek
 *
 */

@Repository
public interface MedicoDAO extends JpaRepository<Medico, Long>{
	@Query(value = "SELECT * FROM medico WHERE email = :email",nativeQuery = true)
	Medico findMedicoByEmail(@Param("email") String email);

}
