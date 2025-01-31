package ru.innopolis.config.profile;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import ru.innopolis.repository.NoteRepositoryInterface;
import ru.innopolis.repository.implementation.NoteRepositorySandImpl;

@Configuration
@Profile("sandbox")
public class RepositorySandConfig {
    @Bean
    public NoteRepositoryInterface getProfile(){
        return new NoteRepositorySandImpl();
    }
}
