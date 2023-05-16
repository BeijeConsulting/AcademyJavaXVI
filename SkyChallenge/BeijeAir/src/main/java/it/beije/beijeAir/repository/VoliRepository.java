package it.beije.beijeAir.repository;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.SqlResultSetMapping;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import it.beije.beijeAir.dto.RottaConIdDto;
import it.beije.beijeAir.model.Voli;


@SqlResultSetMapping(
	    name = "id_route_dto",
	    classes = @ConstructorResult(
	        targetClass = RottaConIdDto.class,
	        columns = {
	            @ColumnResult(name = "volo1_id", type = Integer.class),
	            @ColumnResult(name = "volo2_id", type = Integer.class),
	            @ColumnResult(name = "volo3_id", type = Integer.class)
	        }
	    )
	)

@Repository
public interface VoliRepository extends JpaRepository<Voli, Integer> {
	
	@Query(value = "select v from Voli v "
			+ "join v.cittaPartenza cp "
			+ "join v.cittaArrivo ca "
			+ "where (cp.nome = :cittaPartenza OR :cittaPartenza is null) "
			+ "AND (ca.nome = :cittaArrivo OR :cittaArrivo is null) "
			+ "AND ((v.dataPartenza BETWEEN :dataPartenza AND :dataRitorno) OR :dataPartenza is null OR :dataRitorno is null)"
			)
	public List<Voli> find(@Param("cittaPartenza") String cittaPartenza, 
			@Param("cittaArrivo") String cittaArrivo, 
			@Param("dataPartenza") LocalDateTime dataPartenza,
			@Param("dataRitorno") LocalDateTime dataRitorno);
	
	
	@Query(name = "find_route_one", nativeQuery = true)
	public List<RottaConIdDto> findUnoScalo(@Param("cittaPartenza") Integer cittaPartenza, 
											@Param("cittaArrivo") Integer cittaArrivo, 
											@Param("dataPartenza") LocalDateTime dataPartenza,
											@Param("dataRitorno") LocalDateTime dataRitorno);

	
	@Query(name = "find_route_two", nativeQuery = true)
	public List<RottaConIdDto> findDueScali(@Param("cittaPartenza") Integer cittaPartenza, 
											@Param("cittaArrivo") Integer cittaArrivo, 
											@Param("dataPartenza") LocalDateTime dataPartenza,
											@Param("dataRitorno") LocalDateTime dataRitorno);
	

}
