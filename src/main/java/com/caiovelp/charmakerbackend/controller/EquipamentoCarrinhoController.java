package com.caiovelp.charmakerbackend.controller;

import com.caiovelp.charmakerbackend.model.EquipamentoCarrinho;
import com.caiovelp.charmakerbackend.service.EquipamentoCarrinhoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/equipamentoCarrinho")
public class EquipamentoCarrinhoController {

    @Autowired
    private EquipamentoCarrinhoService equipamentoCarrinhoService;

    @GetMapping("{idCarrinho}")
    public List<EquipamentoCarrinho > getEquipamentoCarrinhobyCarrinhoId(@PathVariable("idCarrinho") Long id) {
        return equipamentoCarrinhoService.getEquipamentoCarrinhobyCarrinhoId(id);
    }

    @PostMapping
    public void cadastrarEquipamentoCarrinho(@RequestBody EquipamentoCarrinho equipamentoCarrinho) {
        equipamentoCarrinhoService.cadastrarEquipamentoCarrinho(equipamentoCarrinho);
    }

    @PutMapping("/{equipamentoId}/{carrinhoId}/{novaQuantidade}")
    public void updateQuantidadeEquipamentoCarrinho(@PathVariable("equipamentoId") Long equipamentoId, @PathVariable("carrinhoId") Long carrinhoId, @PathVariable("novaQuantidade") Double novaQuantidade) {
        equipamentoCarrinhoService.updateQuantidadeEquipamentoCarrinho(equipamentoId, carrinhoId, novaQuantidade);
    }

    @DeleteMapping("/{carrinhoId}")
    public void deleteByCarrinhoId(@PathVariable("carrinhoId") Long carrinhoId) throws Exception {
        equipamentoCarrinhoService.deleteByCarrinhoId(carrinhoId);
    }

    @DeleteMapping("/{carrinhoId}/{equipamentoId}")
    public void deleteByCarrinhoIdAndEquipamentoId(@PathVariable("carrinhoId") Long carrinhoId, @PathVariable("equipamentoId") Long equipamentoId) throws Exception {
        equipamentoCarrinhoService.deleteByCarrinhoIdAndEquipamentoId(carrinhoId, equipamentoId);
    }
}
