package com.caiovelp.charmakerbackend.repository;

import com.caiovelp.charmakerbackend.model.Personagem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonagemRepository extends JpaRepository<Personagem, Long> {
}
