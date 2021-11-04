package com.dbc.pessoaapi.repository;

import com.dbc.pessoaapi.dto.ContatoCreateDTO;
import com.dbc.pessoaapi.dto.ContatoDTO;
import com.dbc.pessoaapi.dto.PessoaDTO;
import com.dbc.pessoaapi.entity.ContatoEntity;
import com.dbc.pessoaapi.entity.PessoaEntity;
import com.dbc.pessoaapi.entity.TipoContato;
import com.dbc.pessoaapi.exceptions.RegraDeNegocioException;
import com.dbc.pessoaapi.service.PessoaService;
import com.fasterxml.jackson.databind.ObjectMapper;
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
public class ContatoRepository {

    private static List<ContatoEntity> listaContatos = new ArrayList<>();
    private AtomicInteger COUNTER = new AtomicInteger();
    @Autowired
    private final PessoaRepository pessoaRepository;
    private final ObjectMapper objectMapper;

//    @PostConstruct
//    public void inicializar() {
//
//        List<PessoaDTO> listapessoas = pessoaRepository.list().stream()
//                .map(pessoa -> objectMapper.convertValue(pessoa, PessoaDTO.class))
//                .collect(Collectors.toList());
//
//        listaContatos.add(new ContatoEntity(COUNTER.incrementAndGet(), listapessoas.get(0).getIdPessoa(), TipoContato.RESIDENCIAL, "92523699", "Whatsapp"));
//        listaContatos.add(new ContatoEntity(COUNTER.incrementAndGet(), listapessoas.get(1).getIdPessoa(),TipoContato.COMERCIAL, "92200300", "Residencial"));
//        listaContatos.add(new ContatoEntity(COUNTER.incrementAndGet(), listapessoas.get(2).getIdPessoa(), TipoContato.RESIDENCIAL, "92200699", "Residencial"));
//    }

    public ContatoEntity create(ContatoEntity contato) throws RegraDeNegocioException {
        contato.setIdContato(COUNTER.incrementAndGet());
        listaContatos.add(contato);
        return contato;
    }

    public List<ContatoEntity> list() {
        return listaContatos;
    }

    public ContatoEntity update(Integer idContato,
                                ContatoEntity contatoAtualizar) throws RegraDeNegocioException {
        ContatoEntity contatoRecuperada = listaContatos.stream()
                .filter(contato -> contato.getIdContato().equals(idContato))
                .findFirst()
                .orElseThrow(() -> new RegraDeNegocioException("Contato não econtrado"));
        contatoRecuperada.setDescricao(contatoAtualizar.getDescricao());
        contatoRecuperada.setTipoContato(contatoAtualizar.getTipoContato());
        contatoRecuperada.setNumero(contatoAtualizar.getNumero());

        return contatoRecuperada;
    }

    public List<ContatoEntity> listByPessoa(Integer idPessoa) throws RegraDeNegocioException {
        List<ContatoEntity> contatoDaspessoas;

        contatoDaspessoas = listaContatos.stream()
                .filter(contato -> contato.getIdPessoa().equals(idPessoa))
                .collect(Collectors.toList());
        if (contatoDaspessoas.isEmpty()) {
            throw new RegraDeNegocioException("Pessoa não encontrada!");
        }
        return contatoDaspessoas;
    }

    public void delete(Integer id) throws RegraDeNegocioException {
        ContatoEntity contatoRecuperada = listaContatos.stream()
                .filter(contato -> contato.getIdContato().equals(id))
                .findFirst()
                .orElseThrow(() -> new RegraDeNegocioException("Contato não encontrado"));
        listaContatos.remove(contatoRecuperada);
    }
}
