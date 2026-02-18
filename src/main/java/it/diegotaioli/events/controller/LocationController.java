package it.diegotaioli.events.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import it.diegotaioli.events.models.Location;
import it.diegotaioli.events.services.LocationService;

@RestController
public class LocationController {
	
private LocationService locationService;
	
	public LocationController(LocationService locationService) {
		this.locationService = locationService;
	}
	
	@GetMapping("api/locations")
	public ResponseEntity<List<Location>> index()
	{
		List<Location> locations = this.locationService.getAll();
		return ResponseEntity.ok(locations);
	}
	
	@GetMapping("api/locations/{id}")
	public ResponseEntity<List<Location>> indexByID(@PathVariable String id)
	{
		Long chiave = Long.parseLong(id);
		List<Location> locations = this.locationService.getById(chiave);
		return ResponseEntity.ok(locations);
	}

}
