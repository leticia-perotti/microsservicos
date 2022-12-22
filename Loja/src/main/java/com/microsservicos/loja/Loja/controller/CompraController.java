package com.microsservicos.loja.Loja.controller;

import com.microsservicos.loja.Loja.dto.CompraDTO;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/compra")
public class CompraController {

    @RequestMapping(method = RequestMethod.POST)
    public void realizaCompra(
            @RequestBody CompraDTO compra
    ){

    }
}
