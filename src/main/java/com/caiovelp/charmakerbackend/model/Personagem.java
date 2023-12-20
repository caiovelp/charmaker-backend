package com.caiovelp.charmakerbackend.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler"})
@Data
@NoArgsConstructor
@Entity
public class Personagem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @ManyToOne
    @JoinColumn(name="raca_id")
    private Race raca;

    @ManyToOne
    @JoinColumn(name="classe_id")
    private Classe classe;

    private Integer nivel;

    @Column(name="DATA_CADASTRO")
    private LocalDate datacadastro;

    @JsonManagedReference
    @OneToOne(mappedBy = "personagem")
    private Carrinho carrinhoEquipamento;

    public Personagem(String nome, Race raca, Classe classe, Integer nivel, LocalDate datacadastro, Carrinho carrinhoEquipamento) {
        this.nome = nome;
        this.raca = raca;
        this.classe = classe;
        this.nivel = nivel;
        this.datacadastro = datacadastro;
        this.carrinhoEquipamento = carrinhoEquipamento;
    }
}
