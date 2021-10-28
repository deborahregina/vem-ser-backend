package com.dbc.pessoaapi.repository;

import com.dbc.pessoaapi.entity.Contato;
import com.dbc.pessoaapi.entity.Pessoa;
import com.dbc.pessoaapi.entity.TipoContato;
import com.dbc.pessoaapi.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Repository
public class ContatoRepository {

    private static List<Contato> listaContatos = new ArrayList<>();
    private AtomicInteger COUNTER = new AtomicInteger();
    @Autowired
    private PessoaService pessoaService;


    @PostConstruct
    public void inicializar() {
        List<Pessoa> listapessoas = pessoaService.list();
        listaContatos.add(new Contato(COUNTER.incrementAndGet(), listapessoas.get(0).getIdPessoa(), TipoContato.ofTipo(1), "92523699", "Whatsapp"));
        listaContatos.add(new Contato(COUNTER.incrementAndGet(), listapessoas.get(1).getIdPessoa(), TipoContato.ofTipo(2), "92200300", "Residencial"));
        listaContatos.add(new Contato(COUNTER.incrementAndGet(), listapessoas.get(2).getIdPessoa(), TipoContato.ofTipo(2), "92200699", "Residencial"));
    }

    public Contato create(Contato contato, Integer idPessoa) {
        contato.setIdContato(COUNTER.incrementAndGet());
        contato.setIdPessoa(idPessoa);
        listaContatos.add(contato);
        return contato;
    }

    public List<Contato> list() {
        return listaContatos;
    }

    public Contato update(Integer idContato,
                         Contato contatoAtualizar) throws Exception {
        Contato contatoRecuperada = listaContatos.stream()
                .filter(contato -> contato.getIdContato().equals(idContato))
                .findFirst()
                .orElseThrow(() -> new Exception("Contato não econtrado"));
        contatoRecuperada.setDescricao(contatoAtualizar.getDescricao());
        contatoRecuperada.setTipoContato(contatoAtualizar.getTipoContato());
        contatoRecuperada.setNumero(contatoAtualizar.getNumero());

        return contatoRecuperada;
    }

    public List<Contato> listByPessoa(Integer idPessoa) throws Exception {
        //List<Contato> contatoDaspessoas = new ArrayList<>();

        return listaContatos.stream()
                .filter(contato -> contato.getIdPessoa().equals(idPessoa))
                        .collect(Collectors.toList());
        //for (Contato cont : listaContatos) {
        //  if(cont.getIdPessoa() == idPessoa) {
            // contatoDaspessoas.add(cont);
            //}
       // }
    }

    public void delete(Integer id) throws Exception {
        Contato contatoRecuperada = listaContatos.stream()
                .filter(contato -> contato.getIdContato().equals(id))
                .findFirst()
                .orElseThrow(() -> new Exception("Pessoa não econtrada"));
        listaContatos.remove(contatoRecuperada);
    }
}
