package com.api.questionario.service;
import com.api.questionario.domain.Questionario;
import com.api.questionario.domain.Resposta;
import com.api.questionario.repository.QuestionarioRepository;
import com.api.questionario.repository.RespostaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

    @Service
    public class RespostaService {

        @Autowired
        private RespostaRepository respostaRepository;

        @Autowired
        private QuestionarioRepository questionarioRepository;

        public List<Resposta> getRespostasByQuestionarioId(int questionarioId) {
            return respostaRepository.findByQuestionarioId(questionarioId);
        }

        public Resposta addRespostaToQuestionario(String id, Resposta resposta) {
            Questionario questionario = questionarioRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Questionário não encontrado com o ID: " + id));

            resposta.setId_questionario(Integer.parseInt(questionario.getId()));
            return respostaRepository.save(resposta);
        }
    }

