package ru.innopolis.repository;

import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import ru.innopolis.JDBCTemplateConfig;
import ru.innopolis.dto.Order;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;


@Component
public class OrderRepository {

    JdbcTemplate template = JDBCTemplateConfig.jdbcTemplate();

    private static final String CREATE = "INSERT INTO orders (id, article, quantity, sum) VALUES (?, ?, ?, ?)";
    private static final String COUNT = "SELECT COUNT(*) FROM orders";
    private static final String SUM = "SELECT AVG(sum) FROM orders";
    private static final String FINDALL = "SELECT * FROM orders";

    public void create(){
        List<Order> orders = template.query(FINDALL, orderRowMapper);
        Optional<Long> idRowLast = Optional.of(orders.stream().map(x -> x.getId()).reduce((x, y) -> y)).orElseThrow(NoSuchElementException::new);
        template.update(CREATE, idRowLast.get() + 1L, "E4", 1L, 7L);
       // return  List.of((Order) template.query("SELECT * FROM orders WHERE id = ?", orderRowMapper, idRowLast.get()));
    }

    @Bean
    public List<Order> orders(){
        return template.query(FINDALL, orderRowMapper);
    }

    @Bean
    public Long count(){
        return template.queryForObject(COUNT, Long.class);
    }

    @Bean
    public Double sum(){
        return template.queryForObject(SUM, Double.class);
    }


    private static final RowMapper<Order> orderRowMapper = (row, rowNumber) -> {
        Long id = row.getLong("id");
        String article = row.getString("article");
        Long guantity = row.getLong("quantity");
        Double sum = row.getDouble("sum");
        String data = row.getString("data");
        return new Order(id, article, guantity, sum, data);
    };

}
