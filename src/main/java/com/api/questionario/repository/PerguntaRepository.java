package com.api.questionario.repository;

import com.api.questionario.domain.Pergunta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PerguntaRepository extends JpaRepository<Pergunta, String> {
}
