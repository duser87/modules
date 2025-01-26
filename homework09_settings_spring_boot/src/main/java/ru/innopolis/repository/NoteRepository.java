package ru.innopolis.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import ru.innopolis.config.JDBCTemplateConfig;
import ru.innopolis.model.Note;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Component
public class NoteRepository {
    JdbcTemplate template = JDBCTemplateConfig.jdbcTemplate();

    private static final String CREATE = "INSERT INTO notes (id, topic, text_notes) VALUES (?, ?, ?)";
    private static final String UPDATE_BY_ID = "UPDATE notes SET topic=? , text_notes=? WHERE id=?";
    private static final String DELETE_BY_ID = "DELETE FROM notes WHERE id=?";
    private static final String FIND_BY_ID = "SELECT * FROM notes WHERE id=?";

    public void create(String topic, String text){
        List<Note> orders = template.query("SELECT * FROM notes", orderRowMapper);
        Optional<Long> idRowLast = Optional.of(orders.stream().map(x -> x.getId()).reduce((x, y) -> y)).orElseThrow(NoSuchElementException::new);
        template.update(CREATE, idRowLast.get()+1L, topic, text);
    }


    public void update(){

    }

    public void delete(){

    }

    public Note findById(){
        return new Note();
    }

    private static final RowMapper<Note> orderRowMapper = (row, rowNumber) -> {
        Long id = row.getLong("id");
        String data = row.getString("data");
        String topic = row.getString("topic");
        String text_notes = row.getString("text_notes");
        return new Note(id, data, topic, text_notes);
    };
}
