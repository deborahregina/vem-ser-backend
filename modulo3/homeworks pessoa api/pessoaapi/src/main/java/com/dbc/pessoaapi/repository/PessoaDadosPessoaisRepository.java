package com.dbc.pessoaapi.repository;


import com.dbc.pessoaapi.dto.DadosPessoaisDTO;
import com.dbc.pessoaapi.dto.PessoaDadosPessoaisDTO;
import com.dbc.pessoaapi.entity.PessoaDadosPessoaisEntity;
import com.dbc.pessoaapi.entity.PessoaEntity;
import com.dbc.pessoaapi.exceptions.RegraDeNegocioException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class PessoaDadosPessoaisRepository {
    private static List<PessoaDadosPessoaisEntity> listaPessoaDados = new ArrayList<>();
    private AtomicInteger COUNTER = new AtomicInteger();


    public PessoaDadosPessoaisEntity create(PessoaDadosPessoaisEntity pessoaDadosPessoais) {
        pessoaDadosPessoais.setId(COUNTER.incrementAndGet());

        listaPessoaDados.add(pessoaDadosPessoais);

        return pessoaDadosPessoais;
    }

    public List<PessoaDadosPessoaisEntity> list() {

        return listaPessoaDados;

    }

    public PessoaDadosPessoaisEntity update(PessoaDadosPessoaisDTO pessoaDadosPessoaisDTO) throws RegraDeNegocioException {
        PessoaDadosPessoaisEntity pessoaRecuperada = listaPessoaDados.stream()
                .filter(pessoa -> pessoa.getCPF().equals(pessoaDadosPessoaisDTO.getCPF()))
                .findFirst()
                .orElseThrow(() -> new RegraDeNegocioException("Pessoa não econtrada"));
        pessoaRecuperada.setNome(pessoaRecuperada.getNome());
        pessoaRecuperada.setDataNascimento(pessoaRecuperada.getDataNascimento());
        pessoaRecuperada.setEmail(pessoaRecuperada.getEmail());
        return pessoaRecuperada;

    }

    public void delete(String cpf) throws RegraDeNegocioException {
        PessoaDadosPessoaisEntity pessoaRecuperada = listaPessoaDados.stream()
                .filter(pessoa -> pessoa.getCPF().equals(cpf))
                .findFirst()
                .orElseThrow(() -> new RegraDeNegocioException("Pessoa não econtrada"));
        listaPessoaDados.remove(pessoaRecuperada);
    }
}
