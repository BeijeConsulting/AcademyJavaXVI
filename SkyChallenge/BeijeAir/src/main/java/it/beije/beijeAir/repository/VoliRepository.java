package it.beije.beijeAir.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import it.beije.beijeAir.dto.RottaConIdDto;
import it.beije.beijeAir.model.Voli;

@Repository
public interface VoliRepository extends JpaRepository<Voli, Integer> {
	
	@Query(value = "select v from Voli v "
			+ "join v.cittaPartenza cp "
			+ "join v.cittaArrivo ca "
			+ "where (cp.nome = :cittaPartenza OR :cittaPartenza is null) "
			+ "AND (ca.nome = :cittaArrivo OR :cittaArrivo is null) "
			+ "AND (v.dataPartenza > :dataPartenza OR :dataPartenza is null)"
			)
	public List<Voli> find(@Param("cittaPartenza") String cittaPartenza, 
			@Param("cittaArrivo") String cittaArrivo, 
			@Param("dataPartenza") LocalDateTime dataPartenza);
	

	@Query(value = "SELECT v1.id AS volo1_id, v2.id AS volo2_id, 0 AS volo3_id "
			+ "FROM voli AS v1 "
			+ "JOIN voli AS v2 ON v1.citta_arrivo = v2.citta_partenza "
			+ "WHERE (v1.citta_partenza = :cittaPartenza OR :cittaPartenza is null) "
			+ "AND (v2.citta_arrivo = :cittaArrivo OR :cittaArrivo is null) "
			+ "AND v2.data_partenza > v1.data_arrivo "
			+ "AND (v1.data_partenza > :dataPartenza OR :dataPartenza is null)", nativeQuery = true)
	public List<RottaConIdDto> findUnoScalo(@Param("cittaPartenza") Integer cittaPartenza, 
											@Param("cittaArrivo") Integer cittaArrivo, 
											@Param("dataPartenza") LocalDateTime dataPartenza);

	
	@Query(value = "SELECT v1.id AS volo1_id, v2.id AS volo2_id, v3.id AS volo3_id "
			+ "FROM voli AS v1 "
			+ "JOIN voli AS v2 ON v1.citta_arrivo = v2.citta_partenza "
			+ "JOIN voli AS v3 ON v2.citta_arrivo = v3.citta_partenza "
			+ "WHERE (v1.citta_partenza = :cittaPartenza OR :cittaPartenza is null) "
			+ "AND (v3.citta_arrivo = :cittaArrivo OR :cittaArrivo is null) "
			+ "AND v2.data_partenza > v1.data_arrivo "
			+ "AND v3.data_partenza > v2.data_arrivo "
			+ "AND (v1.data_partenza > :dataPartenza OR :dataPartenza is null)", nativeQuery = true)
	public List<RottaConIdDto> findDueScali(@Param("cittaPartenza") String cittaPartenza, 
											@Param("cittaArrivo") String cittaArrivo, 
											@Param("dataPartenza") LocalDateTime dataPartenza);
	

}
