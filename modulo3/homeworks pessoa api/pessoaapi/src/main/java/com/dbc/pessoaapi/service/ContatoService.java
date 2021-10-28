package com.dbc.pessoaapi.service;


import com.dbc.pessoaapi.entity.Contato;
import com.dbc.pessoaapi.entity.Pessoa;
import com.dbc.pessoaapi.exceptions.RegraDeNegocioException;
import com.dbc.pessoaapi.repository.ContatoRepository;
import com.dbc.pessoaapi.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;


@Service
public class ContatoService {

    @Autowired
    private ContatoRepository contatoRepository;


    public Contato create(Contato contato, Integer idPessoa) throws RegraDeNegocioException {
        return contatoRepository.create(contato, idPessoa);
    }

    public List<Contato> list(){
        return contatoRepository.list();
    }

    public Contato update(Integer idContato,
                         Contato contatoAtualizar) throws RegraDeNegocioException {
        return contatoRepository.update(idContato, contatoAtualizar);
    }

    public List<Contato> listByPessoa(Integer idPessoa) throws RegraDeNegocioException {
        return contatoRepository.listByPessoa(idPessoa);
    }
    public void delete(Integer id) throws RegraDeNegocioException {
        contatoRepository.delete(id);
    }
}