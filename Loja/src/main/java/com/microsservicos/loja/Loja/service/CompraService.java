package com.microsservicos.loja.Loja.service;

import com.microsservicos.loja.Loja.dto.CompraDTO;
import com.microsservicos.loja.Loja.dto.InfoFornecedorDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CompraService {

    @Autowired
    private RestTemplate client;
    public void realizaCompra(CompraDTO compra) {

        RestTemplate client =  new RestTemplate();

        ResponseEntity<InfoFornecedorDTO> exchange = client.exchange(
                "http://forncedor/info/" + compra.getEndereco().getEstado(),
                HttpMethod.GET,
                null,
                InfoFornecedorDTO.class
        );

        System.out.println(exchange.getBody());

    }
}
