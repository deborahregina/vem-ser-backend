package com.dbc.pessoaapi.repository;

import com.dbc.pessoaapi.client.DadosPessoaisClient;
import com.dbc.pessoaapi.dto.PessoaDTO;
import com.dbc.pessoaapi.entity.PessoaDadosPessoaisEntity;
import com.dbc.pessoaapi.entity.PessoaEntity;
import com.dbc.pessoaapi.exceptions.RegraDeNegocioException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Repository
public class PessoaRepository {
    private static List<PessoaEntity> listaPessoas = new ArrayList<>();
    private AtomicInteger COUNTER = new AtomicInteger();



//    public PessoaRepository() {
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy"); //18/10/2020
//        listaPessoas.add(new PessoaEntity(COUNTER.incrementAndGet() /*1*/, "Maicon Gerardi", LocalDate.parse("10/10/1990", formatter), "12345678910","deborah.regina@dbccompany.com.br"));
//        listaPessoas.add(new PessoaEntity(COUNTER.incrementAndGet() /*2*/, "Charles Pereira", LocalDate.parse("08/05/1985", formatter), "12345678911","deborah.regina@dbccompany.com.br"));
//        listaPessoas.add(new PessoaEntity(COUNTER.incrementAndGet() /*3*/, "Marina Oliveira", LocalDate.parse("30/03/1970", formatter), "12345678912","deborah.regina@dbccompany.com.br"));
//    }

    public PessoaEntity create(PessoaEntity pessoa) {
        pessoa.setIdPessoa(COUNTER.incrementAndGet());

        listaPessoas.add(pessoa);

        return pessoa;
    }

    public List<PessoaEntity> list() {
        return listaPessoas;
    }

    public PessoaEntity update(Integer id,
                               PessoaEntity pessoaAtualizar) throws RegraDeNegocioException {
        PessoaEntity pessoaRecuperada = listaPessoas.stream()
                .filter(pessoa -> pessoa.getIdPessoa().equals(id))
                .findFirst()
                .orElseThrow(() -> new RegraDeNegocioException("Pessoa não econtrada"));
        pessoaRecuperada.setCpf(pessoaAtualizar.getCpf());
        pessoaRecuperada.setNome(pessoaAtualizar.getNome());
        pessoaRecuperada.setDataNascimento(pessoaAtualizar.getDataNascimento());
        pessoaRecuperada.setEmail(pessoaAtualizar.getEmail());
        return pessoaRecuperada;
    }

    public PessoaEntity update(String cpf,
                               PessoaEntity pessoaAtualizar) throws RegraDeNegocioException {
        PessoaEntity pessoaRecuperada = listaPessoas.stream()
                .filter(pessoa -> pessoa.getCpf().equals(cpf))
                .findFirst()
                .orElseThrow(() -> new RegraDeNegocioException("Pessoa não econtrada"));
        pessoaRecuperada.setNome(pessoaAtualizar.getNome());
        pessoaRecuperada.setDataNascimento(pessoaAtualizar.getDataNascimento());
        pessoaRecuperada.setEmail(pessoaAtualizar.getEmail());
        return pessoaRecuperada;
    }

    public PessoaEntity update(PessoaEntity pessoaAtualizar) throws RegraDeNegocioException {
        PessoaEntity pessoaRecuperada = listaPessoas.stream()
                .filter(pessoa -> pessoa.getCpf().equals(pessoaAtualizar.getCpf()))
                .findFirst()
                .orElseThrow(() -> new RegraDeNegocioException("Pessoa não econtrada"));
        pessoaRecuperada.setNome(pessoaAtualizar.getNome());
        pessoaRecuperada.setDataNascimento(pessoaAtualizar.getDataNascimento());
        pessoaRecuperada.setEmail(pessoaAtualizar.getEmail());
        return pessoaRecuperada;
    }

    public void delete(Integer id) throws RegraDeNegocioException {
        PessoaEntity pessoaRecuperada = listaPessoas.stream()
                .filter(pessoa -> pessoa.getIdPessoa().equals(id))
                .findFirst()
                .orElseThrow(() -> new RegraDeNegocioException("Pessoa não econtrada"));
        listaPessoas.remove(pessoaRecuperada);
    }

    public void delete(String cpf) throws RegraDeNegocioException {
        PessoaEntity pessoaRecuperada = listaPessoas.stream()
                .filter(pessoa -> pessoa.getCpf().equals(cpf))
                .findFirst()
                .orElseThrow(() -> new RegraDeNegocioException("Pessoa não econtrada"));
        listaPessoas.remove(pessoaRecuperada);
    }

    public List<PessoaEntity> listByName(String nome) {
        return listaPessoas.stream()
                .filter(pessoa -> pessoa.getNome().toUpperCase().contains(nome.toUpperCase()))
                .collect(Collectors.toList());
    }

    public PessoaEntity getById(Integer id) throws Exception {
        return listaPessoas.stream()
                .filter(pessoa -> pessoa.getIdPessoa().equals(id))
                .findFirst()
                .orElseThrow(() -> new Exception("Pessoa não econtrada"));
    }

    public PessoaEntity getByCPF(String CPF) throws Exception {
        return listaPessoas.stream()
                .filter(pessoa -> pessoa.getIdPessoa().equals(CPF))
                .findFirst()
                .orElseThrow(() -> new Exception("Pessoa não econtrada"));
    }

}
