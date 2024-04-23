package com.api.questionario.controller;

import com.api.questionario.domain.Pergunta;
import com.api.questionario.domain.Questionario;
import com.api.questionario.repository.PerguntaRepository;
import com.api.questionario.repository.QuestionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@RestController
public class QuestionarioController {

    @Autowired
    QuestionarioRepository QuestionarioRepository;

    @Autowired
    private PerguntaRepository perguntaRepository;

    @GetMapping
    public List<Questionario> getALlQuestionario(){
        return QuestionarioRepository.findAll();
    }

    @PostMapping
    public Questionario insertQuestionario(@RequestBody Questionario request) {
        Questionario questionario = new Questionario();
        questionario.setNome(request.getNome());
        questionario.setDescricao(request.getDescricao());
        questionario.setData_criacao(Timestamp.valueOf(LocalDateTime.now()));

        // Salvando o questionário
        Questionario savedQuestionario = QuestionarioRepository.save(questionario);

        // Salvando as perguntas associadas ao questionário
        for (String perguntaTexto : request.getPerguntas()) {
            Pergunta pergunta = new Pergunta();
            perguntaRepository.save(pergunta);
        }

        return savedQuestionario;
    }

    @PutMapping("/{id}")
    public Questionario editQuestionario(@PathVariable String id, @RequestBody Questionario request) {
        Questionario questionario = QuestionarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Questionário não encontrado"));


        questionario.setNome(request.getNome());
        questionario.setDescricao(request.getDescricao());


        perguntaRepository.deleteByQuestionarioId(questionario.getId());

        // Adicionando as novas perguntas
        for (String perguntaTexto : request.getPerguntas()) {
            Pergunta pergunta = new Pergunta();
            perguntaRepository.save(pergunta);
        }

        return QuestionarioRepository.save(questionario);
    }


    @DeleteMapping("/questionario/{id}")
    public void deleteQuestionario(@PathVariable String id){
        QuestionarioRepository.deleteById(id);
    }

}
