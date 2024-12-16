package ru.innopolis.config;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class JDBCTamplateBuild {

//    var drv = new DriverManagerDataSource("jdbc:postgresql://localhost:5432/postgres", "postgres", "admin");
//        drv.setDriverClassName("org.postgresql.Driver");
//        drv.setSchema("homeworkJavaEE");
//    JdbcTemplate jdbcTemplate = new JdbcTemplate(drv);

    public static JdbcTemplate jdbcTamplate (){

        var drv = new DriverManagerDataSource("jdbc:postgresql://localhost:5432/postgres", "postgres", "admin");
        drv.setDriverClassName("org.postgresql.Driver");
        drv.setSchema("homeworkJavaEE");

        return new JdbcTemplate(drv);

    }

}
