package com.caiovelp.charmakerbackend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Inventario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "personagem_id")
    private Personagem personagem;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "inventario_id")
    private List<Equipamento> equipamentos;

    public Inventario(Personagem personagem) {
        this.personagem = personagem;
        this.equipamentos = new ArrayList<>();
    }
}
