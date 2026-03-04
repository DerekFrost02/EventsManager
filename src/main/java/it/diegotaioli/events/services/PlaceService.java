package it.diegotaioli.events.services;

import java.util.List;

import org.springframework.stereotype.Service;

import it.diegotaioli.events.models.Place;
import it.diegotaioli.events.repositories.PlaceRepository;

@Service
public class PlaceService {
	
	PlaceRepository placeRepo;
	
	public PlaceService(PlaceRepository placeRepo) {
		this.placeRepo = placeRepo;
	}
	
	public List<Place> getAll(){
		return this.placeRepo.findAll();
	}
	
	

}
