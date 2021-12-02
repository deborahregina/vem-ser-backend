package com.dbc.pessoaapi.controller;


import com.dbc.pessoaapi.dto.EmailDTO;
import com.dbc.pessoaapi.kafka.Producer;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/kafka")
@RequiredArgsConstructor
public class ProducerController {
    private final Producer producer;


    @PostMapping("/email")
    public void enviarEmail(@RequestBody EmailDTO emailDTO) throws JsonProcessingException {
        producer.sendMessageDTO(emailDTO);
    }
}