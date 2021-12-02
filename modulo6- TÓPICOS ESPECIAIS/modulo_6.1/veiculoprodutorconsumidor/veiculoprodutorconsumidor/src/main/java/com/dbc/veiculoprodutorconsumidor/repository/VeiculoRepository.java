package com.dbc.veiculoprodutorconsumidor.repository;

import com.dbc.veiculoprodutorconsumidor.dto.VeiculoDTO;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface VeiculoRepository extends MongoRepository<VeiculoDTO, String> {


}