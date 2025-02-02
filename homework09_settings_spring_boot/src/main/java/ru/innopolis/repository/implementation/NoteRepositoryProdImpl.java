package ru.innopolis.repository.implementation;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;
import ru.innopolis.config.JDBCTemplateConfig;
import ru.innopolis.model.Note;
import ru.innopolis.repository.NoteRepositoryInterface;

import java.util.Optional;

@Repository
public class NoteRepositoryProdImpl implements NoteRepositoryInterface {
    JdbcTemplate template = JDBCTemplateConfig.jdbcTemplate();
    JdbcClient templateClient = JdbcClient.create(JDBCTemplateConfig.jdbcTemplate());

    private static final String CREATE = "INSERT INTO note.notes (id, topic, text_notes) VALUES (?, ?, ?)";
    private static final String UPDATE_BY_ID = "UPDATE note.notes SET topic=? , text_notes=? WHERE id=?";
    private static final String DELETE_BY_ID = "DELETE FROM note.notes WHERE id=?";
    private static final String FIND_BY_ID = "SELECT * FROM note.notes WHERE id=?";

    @Override
    public void create(Long id, String topic, String text){
        template.update(CREATE, id, topic, text);
    }

    @Override
    public void update(Long id, String topic, String text){
        template.update(UPDATE_BY_ID, topic, text, id);
    }

    @Override
    public void delete(Long id){
        template.update(DELETE_BY_ID, id);
    }

    @Override
    public Optional<Note> findById(Long id){
        return templateClient.sql(FIND_BY_ID).param(id).query(Note.class).optional();
    }

    private static final RowMapper<Note> noteRowMapper = (row, rowNumber) -> {
        Long id = row.getLong("id");
        String topic = row.getString("topic");
        String text_notes = row.getString("text_notes");
        return new Note(id, topic, text_notes);
    };
}
