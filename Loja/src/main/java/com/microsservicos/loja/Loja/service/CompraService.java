package com.microsservicos.loja.Loja.service;

import com.microsservicos.loja.Loja.client.FornecedorClient;
import com.microsservicos.loja.Loja.dto.CompraDTO;
import com.microsservicos.loja.Loja.dto.InfoFornecedorDTO;
import com.microsservicos.loja.Loja.dto.InfoPedidoDTO;
import com.microsservicos.loja.Loja.model.Compra;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CompraService {

    private static final Logger LOG = LoggerFactory.getLogger(CompraService.class);
    @Autowired
    private FornecedorClient fornecedorClient;

    public Compra realizaCompra(CompraDTO compra) {

        LOG.info("Buscando informações do fornecedor de {}", compra.getEndereco().getEstado());

        InfoFornecedorDTO info =fornecedorClient.getInfoPorEstado(compra.getEndereco().getEstado());

        LOG.info("Realizando um pedido");
        InfoPedidoDTO pedido = fornecedorClient.realizaPedido(compra.getItens());


        Compra compraSalva = new Compra();
        compraSalva.setPedidoId(pedido.getId());
        compraSalva.setTempoPreparo(pedido.getTempoPreparo());
        compraSalva.setEnderecoDestino(compra.getEndereco().toString());

        return compraSalva;
    }
}
