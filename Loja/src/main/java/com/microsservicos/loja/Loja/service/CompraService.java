package com.microsservicos.loja.Loja.service;

import com.microsservicos.loja.Loja.client.FornecedorClient;
import com.microsservicos.loja.Loja.dto.CompraDTO;
import com.microsservicos.loja.Loja.dto.InfoFornecedorDTO;
import com.microsservicos.loja.Loja.dto.InfoPedidoDTO;
import com.microsservicos.loja.Loja.model.Compra;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CompraService {

    @Autowired
    private FornecedorClient fornecedorClient;

    public Compra realizaCompra(CompraDTO compra) {

        InfoFornecedorDTO info =fornecedorClient.getInfoPorEstado(compra.getEndereco().getEstado());

        InfoPedidoDTO pedido = fornecedorClient.realizaPedido(compra.getItens());

        System.out.println(info.getEndereco());

        Compra compraSalva = new Compra();
        compraSalva.setPedidoId(pedido.getId());
        compraSalva.setTempoPreparo(pedido.getTempoPreparo());
        compraSalva.setEnderecoDestino(compra.getEndereco().toString());

        return compraSalva;
    }
}
