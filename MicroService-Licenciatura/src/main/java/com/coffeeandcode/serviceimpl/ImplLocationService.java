package com.coffeeandcode.serviceimpl;

import com.coffeeandcode.modell.LocationModell;
import com.coffeeandcode.repository.LocationRepository;
import com.coffeeandcode.service.InterfaceLocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ImplLocationService implements InterfaceLocationService {
	private final LocationRepository locationRepository;

	@Autowired
	public ImplLocationService(LocationRepository locationRepository) {
		this.locationRepository = locationRepository;
	}

	@Override
	public List<LocationModell> listAllLocations() {
		return locationRepository.findAll();
	}

	@Override
	public Optional<LocationModell> getLocationById(int idLocation) {
		return locationRepository.findById(idLocation);
	}

	@Override
	public LocationModell saveLocation(LocationModell locationModell) {
		return locationRepository.save(locationModell);
	}

	@Override
	public boolean deleteLocation(int idlocation) {
		Optional<LocationModell> location = locationRepository.findById(idlocation);
		if (location.isPresent()) {
			locationRepository.deleteById(idlocation);
			return true;
		}
		return false;
	}
	@Override
	public Long getLastLocationId() {
		return locationRepository.findLastLocationId();
	}


}
