package it.diegotaioli.events.services;

import java.util.List;

import org.springframework.stereotype.Service;

import it.diegotaioli.events.exceptions.ResourceNotFoundException;
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
	
	public Location getById(Long id) throws ResourceNotFoundException
	{
		Location local = this.locationRepository.findById(id)
				.orElseThrow(
					() ->new ResourceNotFoundException("localita con id = " + id + " non trovato")
				);
		return local;
	}
	
	public Location insertLocation(Location requestLocation) {
		Location locationInserted = this.locationRepository.save(requestLocation);
		return locationInserted;
	}

}
