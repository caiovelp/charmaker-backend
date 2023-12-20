package com.caiovelp.charmakerbackend.service;

import com.caiovelp.charmakerbackend.exception.EntidadeCadastradaException;
import com.caiovelp.charmakerbackend.model.Classe;
import com.caiovelp.charmakerbackend.repository.ClasseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClasseService {

    @Autowired
    private ClasseRepository classeRepository;

    public List<Classe> getClasses() {
        return classeRepository.findAll();
    }

    public Classe cadastrarClasse(Classe classe) {
        if (classe.getId() == null) {
            return classeRepository.save(classe);
        } else {
            throw new EntidadeCadastradaException("Tentando cadastrar uma classe já cadastrado.");
        }
    }
}
