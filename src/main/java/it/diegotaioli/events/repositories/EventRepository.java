package it.diegotaioli.events.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import it.diegotaioli.events.models.Event;

public interface EventRepository extends JpaRepository<Event, Long>{

}
