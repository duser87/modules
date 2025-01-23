package ru.innopolis.repository;

import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Component;
import ru.innopolis.JDBCTemplateConfig;
import ru.innopolis.dto.Order;

import java.util.List;

@Component
public class OrderRepository {

    JdbcTemplate template = JDBCTemplateConfig.jdbcTemplate();

    private static final String COUNT = "SELECT COUNT(*) FROM orders";
    private static final String SUM = "SELECT SUM(sum) FROM orders";
    private static final String FINDALL = "SELECT * FROM orders";

    @Bean
    public List<Order> getOrders(){
        return template.query(FINDALL, orderRowMapper);
    }

    public Long getCountOrders(){
        return template.queryForObject(COUNT, Long.class);
    }

    public Long getSumOrders(){
        return template.queryForObject(SUM, Long.class);
    }


    private static final RowMapper<Order> orderRowMapper = (row, rowNumber) -> {

        Long id = row.getLong("id");
        String name = row.getString("name");
        Long guantity = row.getLong("quantity");
        Long sum = row.getLong("sum");

        return new Order(id, name, guantity, sum);

    };

}
