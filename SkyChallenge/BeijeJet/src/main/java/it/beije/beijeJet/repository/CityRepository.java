package it.beije.beijeJet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import it.beije.beijeJet.model.City;

@Repository
public interface CityRepository extends JpaRepository<City, Integer> {

}
