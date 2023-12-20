package com.caiovelp.charmakerbackend.repository;

import com.caiovelp.charmakerbackend.model.EquipamentoCarrinho;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EquipamentoCarrinhoRepository extends JpaRepository<EquipamentoCarrinho, Long> {
    List<EquipamentoCarrinho> findByCarrinhoId(Long carrinhoId);

    EquipamentoCarrinho findByEquipamentoIdAndCarrinhoId(Long equipamentoId, Long carrinhoId);

    @Transactional
    @Modifying
    @Query("DELETE FROM EquipamentoCarrinho ec WHERE ec.carrinho.Id = ?1")
    void deleteByCarrinhoId(Long carrinhoId);

    @Transactional
    @Modifying
    @Query("DELETE FROM EquipamentoCarrinho  ec WHERE ec.carrinho.Id = ?1 AND ec.equipamento.Id = ?2")
    void deleteByCarrinhoIdAndEquipamentoId(Long carrinhoId, Long equipamentoId);
}
