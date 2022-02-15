package com.algaworks.algalog.api.controller;

import com.algaworks.algalog.api.dto.request.ClienteRequest;
import com.algaworks.algalog.domain.model.Cliente;
import com.algaworks.algalog.domain.repository.ClienteRepository;
import com.algaworks.algalog.domain.service.CatalogoClienteService;
import com.algaworks.algalog.mapper.ClienteMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@RestController
@Api(value = "Cliente")
@RequestMapping("/clientes")
public class ClienteController {

    private ClienteRepository clienteRepository;
    private CatalogoClienteService catalogoClienteService;
    private ClienteMapper clienteMapper;

    @ApiOperation(value = "Consultar a todos os clientes")
    @GetMapping
    public List<Cliente> listar(){
        return clienteRepository.findAll();
    }

    @ApiOperation(value = "Consultar a um cliente especifico")
    @GetMapping("/{clienteId}")
    public ResponseEntity<Cliente> buscar(@PathVariable Long clienteId){
        return clienteRepository.findById(clienteId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());

   }

    @ApiOperation(value = "Cadastrar um cliente")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente adicionar(@Valid @RequestBody ClienteRequest clienteRequest){

        Cliente cliente = clienteMapper.toEntity(clienteRequest);
        return catalogoClienteService.salvar(cliente);
    }

    @ApiOperation(value = "atualizar um cliente")
    @PutMapping("/{clienteId}")
    public ResponseEntity<Cliente> atualizar(@Valid @PathVariable Long clienteId,
                                             @RequestBody Cliente cliente){
        if(!clienteRepository.existsById(clienteId))
            return ResponseEntity.notFound().build();

        cliente.setId(clienteId);
        return ResponseEntity.ok(catalogoClienteService.salvar(cliente));
    }

    @ApiOperation(value = "deletar um cliente")
    @DeleteMapping("/{clienteId}")
    public ResponseEntity<Void> remover(@PathVariable Long clienteId){
        if(!clienteRepository.existsById(clienteId))
            return ResponseEntity.notFound().build();

        catalogoClienteService.excluir(clienteId);

         return ResponseEntity.noContent().build();
    }


}
