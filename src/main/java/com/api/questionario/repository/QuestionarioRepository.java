package com.api.questionario.repository;

import com.api.questionario.domain.Questionario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionarioRepository extends JpaRepository<Questionario, String> {
}
