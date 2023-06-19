package com.coffeeandcode.serviceimpl;

import com.coffeeandcode.model.DateContactModel;
import com.coffeeandcode.repository.DateContactRepository;
import com.coffeeandcode.service.InterfaceDateContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class ImplDateContactService implements InterfaceDateContactService {
	private final DateContactRepository dateContactRepository;

	@Autowired
	public ImplDateContactService(DateContactRepository dateContactRepository) {
		this.dateContactRepository = dateContactRepository;
	}

	@Override
	public List<DateContactModel> listallDateContac() {
		return dateContactRepository.findAll();
	}

	@Override
	public Optional<DateContactModel> getDateContacById(int idDateContact) {
		return dateContactRepository.findById(idDateContact);
	}

	@Override
	public DateContactModel createDateContac(DateContactModel dateContactModel) {
		return null;
	}

	@Override
	public DateContactModel saveDateContac(DateContactModel dateContactModel) {
		return dateContactRepository.save(dateContactModel);
	}


	@Override
	public DateContactModel updateDateContac(int idDateContact, DateContactModel dateContactModel) {
		Optional<DateContactModel> optionalDateContact = dateContactRepository.findById(idDateContact);

		if (optionalDateContact.isPresent()) {
			DateContactModel existingDateContact = optionalDateContact.get();
			/*
			// Actualizar los campos necesarios en el objeto existingDateContact
			existingDateContact.setApplicantsname(DateContactModel.getApplicantsname());
			existingDateContact.setSurname(DateContactModel.getSurname());
			existingDateContact.setCurp(DateContactModel.getCurp());
			existingDateContact.setDateofbirth(DateContactModel.getDateofbirth());
			existingDateContact.setPlaceofbirth(DateContactModel.getPlaceofbirth());
			// Actualizar otras propiedades si es necesario
*/
			// Guardar los cambios en la base de datos
			DateContactModel updatedDateContact = dateContactRepository.save(existingDateContact);
			return updatedDateContact;
		} else {
			throw new NoSuchElementException("El modelo para el ID " + idDateContact + " no existe");
		}
	}


	@Override
	public boolean deleteDateContac(int idDateContact) {
		Optional<DateContactModel> dateContactModel = dateContactRepository.findById(idDateContact);

		if (dateContactModel.isPresent()) {
			dateContactRepository.deleteById(idDateContact);
			return true;
		} else {
			return false;
		}
	}
}
