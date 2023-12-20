package com.caiovelp.charmakerbackend.controller;

import com.caiovelp.charmakerbackend.model.Personagem;
import com.caiovelp.charmakerbackend.service.PersonagemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/personagens")
public class PersonagemController {

    @Autowired
    private PersonagemService personagemService;

    @GetMapping
    public List<Personagem> getPersonagens() { return personagemService.getPersonagens(); }

    @GetMapping("{idPersonagem}")
    public Personagem getPersonagemById(@PathVariable("idPersonagem") Long id) { return personagemService.getPersonagemById(id); }

    @PostMapping
    public Personagem cadastrarPersonagem(@RequestBody Personagem personagem) {
        return personagemService.cadastrarPersonagem(personagem);
    }

    @PutMapping
    public Personagem alterarPersonagem(@RequestBody Personagem personagem) {
        return personagemService.alterarPersonagem(personagem);
    }

    @DeleteMapping("{idPersonagem}")
    public void deletarPersonagem(@PathVariable("idPersonagem") Long id) throws Exception {
        personagemService.deletarPersonagem(id);
    }
}
