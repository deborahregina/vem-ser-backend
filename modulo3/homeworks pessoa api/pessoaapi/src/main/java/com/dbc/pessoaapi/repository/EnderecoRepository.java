package com.dbc.pessoaapi.repository;


import com.dbc.pessoaapi.dto.PessoaDTO;
import com.dbc.pessoaapi.entity.*;
import com.dbc.pessoaapi.exceptions.RegraDeNegocioException;
import com.dbc.pessoaapi.service.PessoaService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class EnderecoRepository {

    private static List<EnderecoEntity> listaEnderecos = new ArrayList<>();

    private AtomicInteger COUNTER = new AtomicInteger();

    @Autowired
    private final PessoaService pessoaService;

    @PostConstruct
    public void inicializar() {
        List<PessoaDTO> listapessoas = pessoaService.list();
        listaEnderecos.add(new EnderecoEntity(COUNTER.incrementAndGet(),listapessoas.get(0).getIdPessoa(),TipoEndereco.RESIDENCIAL,"Av. Independência",200,"Ap 405","90460200","Porto Alegre","RS","Brasil"));
        listaEnderecos.add(new EnderecoEntity(COUNTER.incrementAndGet(),listapessoas.get(0).getIdPessoa(),TipoEndereco.RESIDENCIAL,"Av. Brasil",210,"Ap 45","20460200","Porto Alegre","RS","Brasil"));
        listaEnderecos.add(new EnderecoEntity(COUNTER.incrementAndGet(),listapessoas.get(1).getIdPessoa(),TipoEndereco.RESIDENCIAL,"Av. Central",200,"Ap 405","90460200","Canoas","RS","Brasil"));
        listaEnderecos.add(new EnderecoEntity(COUNTER.incrementAndGet(),listapessoas.get(2).getIdPessoa(),TipoEndereco.RESIDENCIAL,"Av. Venâncio Aires",210,"Ap 45","20460200","Esteio","RS","Brasil"));
    }


    public EnderecoEntity create(EnderecoEntity endereco) {
        endereco.setIdEndereco(COUNTER.incrementAndGet());

        listaEnderecos.add(endereco);
        return endereco;
    }

    public List<EnderecoEntity> list() {
        return listaEnderecos;
    }

    public EnderecoEntity listaEnd(Integer idEndereco) throws RegraDeNegocioException {
        return listaEnderecos.stream()
                .filter(endereco -> endereco.getIdEndereco().equals(idEndereco)).findFirst()
                .orElseThrow(() -> new RegraDeNegocioException("Endereco não econtrado"));
    }

    public List<EnderecoEntity> listByIdPessoa(Integer idPessoa) throws RegraDeNegocioException {

        pessoaService.list().stream()
                .filter(pessoa -> pessoa.getIdPessoa().equals(idPessoa)).findFirst()
                .orElseThrow(() -> new RegraDeNegocioException("Pessoa não encontrada"));

        return listaEnderecos.stream().filter(endereco -> endereco.getIdPessoa().equals(idPessoa)).collect(Collectors.toList());
    }

    public EnderecoEntity update(Integer idEndereco,
                                 EnderecoEntity enderecoAtualizar) throws RegraDeNegocioException {
        EnderecoEntity enderecoRecuperado = listaEnderecos.stream()
                .filter(endereco -> endereco.getIdEndereco().equals(idEndereco))
                .findFirst()
                .orElseThrow(() -> new RegraDeNegocioException("Endereco não econtrado"));
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
        EnderecoEntity enderecoRecuperado = listaEnderecos.stream()
                .filter(endereco -> endereco.getIdEndereco().equals(id))
                .findFirst()
                .orElseThrow(() -> new RegraDeNegocioException("Endereco não econtrado"));
        listaEnderecos.remove(enderecoRecuperado);
    }
}
