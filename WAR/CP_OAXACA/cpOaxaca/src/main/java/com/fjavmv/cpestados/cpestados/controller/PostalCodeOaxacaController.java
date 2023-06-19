package com.fjavmv.cpestados.cpestados.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fjavmv.cpestados.cpestados.modell.PostalCodeOaxacaModell;
import com.fjavmv.cpestados.cpestados.services.InterfacePostalCodeOaxacaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/postalcode")
public class PostalCodeOaxacaController {
	//Definición de la variable que contendrá las Interfaces de servicio
	private final InterfacePostalCodeOaxacaService iPostalCodeOaxacaSer;

	/**
	 * Inyección de dependencias por medio del constructor de nuestra clase
	 *
	 * @param iPostalCodeOaxacaSer es el sobrenombre que se le dio a la inyección
	 */
	public PostalCodeOaxacaController(@Autowired InterfacePostalCodeOaxacaService iPostalCodeOaxacaSer) {
		this.iPostalCodeOaxacaSer = iPostalCodeOaxacaSer;
	}


	/**
	 * Este método se encarga de traer todo el contenido de la tabla oaxacacps
	 * Una vez traído en una lista de modelos(PostalCodeOaxacaModell) los convertimos
	 * a un Array Json el cual se almacena en la variable json
	 *
	 * @return json Retorna el array convertido
	 */
	@GetMapping("/list")
	public String listAllPostallcodeContent() {
		//Definición de la lista de modelos y ejecución de nuestra consulta para obtener los elementos
		List<PostalCodeOaxacaModell> postalCodeOaxacaModell = iPostalCodeOaxacaSer.listAllPostalCodesOaxaca();
		//Conversión de postalCodeOaxacaModell a array Json
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			String json = objectMapper.writeValueAsString(postalCodeOaxacaModell);
			return json;
		} catch (JsonProcessingException e) {
			// Manejar la excepción en caso de error durante la conversión a JSON
			e.printStackTrace();
			return null; // o lanzar una excepción personalizada, según tus necesidades
		}
	}

	/**
	 * Este método tiene el objetivo de listar los modelos que coincidan con la búsqueda
	 *
	 * @param postalCode Parámetro necesario del número de código postal que queremos buscar
	 *                   Una vez ejecutada la consulta con éxito esta se almacena en una lista de modelos
	 *                   la cual posteriormente convertimos a un array json
	 * @return json retorna el array json convertido
	 */
	@GetMapping("/search/{postalCode}")
	public String listInformationByPostalCode(@PathVariable int postalCode) {
		//Definición de la lista de modelos y ejecución de nuestra consulta para obtener los elementos
		List<PostalCodeOaxacaModell> postalCodeOaxacaModellList = iPostalCodeOaxacaSer.listAllPostalCodesByPostalCode(postalCode);
		//Conversión de postalCodeOaxacaModell a array Json
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			String json = objectMapper.writeValueAsString(postalCodeOaxacaModellList);
			return json;
		} catch (JsonProcessingException e) {
			// Manejar la excepción en caso de error durante la conversión a JSON
			e.printStackTrace();
			String hola = "Hola";
			return hola; // o lanzar una excepción personalizada, según tus necesidades
		}
	}

	/**
	 * Método que realiza un búsqueda en la base de datos
	 *
	 * @param asenta Parámetro a buscar en la base de datos
	 *               Posterior cuando traiga la lista debemos convertirla en un array json
	 * @return json es el valor que devuelve en donde contiene las coincidencias obtenidas
	 */
	@GetMapping("/searchasenta/{asenta}")
	public String listInformationByAsenta(@PathVariable String asenta) {
		//Definición de la lista de modelos y ejecución de nuestra consulta para obtener los elementos
		List<PostalCodeOaxacaModell> postalCodeOaxacaModellList = iPostalCodeOaxacaSer.listAllPostalCodesByAsenta(asenta);
		//Conversión de postalCodeOaxacaModell a array Json

		try {
			ObjectMapper objectMapper = new ObjectMapper();
			String json = objectMapper.writeValueAsString(postalCodeOaxacaModellList);
			return json;
		} catch (JsonProcessingException e) {
			// Manejar la excepción en caso de error durante la conversión a JSON
			e.printStackTrace();
			String hola = "Hola";
			return hola; // o lanzar una excepción personalizada, según tus necesidades
		}
	}

/*
	@PostMapping(value = "/add")
	//consumes = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE}
	public String add(@RequestBody CodigoPostal codigoPostal) {
		Integer id = iCodigoPostal.add(codigoPostal);
		if (id == 0) {
			return "NO FUE POSIBLE REALIZAR EL REGISTRO";
		} else {
			return "SE HA REALIZADO EL REALIZADO CORRECTAMENTE";
		}
	}
*/
/*
	@PostMapping("/delete/{id}")
	public String delete(@PathVariable Integer id) {
		Integer fila = iCodigoPostal.delete(id);
		if (fila == 0) {
			return "EL REGISTRO NO PUDO SER ELIMINADO";
		} else {
			return "ELEMENTO ELIMINADO CORRECTAMENTE";
		}
	}
*/
}
