/**
 * 
 */
package com.gt.clinica.DAO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gt.clinica.models.Medico;

/**
 * @author gravetogeek
 *
 */

@Repository
public interface MedicoDAO extends JpaRepository<Medico, Long>{

}
