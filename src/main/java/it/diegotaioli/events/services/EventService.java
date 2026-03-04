package it.diegotaioli.events.services;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import it.diegotaioli.events.exceptions.ResourceNotFoundException;
import it.diegotaioli.events.models.Event;
import it.diegotaioli.events.repositories.EventRepository;

@Service
public class EventService {
	
	private EventRepository eventRepository;
	
	public EventService(EventRepository eventRepository) {
		this.eventRepository = eventRepository;
	}
	
	public List<Event> getAll()
	{
		return this.eventRepository.findAll();
	}
	
	public Event getById(Long id) throws ResourceNotFoundException
	{
		Event event = this.eventRepository.findById(id)
				.orElseThrow(
					() ->new ResourceNotFoundException("Evento con id = " + id + " non trovato")
		);
		return event;
	}
	
	public Event insertEvent(Event requestEvent) {
		Event eventInserted = this.eventRepository.save(requestEvent);
		return eventInserted;
	}
	
	public Event updateEvent(Long id, Event requestEvent) {
		requestEvent.setId(id);
		Event eventUpdated = this.eventRepository.save(requestEvent);
		return eventUpdated;
	}
	
	public ResponseEntity<?> deleteEventById(Long id) {
		this.eventRepository.deleteById(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
	}

}
