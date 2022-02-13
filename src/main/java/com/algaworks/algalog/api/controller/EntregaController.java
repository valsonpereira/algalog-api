package com.algaworks.algalog.api.controller;

import com.algaworks.algalog.api.dto.DestinatarioDto;
import com.algaworks.algalog.api.dto.EntregaDto;
import com.algaworks.algalog.domain.model.Entrega;
import com.algaworks.algalog.domain.repository.EntregaRepository;
import com.algaworks.algalog.domain.service.SolicitacaoEntregaService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@AllArgsConstructor
@RestController
@RequestMapping("/entregas")
public class EntregaController {

    private SolicitacaoEntregaService solicitacaoEntregaService;
    private EntregaRepository entregaRepository;
    private ModelMapper modelMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Entrega solicitar(@Valid @RequestBody Entrega entrega){

        return solicitacaoEntregaService.solicitar(entrega);
    }

    @GetMapping("/{entregaId}")
    public ResponseEntity<EntregaDto> buscar(@PathVariable Long entregaId){
        return entregaRepository.findById(entregaId)
                .map(entrega -> {
                    EntregaDto entregaDto = modelMapper.map(entrega, EntregaDto.class);
                    return ResponseEntity.ok(entregaDto);
                    }
                )
                .orElse(ResponseEntity.notFound().build());
    }

}
