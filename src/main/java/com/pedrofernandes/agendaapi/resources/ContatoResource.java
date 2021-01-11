package com.pedrofernandes.agendaapi.resources;

import com.pedrofernandes.agendaapi.entities.Contato;
import com.pedrofernandes.agendaapi.repository.ContatoRepository;
import com.pedrofernandes.agendaapi.services.ContatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Part;
import java.util.List;

@RestController
@RequestMapping("/api/contatos")
@CrossOrigin("*")
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
    public Page<Contato> listarTodos(
            @RequestParam(value = "page", defaultValue = "0") Integer pagina,
            @RequestParam(value = "size", defaultValue = "10") Integer tamanhoPagina
    ){
        Sort sort = Sort.by(Sort.Direction.ASC, "nome");
        PageRequest pageRequest = PageRequest.of(pagina, tamanhoPagina, sort);
        return service.listarTodos(pageRequest);
    }

    @PatchMapping("/{id}/favorito")
    public void favoritar(@PathVariable Integer id){
        service.favoritar(id);
    }

    @PutMapping("/{id}/foto")
    public byte[] addFoto(@PathVariable Integer id,
                          @RequestParam("foto")Part arquivo){
        return service.addFoto(id, arquivo);
    }
}
