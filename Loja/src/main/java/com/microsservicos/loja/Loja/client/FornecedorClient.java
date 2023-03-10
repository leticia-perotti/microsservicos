package com.microsservicos.loja.Loja.client;

import com.microsservicos.loja.Loja.dto.InfoFornecedorDTO;
import com.microsservicos.loja.Loja.dto.InfoPedidoDTO;
import com.microsservicos.loja.Loja.dto.ItemDaCompraDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient("fornecedor")
public interface FornecedorClient {

    @RequestMapping("/info/{estado}")
    InfoFornecedorDTO getInfoPorEstado(@PathVariable String estado);

    @RequestMapping(method = RequestMethod.POST, value = "/pedido")
    InfoPedidoDTO realizaPedido(List<ItemDaCompraDTO> itens);
}
