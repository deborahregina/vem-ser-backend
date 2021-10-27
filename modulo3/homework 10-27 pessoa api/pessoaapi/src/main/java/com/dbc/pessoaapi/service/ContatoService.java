package com.dbc.pessoaapi.service;


import com.dbc.pessoaapi.entity.Contato;
import com.dbc.pessoaapi.entity.Pessoa;
import com.dbc.pessoaapi.repository.ContatoRepository;
import com.dbc.pessoaapi.repository.PessoaRepository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;


public class ContatoService {
    private ContatoRepository contatoRepository;

    public ContatoService() {
        contatoRepository = new ContatoRepository();
    }

    public Contato create(Contato contato, Integer idPessoa) {
        return contatoRepository.create(contato, idPessoa);
    }

    public List<Contato> list(){
        return contatoRepository.list();
    }

    public Contato update(Integer idContato,
                         Contato contatoAtualizar) throws Exception {
        return contatoRepository.update(idContato, contatoAtualizar);
    }

    public List<Contato> listByPessoa(Integer idPessoa) throws Exception {
        return contatoRepository.listByPessoa(idPessoa);
    }
    public void delete(Integer id) throws Exception {
        contatoRepository.delete(id);
    }
}