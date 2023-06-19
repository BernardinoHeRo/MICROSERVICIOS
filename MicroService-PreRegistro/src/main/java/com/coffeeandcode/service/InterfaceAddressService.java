package com.coffeeandcode.service;

import com.coffeeandcode.model.AddressModel;

import java.util.List;
import java.util.Optional;

public interface InterfaceAddressService {
	public List<AddressModel> listallAddress();

	public Optional<AddressModel> getAddressById(int idAddress);

	public AddressModel createAddress(AddressModel addressModel);
	public AddressModel saveAddress(AddressModel addressModel);

	public AddressModel updateAddress(int idAddress, AddressModel addressModel);

	public boolean deleteAddress(int idAddress);
}
