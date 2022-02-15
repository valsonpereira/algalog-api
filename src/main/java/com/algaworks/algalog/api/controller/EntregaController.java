package com.algaworks.algalog.api.controller;

import com.algaworks.algalog.api.dto.EntregaDto;
import com.algaworks.algalog.api.dto.request.EntregaRequest;
import com.algaworks.algalog.domain.model.Entrega;
import com.algaworks.algalog.domain.repository.EntregaRepository;
import com.algaworks.algalog.domain.service.FinalizacaoEntregaService;
import com.algaworks.algalog.domain.service.SolicitacaoEntregaService;
import com.algaworks.algalog.mapper.EntregaMapper;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;


@AllArgsConstructor
@RestController
@RequestMapping("/entregas")
public class EntregaController {

    private SolicitacaoEntregaService solicitacaoEntregaService;
    private EntregaRepository entregaRepository;
    private FinalizacaoEntregaService finalizacaoEntregaService;
    private EntregaMapper entregaMapper;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public EntregaDto solicitar(@Valid @RequestBody EntregaRequest entregaRequest){
        Entrega entregaSolicitada = entregaMapper.toEntity(entregaRequest);

        return entregaMapper
                .toDto(solicitacaoEntregaService
                        .solicitar(entregaSolicitada)
                );
    }

    @GetMapping
    public List<EntregaDto> listar(){
        return entregaMapper.toArrayAsAList(entregaRepository.findAll());
    }

    @GetMapping("/{entregaId}")
    public ResponseEntity<EntregaDto> buscar(@PathVariable Long entregaId){
        return entregaRepository.findById(entregaId)
                .map(entrega -> {
                    EntregaDto entregaDto = entregaMapper.toDto(entrega);
                    return ResponseEntity.ok(entregaDto);
                    }
                )
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{entregaId}/finalizacao")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void finalizar(@PathVariable Long entregaId){
        finalizacaoEntregaService.finalizar(entregaId);
    }

}
