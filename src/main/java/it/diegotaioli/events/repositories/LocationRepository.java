package it.diegotaioli.events.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import it.diegotaioli.events.models.Location;

public interface LocationRepository extends JpaRepository<Location, Long>{

}
