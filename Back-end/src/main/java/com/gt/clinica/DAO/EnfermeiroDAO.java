package com.gt.clinica.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gt.clinica.models.Enfermeiro;

@Repository
public interface EnfermeiroDAO extends JpaRepository<Enfermeiro, Long>{

}
