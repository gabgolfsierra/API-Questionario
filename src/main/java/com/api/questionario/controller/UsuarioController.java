package com.api.questionario.controller;


import com.api.questionario.domain.Usuario;
import com.api.questionario.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {


    @Autowired
    private UsuarioRepository usuarioRepository;


    @GetMapping
    public List<Usuario> getAllUsuarios(){
       return usuarioRepository.findAll();
    }

    @PostMapping("/usuario")
    public Usuario insertUsuario(@RequestBody Usuario usuario){

        return usuarioRepository.save(usuario);
    }

    @PutMapping("/usuario/{id}")
    public Usuario editUsuario(@PathVariable String id, @RequestBody Usuario usuario){

        Usuario novoUsuario = usuarioRepository.findById(id).orElseThrow(() ->
                new RuntimeException("User not found")
        );

        novoUsuario.setLogin(usuario.getLogin());
        novoUsuario.setSenha(usuario.getSenha());
        return usuarioRepository.save(novoUsuario);

    }

@DeleteMapping("/usuario/{id}")
    public void deleteUsuario(@PathVariable String id){
        usuarioRepository.deleteById(id);
}



}
