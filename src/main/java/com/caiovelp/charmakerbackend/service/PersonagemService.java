package com.caiovelp.charmakerbackend.service;

import com.caiovelp.charmakerbackend.exception.EntidadeCadastradaException;
import com.caiovelp.charmakerbackend.exception.EntidadeNaoEncontradaException;
import com.caiovelp.charmakerbackend.exception.EntidadeTransienteException;
import com.caiovelp.charmakerbackend.model.Carrinho;
import com.caiovelp.charmakerbackend.model.Inventario;
import com.caiovelp.charmakerbackend.model.Personagem;
import com.caiovelp.charmakerbackend.repository.PersonagemRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class PersonagemService {

    @Autowired
    private PersonagemRepository personagemRepository;

    @Autowired
    private InventarioService inventarioService;

    @Autowired
    private EquipamentoCarrinhoService equipamentoCarrinhoService;

    @Autowired
    private CarrinhoService carrinhoService;

    public List<Personagem> getPersonagens() { return personagemRepository.findAll(); }

    public Personagem getPersonagemById(Long id)  {
        return personagemRepository.findById(id)
                .orElseThrow( () ->
                        new EntidadeNaoEncontradaException("Personagem não encontrado."));
    }

    public Personagem cadastrarPersonagem(Personagem personagem) {
        if (personagem.getId() == null) {
            personagem.setDatacadastro(LocalDate.now());
            return personagemRepository.save(personagem);
        } else {
            throw new EntidadeCadastradaException("Tentando cadastrar um personagem já cadastrado.");
        }
    }

    @Transactional
    public Personagem alterarPersonagem(Personagem personagem) {
        if(personagem.getId() != null) {
            personagemRepository.findById(personagem.getId())
                    .orElseThrow(() ->
                            new EntidadeNaoEncontradaException("Personagem não encontrado.")
                    );
            Personagem personagemExistente = personagemRepository.findById(personagem.getId()).get();
            personagem.setDatacadastro(personagemExistente.getDatacadastro());
            personagem.setClasse(personagemExistente.getClasse());
            personagem.setRaca(personagemExistente.getRaca());
            return personagemRepository.save(personagem);
        }
         else {
             throw new EntidadeTransienteException("Tentando alterar um objeto transiente.");
        }
    }

    public void deletarPersonagem(Long id) throws Exception {
        Personagem personagem = personagemRepository.findById(id)
                .orElseThrow(() ->
                        new EntidadeNaoEncontradaException("Personagem não encontrado.")
                );

        Inventario inventario = inventarioService.getInventarioByPersonagemId(id);
        Carrinho carrinho = carrinhoService.getCarrinhoByPersonagemId(id);

        inventarioService.deleteInventario(inventario.getId());
        equipamentoCarrinhoService.deleteByCarrinhoId(carrinho.getId());
        carrinhoService.deleteCarrinho(carrinho.getId());

        personagemRepository.deleteById(id);
    }
}
