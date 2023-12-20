package com.caiovelp.charmakerbackend.service;

import com.caiovelp.charmakerbackend.exception.EntidadeCadastradaException;
import com.caiovelp.charmakerbackend.exception.EntidadeNaoEncontradaException;
import com.caiovelp.charmakerbackend.model.Equipamento;
import com.caiovelp.charmakerbackend.model.Inventario;
import com.caiovelp.charmakerbackend.repository.EquipamentoRepository;
import com.caiovelp.charmakerbackend.repository.InventarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class InventarioService {

    @Autowired
    private InventarioRepository inventarioRepository;

    @Autowired
    private EquipamentoRepository equipamentoRepository;

    public Inventario getInventarioByPersonagemId(Long personagemId) {
        return inventarioRepository.findByPersonagemId(personagemId)
                .orElseThrow(() -> new EntidadeNaoEncontradaException("Inventario não encontrado."));
    }

    public List<Equipamento> getEquipamentosOnInentarioByPersonagemId(Long personagemId) {
        Inventario inventario = inventarioRepository.findByPersonagemId(personagemId)
                .orElseThrow(() -> new EntidadeNaoEncontradaException("Inventario não encontrado."));
        return inventario.getEquipamentos();
    }

    public Inventario cadastrarInventario(Inventario inventario) {
        if(inventario.getId() == null) {
            return inventarioRepository.save(inventario);
        } else {
            throw new EntidadeCadastradaException("Tentando cadastrar um inventario já cadastrado.");
        }
    }

    public Inventario adicionarEquipamentos(Long personagemId, List<Equipamento> equipamentos) {
        Inventario inventario = inventarioRepository.findByPersonagemId(personagemId)
                .orElseThrow(() -> new EntidadeNaoEncontradaException("Inventario não encontrado."));

        List<Equipamento> managedEquipamentos = equipamentos.stream()
                .map(equipamento -> equipamentoRepository.findById(equipamento.getId())
                        .orElseThrow(() -> new EntidadeNaoEncontradaException("Equipamento não encontrado.")))
                .collect(Collectors.toList());

        inventario.getEquipamentos().addAll(managedEquipamentos);
        return inventarioRepository.save(inventario);
    }

    public void deleteInventario(Long id) {
        Inventario inventario = inventarioRepository.findById(id)
                .orElseThrow(() -> new EntidadeNaoEncontradaException("Inventario não encontrado."));
        inventarioRepository.delete(inventario);
    }
}
