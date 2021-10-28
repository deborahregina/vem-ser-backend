package com.dbc.pessoaapi.service;

import com.dbc.pessoaapi.entity.Pessoa;
import com.dbc.pessoaapi.repository.PessoaRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PessoaService {

    private PessoaRepository pessoaRepository;

    public PessoaService(){
        pessoaRepository = new PessoaRepository();
    }

    public Pessoa create(Pessoa pessoa) throws Exception {
        if(StringUtils.isBlank(pessoa.getNome())) {
            throw new Exception("Nome não informado");
        }
        if (ObjectUtils.isEmpty(pessoa.getDataNascimento())) {
            throw new Exception("Data de nascimento não informado");
        }
        if (StringUtils.isBlank(pessoa.getCpf()) || pessoa.getCpf().length() != 11) {
            throw new Exception("CPF inválido");
        }

        return pessoaRepository.create(pessoa);
    }

    public List<Pessoa> list(){
        return pessoaRepository.list();
    }

    public Pessoa update(Integer id,
                         Pessoa pessoaAtualizar) throws Exception {
        return pessoaRepository.update(id, pessoaAtualizar);
    }

    public void delete(Integer id) throws Exception {
        pessoaRepository.delete(id);
    }

    public List<Pessoa> listByName(String nome) {
        return pessoaRepository.listByName(nome);
    }
}
