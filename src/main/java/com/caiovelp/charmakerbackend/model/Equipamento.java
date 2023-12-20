package com.caiovelp.charmakerbackend.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Equipamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String tipo;
    private Double valor;
    private Double peso;
    @Column(length = 1500)
    private String descricao;

    public Equipamento(String nome, String tipo, Double valor, Double peso, String descricao) {
        this.nome = nome;
        this.tipo = tipo;
        this.valor = valor;
        this.peso = peso;
        this.descricao = descricao;
    }
}
