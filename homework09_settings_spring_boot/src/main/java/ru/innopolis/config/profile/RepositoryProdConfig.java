package ru.innopolis.config.profile;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import ru.innopolis.repository.NoteRepositoryInterface;
import ru.innopolis.repository.implementation.NoteRepositoryProdImpl;

@Configuration
@Profile("production")
public class RepositoryProdConfig {

    @Bean
    public NoteRepositoryInterface getProfile(){
        return new NoteRepositoryProdImpl();
    }

}
