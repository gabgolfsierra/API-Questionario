package com.api.questionario.domain;


import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Usuario {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    private String login;
    private String senha;
}
