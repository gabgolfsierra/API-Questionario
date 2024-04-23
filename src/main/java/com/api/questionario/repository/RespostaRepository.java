package com.api.questionario.repository;

import com.api.questionario.domain.Resposta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface RespostaRepository extends JpaRepository<Resposta, Long> {
    List<Resposta> findByQuestionarioId(int questionarioId);
}
