package com.api.questionario.domain;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class Questionario {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    private String nome;
    private String descricao;
    private Timestamp data_criacao;
    private String id_usuario_criacao;
    private List<String> perguntas;

    public Questionario() {

    }
}
