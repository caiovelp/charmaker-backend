package com.caiovelp.charmakerbackend.controller;

import com.caiovelp.charmakerbackend.model.Equipamento;
import com.caiovelp.charmakerbackend.service.EquipamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/equipamentos")
public class EquipamentoController {

    @Autowired
    private EquipamentoService equipamentoService;

    @GetMapping
    public List<Equipamento> getEquipamentos() { return equipamentoService.getEquipamentos(); }

    @PostMapping
    public Equipamento cadastrarEquipamento(@RequestBody Equipamento equipamento) {
        return equipamentoService.cadastrarEquipamento(equipamento);
    }
}
