package com.dbc.pessoaapi.repository;

import com.dbc.pessoaapi.dto.ContatoCreateDTO;
import com.dbc.pessoaapi.dto.ContatoDTO;
import com.dbc.pessoaapi.dto.PessoaDTO;
import com.dbc.pessoaapi.entity.ContatoEntity;
import com.dbc.pessoaapi.entity.EnderecoEntity;
import com.dbc.pessoaapi.entity.PessoaEntity;
import com.dbc.pessoaapi.entity.TipoContato;
import com.dbc.pessoaapi.exceptions.RegraDeNegocioException;
import com.dbc.pessoaapi.service.PessoaService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Repository
public interface ContatoRepository extends JpaRepository<ContatoEntity, Integer> {


    @Query("select p " +
            " from CONTATO p " +
            "where p.tipoContato = :tipo ")
    List<ContatoEntity> procuraPorTipoContato(TipoContato tipo);

    @Query(value = "SELECT * FROM CONTATO e WHERE e.id_pessoa = :idPessoa", nativeQuery = true)
    List<ContatoEntity> findContatoPorIdPessoa(Integer idPessoa);

}
