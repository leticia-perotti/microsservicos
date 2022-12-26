package com.microsservicos.loja.Loja.service;

import com.microsservicos.loja.Loja.dto.CompraDTO;
import com.microsservicos.loja.Loja.dto.InfoFornecedorDTO;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class CompraService {
    public void realizaCompra(CompraDTO compra) {

        RestTemplate client =  new RestTemplate();

        ResponseEntity<InfoFornecedorDTO> exchange = client.exchange(
                "http://localhost:8081/info/" + compra.getEndereco().getEstado(),
                HttpMethod.GET,
                null,
                InfoFornecedorDTO.class
        );


    }
}
