package com.fornecedor.fornecedor.controller;

import com.fornecedor.fornecedor.model.Produto;
import com.fornecedor.fornecedor.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @RequestMapping("/{estado}")
    public List<Produto> getProdutosPorEstado(@PathVariable("estado") String estado) {
        return produtoService.getProdutosPorEstado(estado);
    }
}
