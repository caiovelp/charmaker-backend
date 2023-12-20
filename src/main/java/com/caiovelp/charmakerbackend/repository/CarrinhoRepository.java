package com.caiovelp.charmakerbackend.repository;

import com.caiovelp.charmakerbackend.model.Carrinho;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface CarrinhoRepository extends JpaRepository<Carrinho, Long> {
    Carrinho findByPersonagemId(Long personagemId);
}
