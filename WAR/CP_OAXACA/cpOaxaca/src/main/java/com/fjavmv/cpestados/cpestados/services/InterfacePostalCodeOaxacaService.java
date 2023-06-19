package com.fjavmv.cpestados.cpestados.services;

import com.fjavmv.cpestados.cpestados.modell.PostalCodeOaxacaModell;

import java.util.List;

public interface InterfacePostalCodeOaxacaService {
	public List<PostalCodeOaxacaModell> listAllPostalCodesOaxaca();
	public List<PostalCodeOaxacaModell> listAllPostalCodesByPostalCode(int postalCode);
	public List<PostalCodeOaxacaModell> listAllPostalCodesByAsenta(String asenta);
}
