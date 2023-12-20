package com.caiovelp.charmakerbackend.controller;

import com.caiovelp.charmakerbackend.model.Classe;
import com.caiovelp.charmakerbackend.service.ClasseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/classe")
public class ClasseController {

    @Autowired
    private ClasseService classeService;

    @GetMapping
    public List<Classe> getClasses() { return classeService.getClasses(); }

    @PostMapping
    public Classe cadastrarClasse(@RequestBody Classe classe) { return classeService.cadastrarClasse(classe); }
}
