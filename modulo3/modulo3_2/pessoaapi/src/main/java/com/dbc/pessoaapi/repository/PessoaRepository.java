package com.dbc.pessoaapi.repository;

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

}
