package ru.innopolis.repository.impl;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import ru.innopolis.config.JDBCTamplateBuild;
import ru.innopolis.entity.Client;
import ru.innopolis.repository.ClientRepository;

import java.util.List;

public class ClientRepositoryImpl implements ClientRepository {

    private final JdbcTemplate jdbcTamplaeBuild = JDBCTamplateBuild.jdbcTamplate();

    private static final String GET_ALL =  "SELECT * FROM client";

    private static final String UPDATE_TEL_CLIENT =  "UPDATE client SET tel = ?, address = ? WHERE fio = ?";

    private static final String INSERT_CLIENT ="INSERT INTO client (id, fio, tel, address) VALUES (?, ?, ?, ?)";

    private static final String DELETE_CLIENT ="DELETE FROM client WHERE fio = ?";

    @Override
    public List<Client> getAll() {
        return jdbcTamplaeBuild.query(GET_ALL, clientRowMapper);
    }

    @Override
    public void updateClient(String tel, String address, String fio) {

        jdbcTamplaeBuild.update(UPDATE_TEL_CLIENT, tel, address, fio);

    }

    @Override
    public void addClient(Long id, String fio, String tel, String address) {

        jdbcTamplaeBuild.update(INSERT_CLIENT, id, fio, tel, address);

    }

    @Override
    public void deleteCLient(String fio) {

        jdbcTamplaeBuild.update(DELETE_CLIENT, fio);

    }


    private static final RowMapper<Client> clientRowMapper = (row, rowNumber) -> {

        Long id = row.getLong("id");
        String fio_client = row.getString("fio");
        String tel_client = row.getString("tel");
        String address_client = row.getString("address");

        return new Client(id, fio_client, tel_client, address_client);

    };

}
