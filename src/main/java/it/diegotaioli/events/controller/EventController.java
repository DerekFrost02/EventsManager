package it.diegotaioli.events.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import it.diegotaioli.events.exceptions.ResourceNotFoundException;
import it.diegotaioli.events.models.Event;
import it.diegotaioli.events.services.EventService;

@RestController
public class EventController {
	
	private EventService eventService;
	
	public EventController(EventService eventService) {
		this.eventService = eventService;
	}
	
	@GetMapping("api/events")
	public ResponseEntity<List<Event>> index()
	{
		List<Event> events = this.eventService.getAll();
		return ResponseEntity.ok(events);
	}
	
	@GetMapping("api/events/{id}")
	public ResponseEntity<Event> indexById(@PathVariable String id) throws ResourceNotFoundException
	{
		Long chiave = Long.parseLong(id);
		Event event = this.eventService.getById(chiave);
		return ResponseEntity.ok(event);
	}

}
