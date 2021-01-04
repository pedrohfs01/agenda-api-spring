package com.pedrofernandes.agendaapi.config;

import com.pedrofernandes.agendaapi.entities.Contato;
import com.pedrofernandes.agendaapi.repository.ContatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    ContatoRepository contatoRepository;

    @Override
    public void run(String... args) throws Exception {
        Contato c1 = new Contato();
        c1.setNome("José");
        c1.setEmail("jose@email.com");
        c1.setFavorito(true);

         contatoRepository.save(c1);
    }
}
