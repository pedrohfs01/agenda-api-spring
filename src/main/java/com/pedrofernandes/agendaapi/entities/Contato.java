package com.pedrofernandes.agendaapi.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Contato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;
    private String email;
    private Boolean favorito;

    @Lob
    private byte[] foto;
}
