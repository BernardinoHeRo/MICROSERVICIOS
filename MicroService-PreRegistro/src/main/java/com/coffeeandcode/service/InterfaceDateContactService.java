package com.coffeeandcode.service;

import com.coffeeandcode.model.DateContactModel;

import java.util.List;
import java.util.Optional;

public interface InterfaceDateContactService {
	public List<DateContactModel> listallDateContac();

	public Optional<DateContactModel> getDateContacById(int idDateContact);

	public DateContactModel createDateContac(DateContactModel dateContactModel);

	public DateContactModel saveDateContac(DateContactModel dateContactModel);

	public DateContactModel updateDateContac(int idDateContact, DateContactModel dateContactModel);

	public boolean deleteDateContac(int idDateContac);
}
