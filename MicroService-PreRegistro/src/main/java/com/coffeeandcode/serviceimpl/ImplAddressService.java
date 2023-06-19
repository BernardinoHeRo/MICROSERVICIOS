package com.coffeeandcode.serviceimpl;

import com.coffeeandcode.model.AddressModel;
import com.coffeeandcode.model.AddressModel;
import com.coffeeandcode.repository.AddressRepository;
import com.coffeeandcode.service.InterfaceAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class ImplAddressService implements InterfaceAddressService {
	private final AddressRepository addressRepository;

	@Autowired
	public ImplAddressService(AddressRepository addressRepository) {
		this.addressRepository = addressRepository;
	}

	@Override
	public List<AddressModel> listallAddress() {
		return addressRepository.findAll();
	}

	@Override
	public Optional<AddressModel> getAddressById(int idAddress) {
		return addressRepository.findById(idAddress);
	}

	@Override
	public AddressModel createAddress(AddressModel AddressModel) {
		return null;
	}

	@Override
	public AddressModel saveAddress(AddressModel AddressModel) {
		return addressRepository.save(AddressModel);
	}


	@Override
	public AddressModel updateAddress(int idAddress, AddressModel AddressModel) {
		Optional<AddressModel> optionalAddress = addressRepository.findById(idAddress);

		if (optionalAddress.isPresent()) {
			AddressModel existingAddress = optionalAddress.get();
			/*
			// Actualizar los campos necesarios en el objeto existingAddress
			existingAddress.setApplicantsname(AddressModel.getApplicantsname());
			existingAddress.setSurname(AddressModel.getSurname());
			existingAddress.setCurp(AddressModel.getCurp());
			existingAddress.setDateofbirth(AddressModel.getDateofbirth());
			existingAddress.setPlaceofbirth(AddressModel.getPlaceofbirth());
			// Actualizar otras propiedades si es necesario
*/
			// Guardar los cambios en la base de datos
			AddressModel updatedAddress = addressRepository.save(existingAddress);
			return updatedAddress;
		} else {
			throw new NoSuchElementException("El modelo para el ID " + idAddress + " no existe");
		}
	}


	@Override
	public boolean deleteAddress(int idAddress) {
		Optional<AddressModel> addressModel = addressRepository.findById(idAddress);

		if (addressModel.isPresent()) {
			addressRepository.deleteById(idAddress);
			return true;
		} else {
			return false;
		}
	}
}
