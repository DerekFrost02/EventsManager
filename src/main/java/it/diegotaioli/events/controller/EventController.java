package it.diegotaioli.events.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import it.diegotaioli.events.exceptions.BadRequestException;
import it.diegotaioli.events.exceptions.ResourceNotFoundException;
import it.diegotaioli.events.models.Event;
import it.diegotaioli.events.services.EventService;
import jakarta.validation.Valid;

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
	
	@PostMapping("api/events")
	public ResponseEntity<Event> store(
			@Valid @RequestBody Event requestEvent,
			BindingResult result
			) throws BadRequestException {
		if(result.hasErrors()) {
			ArrayList<String> errors = new ArrayList<String>();
			result.getAllErrors().forEach(error -> errors.add(error.getDefaultMessage()));
			throw new BadRequestException(errors);
		}
		
		Event eventInserted = this.eventService.insertEvent(requestEvent);
		return new ResponseEntity<>(eventInserted, HttpStatus.CREATED);
	}
	
	@PutMapping("api/events/{id}")
	public ResponseEntity<Event> update(
		@PathVariable Long id,
		@Valid @RequestBody Event eventRequest,
		BindingResult result
	) throws BadRequestException, ResourceNotFoundException {
		if(result.hasErrors()) {
			ArrayList<String> errors = new ArrayList<String>();
			result.getAllErrors().forEach(error -> errors.add(error.getDefaultMessage()));
			throw new BadRequestException(errors);
		}
		Event eventUpdated = this.eventService.updateEvent(id, eventRequest);
		return ResponseEntity.status(HttpStatus.OK).body(eventUpdated);
	}
	
	@DeleteMapping("api/events/{id}")
	public void destroy(@PathVariable Long id) {
		
	}

}
