package com.caiovelp.charmakerbackend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class EquipamentoCarrinho {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double quantidade;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "equipamento_id")
    private Equipamento equipamento;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "carrinho_id")
    private Carrinho carrinho;

    public EquipamentoCarrinho(Double quantidade, Equipamento equipamento, Carrinho carrinhoEquipamento) {
        this.quantidade = quantidade;
        this.equipamento = equipamento;
        this.carrinho = carrinhoEquipamento;
    }
}
