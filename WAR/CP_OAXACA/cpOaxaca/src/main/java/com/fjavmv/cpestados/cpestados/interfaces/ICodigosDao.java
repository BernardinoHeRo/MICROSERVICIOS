package com.fjavmv.cpestados.cpestados.interfaces;

import com.fjavmv.cpestados.cpestados.modell.CodigoPostal;
import org.springframework.data.repository.CrudRepository;

public interface ICodigosDao extends CrudRepository<CodigoPostal, Integer> {
}
