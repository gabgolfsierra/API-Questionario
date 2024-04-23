package com.api.questionario.repository;

import com.api.questionario.domain.Pergunta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface PerguntaRepository extends JpaRepository<Pergunta, String> {
    @Modifying
    @Query("DELETE FROM Perguntas p WHERE p.questionario.id = ?1")
    void deleteByQuestionarioId(String questionarioId);
}
