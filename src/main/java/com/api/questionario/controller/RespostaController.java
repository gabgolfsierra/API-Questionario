package com.api.questionario.controller;


import com.api.questionario.domain.Resposta;
import com.api.questionario.service.RespostaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RespostaController {

    @Autowired
    private RespostaService respostaService;

    @GetMapping("/questionario/{id}/respostas")
    public ResponseEntity<List<Resposta>> getRespostasByQuestionarioId(@PathVariable int id) {
        List<Resposta> respostas = respostaService.getRespostasByQuestionarioId(id);
        return ResponseEntity.ok(respostas);
    }

    @PostMapping("/questionario/{id}/resposta")
    public ResponseEntity<Resposta> addRespostaToQuestionario(@PathVariable int id, @RequestBody Resposta resposta) {
        Resposta novaResposta = respostaService.addRespostaToQuestionario(String.valueOf(id), resposta);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaResposta);
    }
}
