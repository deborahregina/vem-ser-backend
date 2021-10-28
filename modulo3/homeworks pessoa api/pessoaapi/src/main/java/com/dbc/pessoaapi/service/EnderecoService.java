package com.dbc.pessoaapi.service;

import com.dbc.pessoaapi.entity.Contato;
import com.dbc.pessoaapi.entity.Endereco;
import com.dbc.pessoaapi.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;

    public Endereco create(Endereco endereco, Integer idPessoa) {
        return enderecoRepository.create(endereco, idPessoa);
    }

    public List<Endereco> list(){
        return enderecoRepository.list();
    }

    public Endereco listaEnd(Integer idEndereco) throws Exception {
        return enderecoRepository.listaEnd(idEndereco);
    }

    public List<Endereco> listByIdPessoa(Integer idPessoa) {
        return enderecoRepository.listByIdPessoa(idPessoa);
    }

    public Endereco update(Integer idEndereco,
                          Endereco enderecoAtualizar) throws Exception {
        return enderecoRepository.update(idEndereco, enderecoAtualizar);
    }

    public void delete(Integer id) throws Exception {
        enderecoRepository.delete(id);
    }
}
