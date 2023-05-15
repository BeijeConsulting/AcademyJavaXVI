package it.beije.beijeAir.repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import it.beije.beijeAir.model.Voli;

@Repository
public interface VoliRepository extends JpaRepository<Voli, Integer> {
	
	@Query(value = "select v from Voli v "
			+ "join v.cittaPartenza cp "
			+ "join v.cittaArrivo ca "
			+ "where (cp.citta = :cittaPartenza OR :cittaPartenza is null) "
			+ "AND (ca.citta = :cittaArrivo OR :cittaArrivo is null) "
			+ "AND (v.dataPartenza > :dataPartenza OR :dataPartenza is null)"
			)
	public List<Voli> find(@Param("cittaPartenza") String cittaPartenza, 
			@Param("cittaArrivo") String cittaArrivo, 
			@Param("dataPartenza") LocalDateTime dataPartenza 
			
			);
	
	public List<VoliUnoScaloDTO> findUnoScalo()
	
	public List<VoliDueScaliDTO> findDueScali() {
		
	}

}
