package it.diegotaioli.events.services;

import java.util.List;

import org.springframework.stereotype.Service;

import it.diegotaioli.events.models.Location;
import it.diegotaioli.events.repositories.LocationRepository;

@Service
public class LocationService {
	
	private LocationRepository locationRepository;
	
	public LocationService(LocationRepository locationRepository) {
		this.locationRepository = locationRepository;
	}
	
	public List<Location> getAll()
	{
		return this.locationRepository.findAll();
	}
	
	public List<Location> getById(Long id)
	{
		return this.locationRepository.findById(id);
	}

}
