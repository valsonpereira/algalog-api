package com.algaworks.algalog.api.controller;

import com.algaworks.algalog.domain.model.Cliente;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class ClienteController {

    @GetMapping("/clientes")
    public List<Cliente> listar(){
        Cliente cliente1 = new Cliente();
        cliente1.setId(1L);
        cliente1.setNome("Joao");
        cliente1.setTelefone("9999-9999");
        cliente1.setEmail("joaodascouves@algaworks.com");

        Cliente cliente2 = new Cliente();
        cliente2.setId(2L);
        cliente2.setNome("Maria da Silva");
        cliente2.setTelefone("9999-9999");
        cliente2.setEmail("joaodascouves@algaworks.com");

        return Arrays.asList(cliente1, cliente2);
    }

}
