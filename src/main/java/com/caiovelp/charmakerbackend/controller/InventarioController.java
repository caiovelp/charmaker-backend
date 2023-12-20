package com.caiovelp.charmakerbackend.controller;

import com.caiovelp.charmakerbackend.model.Equipamento;
import com.caiovelp.charmakerbackend.model.Inventario;
import com.caiovelp.charmakerbackend.service.InventarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inventario")
public class InventarioController {

    @Autowired
    private InventarioService inventarioService;

    @GetMapping("/{personagemId}")
    public List<Equipamento> getEquipamentosOnInentarioByPersonagemId(@PathVariable Long personagemId) {
        return inventarioService.getEquipamentosOnInentarioByPersonagemId(personagemId);
    }

    @PostMapping
    public void cadastrarInventario(@RequestBody Inventario inventario) { inventarioService.cadastrarInventario(inventario);}

    @PutMapping("/{id}")
    public Inventario adicionarEquipamentos(@PathVariable Long id, @RequestBody List<Equipamento> equipamentos) {return inventarioService.adicionarEquipamentos(id, equipamentos);}
}
