package com.api.questionario.controller;

import com.api.questionario.domain.Questionario;
import com.api.questionario.repository.QuestionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class QuestionarioController {

    @Autowired
    QuestionarioRepository QuestionarioRepository;
    @GetMapping
    public List<Questionario> getALlQuestionario(){
        return QuestionarioRepository.findAll();
    }

    @PostMapping
    public Questionario insertQuestionario(@RequestBody Questionario questionario){
            return QuestionarioRepository.save(questionario);
    }

    @PutMapping("/questionario{id}")
    public Questionario editQuestionario(@PathVariable String id, @RequestBody Questionario questionario){
        Questionario novoQuestionario = QuestionarioRepository.findById(id).orElseThrow(() ->
                new RuntimeException("not found")
                );
        novoQuestionario.setNome(questionario.getNome());
        novoQuestionario.setDescricao(questionario.getDescricao());
        novoQuestionario.setData_criacao(questionario.getData_criacao());
        return QuestionarioRepository.save(novoQuestionario);
    }


    @DeleteMapping("/questionario/{id}")
    public void deleteQuestionario(@PathVariable String id){
        QuestionarioRepository.deleteById(id);
    }

}
