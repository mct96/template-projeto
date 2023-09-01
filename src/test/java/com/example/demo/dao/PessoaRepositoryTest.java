package com.example.demo.dao;

import com.example.demo.model.Pessoa;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class PessoaRepositoryTest {
    private final PessoaRepository pessoaRepository;

    @Autowired
    PessoaRepositoryTest(PessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }

    @Test()
    public void inserirPessoa() {
        Pessoa pessoa = new Pessoa();
        pessoa.setNome("Maria");
        pessoa.setCpf("12345678901");
        pessoa.setEmail("pessoa@gmail.com");
        pessoa.setTelefone("12345-6789");
        pessoa.setEndereco("Rua 1, 123");

        this.pessoaRepository.save(pessoa);
    }

    @Test
    public void listarPessoas() {
        List<Pessoa> pessoas = this.pessoaRepository.findAll();
        for (Pessoa pessoa : pessoas) {
            System.out.print("ID: ");
            System.out.println(pessoa.getId());

            System.out.print("Nome: ");
            System.out.println(pessoa.getNome());

            System.out.print("CPF: ");
            System.out.println(pessoa.getCpf());

            System.out.print("E-mail: ");
            System.out.println(pessoa.getEmail());

            System.out.print("Telefone: ");
            System.out.println(pessoa.getTelefone());

            System.out.print("Endereço: ");
            System.out.println(pessoa.getEndereco());
        }
    }
}