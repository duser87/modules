package ru.innopolis.repository.implementation;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.JdbcClient;
import ru.innopolis.JDBCTemplateDriver;
import ru.innopolis.exceptions.ErrorWritingDbById;
import ru.innopolis.exceptions.NoRecordRowDB;
import ru.innopolis.model.Position;
import ru.innopolis.repository.PositionRepository;

import java.util.List;
import java.util.Optional;

public class PositionRepoImpl implements PositionRepository {

    JdbcTemplate template = JDBCTemplateDriver.jdbcTemplate();
    JdbcClient templateClient = JdbcClient.create(JDBCTemplateDriver.jdbcTemplate());

    private static final String CREATE = "INSERT INTO positions (id, position) VALUES (?, ?)";

    private static final String FINDBYID = "SELECT * FROM positions WHERE id = ?";

    private static final String FINDALL = "SELECT * FROM positions";

    private static final String UPDATE = "UPDATE positions SET position = ? WHERE id = ?";

    private static final String DELETEBYID = "DELETE FROM positions WHERE id = ?";

    private static final String DELETEALL = "DELETE FROM positions";

    @Override
    public void create(Long id, String pos) throws ErrorWritingDbById {

        try{

            template.update(CREATE, id, pos);

        }
        catch (Exception e){

            throw new ErrorWritingDbById(" -!- Не удалось создать запись с ID = " + id + " . Возможно запись с таким ID уже существует");

        }

    }

    @Override
    public Optional<Position> findById(Long id) {
        return templateClient.sql(FINDBYID)
                .param(id)
                .query(Position.class)
                .optional();
    }

    @Override
    public List<Position> findAll() {
        return template.query(FINDALL, positionRowMapper);
    }

    @Override
    public String update(Object id, Object pos){

        Long rowCount;
        String str;

        Optional<Boolean> id_p = Optional.of(id instanceof Long);
        if(!id_p.get()) { throw  new IllegalArgumentException(" -!- Тип передаваемого параметра id не соответствует заданному"); }

        Optional<Boolean> pos_p = Optional.of(pos instanceof String);
        if(!pos_p.get()) { throw  new IllegalArgumentException(" -!- Тип передаваемого параметра position не соответствует заданному"); }


        rowCount = template.queryForObject("SELECT COUNT(*) FROM positions WHERE id = ?", Long.class, id);

        if(rowCount != 0L){

            template.update(UPDATE, pos, id);
            str = "Обновлена запись с ID = " + id;

        }
        else {

            template.update(CREATE, id, pos);
            str = "Добавлена запись с ID = " + id;

        }

        return str;

    }

    @Override
    public String deleteById(Long id) throws NoRecordRowDB {

        String str;

        List<Position> listPat = template.query(FINDALL, positionRowMapper);

        Optional<Long> result = Optional.of(listPat.stream().filter(el -> el.getId().equals(id)).count());

        if(result.get() != 0){

            template.update(DELETEBYID, id);

            str = "Запись с ID = " + id + " удалена...";

        }
        else {

            throw  new NoRecordRowDB("-!- Запись с ID = " + id + " нет!");

        }

        return str;

    }

    @Override
    public String deleteAll() {

        template.update(DELETEALL);

        return "Все записи из таблицы Positions удалены...";

    }

    @Override
    public Long count() {

        List<Position> listPos = template.query(FINDALL, positionRowMapper);

        return Long.valueOf(listPos.size());

    }

    private static final RowMapper<Position> positionRowMapper = (row, rowNumber) -> {

        Long id = row.getLong("id");
        String pos = row.getString("position");

        return new Position(id, pos);

    };

}
