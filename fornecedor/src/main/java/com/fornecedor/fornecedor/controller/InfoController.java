package com.fornecedor.fornecedor.controller;

import com.fornecedor.fornecedor.model.InfoFornecedor;
import com.fornecedor.fornecedor.service.InfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/info")
public class InfoController {

    private static final Logger LOG = LoggerFactory.getLogger(InfoController.class);

    @Autowired
    private InfoService infoService;

    @RequestMapping("/{estado}")
    public InfoFornecedor getInfoPorEstado(
            @PathVariable String estado){
        LOG.info("Recibido pedido de informações de fornecedor de {}", estado );
        return infoService.getInfoPorEstado(estado);
    }
}
