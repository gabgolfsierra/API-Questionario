package com.api.questionario.domain;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class Pergunta {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    private String descricao;
    private String id_questionario;
}
