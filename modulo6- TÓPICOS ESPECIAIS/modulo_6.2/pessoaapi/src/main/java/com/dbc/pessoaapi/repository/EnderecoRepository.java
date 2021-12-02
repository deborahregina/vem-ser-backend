package com.dbc.pessoaapi.repository;


import com.dbc.pessoaapi.dto.PessoaDTO;
import com.dbc.pessoaapi.entity.*;
import com.dbc.pessoaapi.exceptions.RegraDeNegocioException;
import com.dbc.pessoaapi.service.PessoaService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Repository
public interface EnderecoRepository extends JpaRepository<EnderecoEntity,Integer> {

    @Query("select p " +
            " from ENDERECO_PESSOA p " +
            "where upper(pais) = :pais ")
    List<EnderecoEntity> procurarPorPais(String pais);


    @Query("select p from ENDERECO_PESSOA p join p.pessoas pe where pe.idPessoa = :idPessoa")
    List<EnderecoEntity> procurarPorIdPessoa(Integer idPessoa);


    @Query(value = "SELECT *\n" +
            " FROM ENDERECO_PESSOA ep \n" +
            " WHERE (upper(cidade) like upper(:cidade) OR upper(pais) like upper(:pais) )", nativeQuery = true)
    List<EnderecoEntity> findEnderecoCidadePais(String cidade, String pais);

    @Query(value = "SELECT * FROM ENDERECO_PESSOA e WHERE e.complemento is null", nativeQuery = true)
    List<EnderecoEntity> findEnderecoComplementoNull();

    @Query("select p " +
            " from ENDERECO_PESSOA p " +
            "where upper(pais) = :pais ")
    Page<EnderecoEntity> findByPaisJPQL(String pais, Pageable pageable);

}