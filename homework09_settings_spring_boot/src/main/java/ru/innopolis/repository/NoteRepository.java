package ru.innopolis.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import ru.innopolis.config.JDBCTemplateConfig;
import ru.innopolis.model.Note;

@Component
public class NoteRepository {
    JdbcTemplate template = JDBCTemplateConfig.jdbcTemplate();

    private static final String CREATE = "INSERT INTO notes (id, topic, text_notes) VALUES (?, ?, ?)";
    private static final String UPDATE_BY_ID = "UPDATE notes SET topic=? , text_notes=? WHERE id=?";
    private static final String DELETE_BY_ID = "DELETE FROM notes WHERE id=?";
    private static final String FIND_BY_ID = "SELECT * FROM notes WHERE id=?";

    public void create(Long id, String topic, String text){
        template.update(CREATE, id, topic, text);
    }


    public void update(Long id, String topic, String text){
        template.update(UPDATE_BY_ID, topic, text, id);
    }

    public void delete(Long id){
        template.update(DELETE_BY_ID, id);
    }

    public Note findById(Long id){
        return (Note)template.query(FIND_BY_ID, noteRowMapper, id);
    }

    private static final RowMapper<Note> noteRowMapper = (row, rowNumber) -> {
        Long id = row.getLong("id");
        String data = row.getString("data");
        String topic = row.getString("topic");
        String text_notes = row.getString("text_notes");
        return new Note(id, data, topic, text_notes);
    };
}
