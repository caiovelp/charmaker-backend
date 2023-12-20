package com.caiovelp.charmakerbackend.controller;

import com.caiovelp.charmakerbackend.model.Carrinho;
import com.caiovelp.charmakerbackend.service.CarrinhoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/carrinho")
public class CarrinhoController {

    @Autowired
    private CarrinhoService carrinhoService;

    @GetMapping("{idPersonagem}")
    public Carrinho getCarrinhoByPersonagemId(@PathVariable("idPersonagem") Long id) { return carrinhoService.getCarrinhoByPersonagemId(id); }

    @PostMapping
    public Carrinho cadastrarCarrinho(@RequestBody Carrinho carrinho) { return carrinhoService.cadastrarCarrinho(carrinho);}
}
