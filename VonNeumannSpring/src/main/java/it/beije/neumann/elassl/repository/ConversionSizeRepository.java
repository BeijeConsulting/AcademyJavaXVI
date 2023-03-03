package it.beije.neumann.elassl.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.beije.neumann.elassl.model.ConversionSize;

@Repository
public interface ConversionSizeRepository extends JpaRepository<ConversionSize, Long> {
    List<ConversionSize> findByType(String type);
}
