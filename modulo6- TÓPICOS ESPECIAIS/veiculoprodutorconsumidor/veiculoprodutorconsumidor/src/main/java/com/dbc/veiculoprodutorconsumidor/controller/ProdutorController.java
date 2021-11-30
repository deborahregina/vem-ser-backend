package com.dbc.veiculoprodutorconsumidor.controller;

import com.dbc.veiculoprodutorconsumidor.dto.VeiculoDTO;
import com.dbc.veiculoprodutorconsumidor.kafka.Producer;
import com.dbc.veiculoprodutorconsumidor.repository.VeiculoRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/kafka")
@RequiredArgsConstructor
public class ProdutorController {
    private final Producer producer;
    private final VeiculoRepository veiculoRepository;


    @PostMapping("/veiculo")
    public void inserirAlunoKafka(@RequestBody VeiculoDTO veiculoDTO) throws JsonProcessingException {
        producer.sendMessageDTO(veiculoDTO);
    }

    @GetMapping
    public List<VeiculoDTO> listaVeiculos() {
        return veiculoRepository.findAll();
    }
}
