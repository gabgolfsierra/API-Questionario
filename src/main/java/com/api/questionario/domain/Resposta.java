package com.api.questionario.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;


@Getter
@Setter

public class Resposta {

    private int id_questionario;
    private int id_usuario;

    private Date data;


}
