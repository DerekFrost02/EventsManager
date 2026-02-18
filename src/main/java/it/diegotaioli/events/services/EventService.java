package it.diegotaioli.events.services;

import java.util.List;
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
					() ->new ResourceNotFoundException("Evento con id " + id + " non trovato")
		);
		return event;
	}

}
