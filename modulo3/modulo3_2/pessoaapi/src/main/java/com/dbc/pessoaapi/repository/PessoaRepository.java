package com.dbc.pessoaapi.repository;

import com.dbc.pessoaapi.entity.EnderecoEntity;
import com.dbc.pessoaapi.entity.PessoaEntity;
import org.apache.tomcat.jni.Local;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Repository
public interface PessoaRepository extends JpaRepository<PessoaEntity, Integer> {

    PessoaEntity findByCpf(String cpf);
    List<PessoaEntity> findByDataNascimentoBetween(LocalDate inicio, LocalDate fim);
    List<PessoaEntity> findByNomeContainingIgnoreCase(String name);


    @Query("select p from PESSOA p where p.dataNascimento BETWEEN :inicio AND :fim" )
    List<PessoaEntity> findByDataNascimentoBetweenQuery(LocalDate inicio, LocalDate fim);

    @Query("select distinct p " +
            " from PESSOA p " +
            "inner join p.enderecos e")
    List<PessoaEntity> findByEnderecoIsNotNull();


    @Query(value = "SELECT * FROM PESSOA p LEFT JOIN PESSOA_X_PESSOA_ENDERECO pxpe ON (p.ID_PESSOA = pxpe.ID_PESSOA) WHERE PXPE.ID_PESSOA IS NULL" , nativeQuery = true)
    List<PessoaEntity> findPessoasComEndNull();


}
