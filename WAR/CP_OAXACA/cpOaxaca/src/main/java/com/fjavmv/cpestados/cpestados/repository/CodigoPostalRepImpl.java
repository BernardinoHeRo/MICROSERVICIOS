package com.fjavmv.cpestados.cpestados.repository;

import com.fjavmv.cpestados.cpestados.interfaces.ICodigoPostal;
import com.fjavmv.cpestados.cpestados.modell.CodigoPostal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import static com.fjavmv.cpestados.cpestados.repository.Sql.*;

@Service
public class CodigoPostalRepImpl implements ICodigoPostal {
	private final JdbcTemplate template;

	public CodigoPostalRepImpl(@Autowired JdbcTemplate template) {
		this.template = template;
	}

	@Override
	public List<Map<String, Object>> listar() {
		return template.queryForList(SQL_SELECT);
	}

	@Override
	public List<Map<String, Object>> searchPostalCode(Integer postalcode) {
		return template.queryForList(SQL_SEARCH_POSTAL_CODE,postalcode);
	}

	@Override
	public Integer add(CodigoPostal codigoPostal) {
		return template.update(SQL_INSERT, codigoPostal.getD_asenta(), codigoPostal.getD_mnpio(), codigoPostal.getD_estado(), codigoPostal.getD_ciudad(), codigoPostal.getD_codigo());
	}

	@Override
	public Integer edit(CodigoPostal codigoPostal) {
		return template.update(SQL_INSERT, codigoPostal.getD_asenta(), codigoPostal.getD_mnpio(), codigoPostal.getD_estado(), codigoPostal.getD_ciudad(), codigoPostal.getD_codigo(), codigoPostal.getIdcpoaxaca());
	}

	@Override
	public Integer delete(Integer id) {
		return template.update(SQL_DELETE, id);
	}
}
