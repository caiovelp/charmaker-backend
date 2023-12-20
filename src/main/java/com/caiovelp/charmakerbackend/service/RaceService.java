package com.caiovelp.charmakerbackend.service;

import com.caiovelp.charmakerbackend.exception.EntidadeCadastradaException;
import com.caiovelp.charmakerbackend.exception.EntidadeNaoEncontradaException;
import com.caiovelp.charmakerbackend.model.Race;
import com.caiovelp.charmakerbackend.repository.RaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RaceService {

    @Autowired
    private RaceRepository raceRepository;

    public List<Race> getRaces() { return raceRepository.findAll(); }

    public Race getRaceById(Long id) {
        return raceRepository.findById(id)
                .orElseThrow( () ->
                        new EntidadeNaoEncontradaException("Raça não encontrada"));
    }

    public Race cadastrarRace(Race race) {
        if (race.getId() == null) {
            return raceRepository.save(race);
        } else {
            throw new EntidadeCadastradaException("Tentando cadastrar uma raça já cadastrado.");
        }
    }
}
