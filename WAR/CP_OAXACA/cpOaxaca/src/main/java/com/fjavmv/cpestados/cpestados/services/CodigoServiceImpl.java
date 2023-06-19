package com.fjavmv.cpestados.cpestados.services;

import com.fjavmv.cpestados.cpestados.interfaces.ICodigoPostal;
import com.fjavmv.cpestados.cpestados.modell.CodigoPostal;
import com.fjavmv.cpestados.cpestados.repository.CodigoPostalRepImpl;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

public class CodigoServiceImpl implements ICodigoPostal {

    private final CodigoPostalRepImpl codigoPostalRep;

    public CodigoServiceImpl(@Autowired CodigoPostalRepImpl codigoPostalRep){
        this.codigoPostalRep = codigoPostalRep;
    }

    @Override
    public List<Map<String, Object>> listar() {
        return codigoPostalRep.listar();
    }

    @Override
    public List<Map<String, Object>> searchPostalCode(Integer postalcode) {
        return codigoPostalRep.searchPostalCode(postalcode);
    }

    @Override
    public Integer add(CodigoPostal codigoPostal) {
        return codigoPostalRep.add(codigoPostal);
    }

    @Override
    public Integer edit(CodigoPostal codigoPostal) {
        return codigoPostalRep.edit(codigoPostal);
    }

    @Override
    public Integer delete(Integer id) {
        return codigoPostalRep.delete(id);
    }
}
