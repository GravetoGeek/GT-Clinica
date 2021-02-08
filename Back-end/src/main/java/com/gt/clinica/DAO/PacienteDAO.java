package com.gt.clinica.DAO;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gt.clinica.models.Paciente;

@Repository
public interface PacienteDAO extends JpaRepository<Paciente, Long>{

}
