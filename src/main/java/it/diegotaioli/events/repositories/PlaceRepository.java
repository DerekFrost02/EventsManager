package it.diegotaioli.events.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import it.diegotaioli.events.models.Place;

public interface PlaceRepository extends JpaRepository<Place, Long>{

}
