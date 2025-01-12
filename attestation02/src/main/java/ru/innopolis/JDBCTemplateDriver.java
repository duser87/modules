package ru.innopolis;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class JDBCTemplateDriver {

    public static JdbcTemplate jdbcTemplate(){

        var drv = new DriverManagerDataSource("jdbc:postgresql://localhost:5432/medik", "postgres", "admin");

        drv.setDriverClassName("org.postgresql.Driver");

        drv.setSchema("medikschema");

        return new  JdbcTemplate(drv);

    }


}