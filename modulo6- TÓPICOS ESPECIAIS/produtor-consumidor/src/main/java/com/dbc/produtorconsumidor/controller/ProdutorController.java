package com.dbc.produtorconsumidor.controller;

import com.dbc.produtorconsumidor.kafka.Producer;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kafka")
@RequiredArgsConstructor
public class ProdutorController {
    private final Producer producer;

    @PostMapping("/enviar")
    private void enviar(String mensagem) {
        producer.sendMessage(mensagem);
    }
}
