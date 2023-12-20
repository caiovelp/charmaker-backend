package com.caiovelp.charmakerbackend.service;

import com.caiovelp.charmakerbackend.exception.EntidadeCadastradaException;
import com.caiovelp.charmakerbackend.model.Equipamento;
import com.caiovelp.charmakerbackend.repository.EquipamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EquipamentoService {

    @Autowired
    private EquipamentoRepository equipamentoRepository;

    public List<Equipamento> getEquipamentos() { return equipamentoRepository.findAll(); }

    public Equipamento cadastrarEquipamento(Equipamento equipamento) {
        if (equipamento.getId() == null) {
            return equipamentoRepository.save(equipamento);
        } else {
            throw new EntidadeCadastradaException("Tentando cadastrar um objeto já cadastrado.");
        }
    }
}
