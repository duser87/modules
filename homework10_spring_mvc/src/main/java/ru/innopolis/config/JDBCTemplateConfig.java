package ru.innopolis.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class JDBCTemplateConfig {
    public static JdbcTemplate jdbcTemplate(){
        var drv = new DriverManagerDataSource("jdbc:postgresql://localhost:5432/spring_mvc", "postgres", "admin");
        drv.setDriverClassName("org.postgresql.Driver");
        drv.setSchema("order");
        return new  JdbcTemplate(drv);
    }
}
