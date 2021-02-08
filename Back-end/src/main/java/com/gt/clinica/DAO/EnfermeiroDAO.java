package com.gt.clinica.DAO;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.gt.clinica.models.Enfermeiro;

@Repository

public interface EnfermeiroDAO extends JpaRepository<Enfermeiro, Long>{
	
	@Query(value = "SELECT * FROM Enfermeiro e WHERE e.email = :email", nativeQuery = true)
	Enfermeiro findEnfermeiroByEmail(@Param("email") String email);

}
