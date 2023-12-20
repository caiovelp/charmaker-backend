package com.caiovelp.charmakerbackend.service;

import com.caiovelp.charmakerbackend.exception.EntidadeCadastradaException;
import com.caiovelp.charmakerbackend.exception.EntidadeNaoEncontradaException;
import com.caiovelp.charmakerbackend.model.Carrinho;
import com.caiovelp.charmakerbackend.repository.CarrinhoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class CarrinhoService {

    @Autowired
    private CarrinhoRepository carrinhoRepository;

    public  Carrinho getCarrinhoByPersonagemId(Long id) {
        try {
            return carrinhoRepository.findByPersonagemId(id);
        } catch (Exception e) {
            throw new EntidadeNaoEncontradaException("Personagem não encontrado");
        }
    }

    public Carrinho cadastrarCarrinho(Carrinho carrinho) {
        if(carrinho.getId() == null) {
            carrinho.setDatacadastro(LocalDate.now());
            return carrinhoRepository.save(carrinho);
        } else {
            throw new EntidadeCadastradaException("Tentando cadastrar um carrinho já cadastrado.");
        }
    }

    public void deleteCarrinho(Long id) {
        Carrinho carrinho = carrinhoRepository.findById(id)
                .orElseThrow(() -> new EntidadeNaoEncontradaException("Carrinho não encontrado."));
        carrinhoRepository.delete(carrinho);
    }
}
