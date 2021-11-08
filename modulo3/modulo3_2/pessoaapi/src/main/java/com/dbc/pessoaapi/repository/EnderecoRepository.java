package com.dbc.pessoaapi.repository;


import com.dbc.pessoaapi.dto.PessoaDTO;
import com.dbc.pessoaapi.entity.*;
import com.dbc.pessoaapi.exceptions.RegraDeNegocioException;
import com.dbc.pessoaapi.service.PessoaService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Repository
public interface EnderecoRepository extends JpaRepository<EnderecoEntity,Integer> {

}