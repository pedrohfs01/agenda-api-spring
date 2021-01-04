package com.pedrofernandes.agendaapi.services;

import com.pedrofernandes.agendaapi.entities.Contato;
import com.pedrofernandes.agendaapi.repository.ContatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContatoService {

    @Autowired
    private ContatoRepository repo;

    public Contato salvar(Contato contato){
        return repo.save(contato);
    }

    public void deletar(Integer id){
        repo.deleteById(id);
    }

    public List<Contato> listarTodos(){
        return repo.findAll();
    }

    public void favoritar(Integer id, Boolean favorito){
        Optional<Contato> contato = repo.findById(id);
        contato.ifPresent( c -> {
            c.setFavorito(favorito);
            repo.save(c);
        });
    }

}
