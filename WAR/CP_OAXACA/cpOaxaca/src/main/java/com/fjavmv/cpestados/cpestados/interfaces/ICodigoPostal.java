package com.fjavmv.cpestados.cpestados.interfaces;

import com.fjavmv.cpestados.cpestados.modell.CodigoPostal;

import java.util.List;
import java.util.Map;

public interface ICodigoPostal {
	List<Map<String, Object>> listar();

	List<Map<String, Object>> searchPostalCode( Integer postalcode);

	Integer add(CodigoPostal codigoPostal);

	Integer edit(CodigoPostal codigoPostal);

	Integer delete(Integer id);

}
