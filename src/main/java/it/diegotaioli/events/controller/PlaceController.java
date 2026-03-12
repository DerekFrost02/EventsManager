package it.diegotaioli.events.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import it.diegotaioli.events.models.Place;
import it.diegotaioli.events.services.PlaceService;

@RestController
public class PlaceController {
	
	PlaceService placeService;
	
	public PlaceController(PlaceService placeService) {
		this.placeService = placeService;
	}
	
	@GetMapping("api/places")
	public ResponseEntity<List<Place>> index()
	{
		List<Place> membrs = this.placeService.getAll();
		return ResponseEntity.ok(membrs);
	}
	
	

}
