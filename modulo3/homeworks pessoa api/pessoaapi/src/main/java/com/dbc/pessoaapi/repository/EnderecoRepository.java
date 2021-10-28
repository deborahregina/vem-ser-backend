package com.dbc.pessoaapi.repository;


import com.dbc.pessoaapi.entity.*;
import com.dbc.pessoaapi.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Repository
public class EnderecoRepository {

    private static List<Endereco> listaEnderecos = new ArrayList<>();

    private AtomicInteger COUNTER = new AtomicInteger();

    @Autowired
    private PessoaService pessoaService;

    @PostConstruct
    public void inicializar() {
        List<Pessoa> listapessoas = pessoaService.list();
        listaEnderecos.add(new Endereco(COUNTER.incrementAndGet(),listapessoas.get(0).getIdPessoa(),TipoEndereco.ofTipo(1),"Av. Independência",200,"Ap 405","90460200","Porto Alegre","RS","Brasil"));
        listaEnderecos.add(new Endereco(COUNTER.incrementAndGet(),listapessoas.get(0).getIdPessoa(),TipoEndereco.ofTipo(1),"Av. Brasil",210,"Ap 45","20460200","Porto Alegre","RS","Brasil"));
        listaEnderecos.add(new Endereco(COUNTER.incrementAndGet(),listapessoas.get(1).getIdPessoa(),TipoEndereco.ofTipo(1),"Av. Central",200,"Ap 405","90460200","Canoas","RS","Brasil"));
        listaEnderecos.add(new Endereco(COUNTER.incrementAndGet(),listapessoas.get(2).getIdPessoa(),TipoEndereco.ofTipo(1),"Av. Venâncio Aires",210,"Ap 45","20460200","Esteio","RS","Brasil"));
    }


    public Endereco create(Endereco endereco, Integer idPessoa) {
        endereco.setIdEndereco(COUNTER.incrementAndGet());
        endereco.setIdPessoa(idPessoa);
        listaEnderecos.add(endereco);
        return endereco;
    }

    public List<Endereco> list() {
        return listaEnderecos;
    }

    public Endereco listaEnd(Integer idEndereco) throws Exception {
        return listaEnderecos.stream()
                .filter(endereco -> endereco.getIdEndereco().equals(idEndereco)).findFirst()
                .orElseThrow(() -> new Exception("Endereco não econtrado"));
    }

    public List<Endereco> listByIdPessoa(Integer idPessoa) {
        return listaEnderecos.stream().filter(endereco -> endereco.getIdPessoa().equals(idPessoa)).collect(Collectors.toList());
    }

    public Endereco update(Integer idEndereco,
                          Endereco enderecoAtualizar) throws Exception {
        Endereco enderecoRecuperado = listaEnderecos.stream()
                .filter(endereco -> endereco.getIdEndereco().equals(idEndereco))
                .findFirst()
                .orElseThrow(() -> new Exception("Endereco não econtrado"));
        enderecoRecuperado.setCep(enderecoAtualizar.getCep());
        enderecoRecuperado.setCidade(enderecoAtualizar.getCidade());
        enderecoRecuperado.setNumero(enderecoAtualizar.getNumero());
        enderecoRecuperado.setComplemento(enderecoAtualizar.getComplemento());
        enderecoRecuperado.setEstado(enderecoAtualizar.getEstado());
        enderecoRecuperado.setLogradouro(enderecoAtualizar.getLogradouro());
        enderecoRecuperado.setPais(enderecoAtualizar.getPais());

        return enderecoRecuperado;
    }

    public void delete(Integer id) throws Exception {
        Endereco enderecoRecuperado = listaEnderecos.stream()
                .filter(endereco -> endereco.getIdEndereco().equals(id))
                .findFirst()
                .orElseThrow(() -> new Exception("Endereco não econtrado"));
        listaEnderecos.remove(enderecoRecuperado);
    }
}
