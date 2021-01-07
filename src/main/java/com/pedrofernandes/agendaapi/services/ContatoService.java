package com.pedrofernandes.agendaapi.services;

import com.pedrofernandes.agendaapi.entities.Contato;
import com.pedrofernandes.agendaapi.repository.ContatoRepository;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.Part;
import java.io.IOException;
import java.io.InputStream;
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

    public void favoritar(Integer id){
        Optional<Contato> contato = repo.findById(id);
        contato.ifPresent( c -> {
            boolean favorito = c.getFavorito() == Boolean.TRUE;
            c.setFavorito(!favorito);
            repo.save(c);
        });
    }

    public byte[] addFoto(Integer id, Part arquivo) {
        Optional<Contato> contato = repo.findById(id);
        return contato.map( c -> {
            try{
                InputStream is = arquivo.getInputStream();
                byte[] bytes = new byte[(int) arquivo.getSize()];
                IOUtils.readFully(is, bytes);
                c.setFoto(bytes);
                repo.save(c);
                is.close();
                return bytes;
            }catch (IOException e){
                return null;
            }
        }).orElse(null);
    }
}
