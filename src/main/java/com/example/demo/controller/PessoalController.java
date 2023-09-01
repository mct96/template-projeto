package com.example.demo.controller;

import com.example.demo.dao.PessoaRepository;
import com.example.demo.pessoa.Pessoa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PessoalController {
    @Autowired private PessoaRepository pessoaRepository;

    public Pessoa criarPessoa(Pessoa pessoa) {
        pessoa.setId(null);
        return this.pessoaRepository.save(pessoa);
    }

    public Pessoa buscarPessoa(Long id) {
        return this.pessoaRepository.findById(id).orElse(null);
    }

    public Pessoa atualizarPessoa(Long id, Pessoa dadosNovos) {
        Pessoa dadosAtuais = this.buscarPessoa(id);
        dadosAtuais.setNome(dadosNovos.getNome());
        dadosAtuais.setCpf(dadosNovos.getCpf());
        dadosAtuais.setEndereco(dadosNovos.getEndereco());
        dadosAtuais.setEmail(dadosNovos.getEmail());
        dadosAtuais.setTelefone(dadosNovos.getTelefone());
        return this.pessoaRepository.save(dadosAtuais);
    }

    public void removerPessoa(Long id) {
        this.pessoaRepository.deleteById(id);
    }

    public List<Pessoa> listarPessoas() {
        return this.pessoaRepository.findAll();
    }
}
