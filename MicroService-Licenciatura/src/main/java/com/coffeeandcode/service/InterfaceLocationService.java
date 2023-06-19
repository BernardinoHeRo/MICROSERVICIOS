package com.coffeeandcode.service;

import com.coffeeandcode.modell.LocationModell;

import java.util.List;
import java.util.Optional;

public interface InterfaceLocationService {
	public List<LocationModell> listAllLocations();

	public Optional<LocationModell> getLocationById(int idLocation);

	public LocationModell saveLocation(LocationModell locationModell);

	public boolean deleteLocation(int idlocation);
	public Long getLastLocationId();
}
