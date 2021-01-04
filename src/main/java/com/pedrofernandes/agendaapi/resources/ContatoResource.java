package com.pedrofernandes.agendaapi.resources;

import com.pedrofernandes.agendaapi.entities.Contato;
import com.pedrofernandes.agendaapi.repository.ContatoRepository;
import com.pedrofernandes.agendaapi.services.ContatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contatos")
public class ContatoResource {

    @Autowired
    private ContatoService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Contato salvar(@RequestBody Contato contato){
        return service.salvar(contato);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable Integer id){
        service.deletar(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Contato> listarTodos(){
        return service.listarTodos();
    }

    @PatchMapping("{id}/favorito")
    public void favoritar(@PathVariable Integer id, @RequestBody String favorito){
        service.favoritar(id, Boolean.getBoolean(favorito));
    }
}