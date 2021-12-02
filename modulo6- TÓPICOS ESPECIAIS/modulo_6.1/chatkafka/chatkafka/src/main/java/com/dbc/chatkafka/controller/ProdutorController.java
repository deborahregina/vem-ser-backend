package com.dbc.chatkafka.controller;

import com.dbc.chatkafka.dto.ListaChatDTO;
import com.dbc.chatkafka.dto.MensagemDTO;
import com.dbc.chatkafka.kafka.Producer;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/kafka")
@RequiredArgsConstructor
public class ProdutorController {
    private final Producer producer;


    @PostMapping("/mensagem-chat-geral")
    public void enviarMensagem(@RequestBody ListaChatDTO listaChatDTO) throws JsonProcessingException {
        producer.sendMessageDTO(listaChatDTO);
    }
}
