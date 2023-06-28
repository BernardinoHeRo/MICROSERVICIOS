package com.coffeeandcode.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.init.DataSourceInitializer;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;

import javax.sql.DataSource;
@Configuration
public class DatabaseConfiguration {

	@Value("classpath:static/sql/1cat_estados-data.sql")
	private org.springframework.core.io.Resource estadosScript;

	@Value("classpath:static/sql/2cat_municipios-data.sql")
	private org.springframework.core.io.Resource municipiosScript;

	@Value("classpath:static/sql/3cat_cp-data.sql")
	private org.springframework.core.io.Resource cpScript;

	@Value("classpath:static/sql/Tablas normalizadas.sql")
	private org.springframework.core.io.Resource tables;
	@Bean
	public DataSourceInitializer dataSourceInitializer(DataSource dataSource, JdbcTemplate jdbcTemplate) {
		DataSourceInitializer initializer = new DataSourceInitializer();
		initializer.setDataSource(dataSource);

		ResourceDatabasePopulator databasePopulator = new ResourceDatabasePopulator();
		//databasePopulator.addScript(tables);
		databasePopulator.addScript(estadosScript);
		databasePopulator.addScript(municipiosScript);
		databasePopulator.addScript(cpScript);

		// Verificar si todas las tablas están vacías

		if (areAllTablesEmpty(jdbcTemplate)) {
			initializer.setDatabasePopulator(databasePopulator); // Establecer el populador de base de datos
		} else {
			// Las tablas ya contienen datos, no se ejecutarán los scripts
			System.out.println("Las tablas ya contienen datos. No se ejecutarán los scripts de inicialización.");
		}

		return initializer;
	}
	private boolean areAllTablesEmpty(JdbcTemplate jdbcTemplate) {
		try {
			// Verificar si todas las tablas están vacías
			String query = "SELECT COUNT(*) FROM cat_estados";
			Integer count = jdbcTemplate.queryForObject(query, Integer.class);
			return count != null && count == 0;
		} catch (Exception e) {
			return true; // Se produce una excepción si la tabla no existe, se considera como vacía
		}
	}
}
