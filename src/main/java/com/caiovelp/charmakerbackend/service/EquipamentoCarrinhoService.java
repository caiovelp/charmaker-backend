package com.caiovelp.charmakerbackend.service;

import com.caiovelp.charmakerbackend.exception.EntidadeCadastradaException;
import com.caiovelp.charmakerbackend.exception.EntidadeNaoEncontradaException;
import com.caiovelp.charmakerbackend.model.Carrinho;
import com.caiovelp.charmakerbackend.model.EquipamentoCarrinho;
import com.caiovelp.charmakerbackend.repository.CarrinhoRepository;
import com.caiovelp.charmakerbackend.repository.EquipamentoCarrinhoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EquipamentoCarrinhoService {

    @Autowired
    private EquipamentoCarrinhoRepository equipamentoCarrinhoRepository;

    @Autowired
    private CarrinhoRepository carrinhoRepository;

    public List<EquipamentoCarrinho> getEquipamentoCarrinhobyCarrinhoId(Long id) {
        try {
            return equipamentoCarrinhoRepository.findByCarrinhoId(id);
        } catch (Exception e) {
            throw new EntidadeNaoEncontradaException("Carrinho não encontrado");
        }
    }

    public void cadastrarEquipamentoCarrinho(EquipamentoCarrinho equipamentoCarrinho) {
        Long carrinhoId = equipamentoCarrinho.getCarrinho().getId();
        Carrinho carrinho = carrinhoRepository.findById(carrinhoId)
            .orElseThrow(() -> new EntidadeNaoEncontradaException("Carrinho não encontrado"));

        equipamentoCarrinho.setCarrinho(carrinho);

        EquipamentoCarrinho existingEquipamentoCarrinho = equipamentoCarrinhoRepository.findByEquipamentoIdAndCarrinhoId(equipamentoCarrinho.getEquipamento().getId(), carrinho.getId());

        if (existingEquipamentoCarrinho != null) {
            updateQuantidadeEquipamentoCarrinho(equipamentoCarrinho.getEquipamento().getId(), equipamentoCarrinho.getCarrinho().getId(), equipamentoCarrinho.getQuantidade());
        } else {
            equipamentoCarrinhoRepository.save(equipamentoCarrinho);
        }
    }

    public void updateQuantidadeEquipamentoCarrinho(Long equipamentoId, Long carrinhoId, Double novaQuantidade) {
        EquipamentoCarrinho existingEquipamentoCarrinho = equipamentoCarrinhoRepository.findByEquipamentoIdAndCarrinhoId(equipamentoId, carrinhoId);

        if (existingEquipamentoCarrinho != null) {
            existingEquipamentoCarrinho.setQuantidade(novaQuantidade);
            equipamentoCarrinhoRepository.save(existingEquipamentoCarrinho);
        } else {
            throw new EntidadeNaoEncontradaException("EquipamentoCarrinho não encontrado");
        }
    }

    public void deleteByCarrinhoId(Long carrinhoId) throws Exception {
        try {
            equipamentoCarrinhoRepository.deleteByCarrinhoId(carrinhoId);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public void deleteByCarrinhoIdAndEquipamentoId(Long carrinhoId, Long equipamentoId) throws Exception {
        try {
            equipamentoCarrinhoRepository.deleteByCarrinhoIdAndEquipamentoId(carrinhoId, equipamentoId);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
