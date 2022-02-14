package com.algaworks.algalog.api.controller;

import com.algaworks.algalog.api.dto.OcorrenciaDto;
import com.algaworks.algalog.api.dto.request.OcorrenciaRequest;
import com.algaworks.algalog.domain.model.Ocorrencia;
import com.algaworks.algalog.domain.service.RegistroOcorrenciaService;
import com.algaworks.algalog.mapper.OcorrenciaMapper;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@AllArgsConstructor
@RestController
@RequestMapping("/entregas/{entregaId}/ocorrencias")
public class OcorrenciaController {

    private RegistroOcorrenciaService registroOcorrenciaService;
    private OcorrenciaMapper ocorrenciaMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public OcorrenciaDto registrar(@PathVariable Long entregaId,
                                   @Valid @RequestBody OcorrenciaRequest ocorrenciaRequest){

        Ocorrencia ocorrenciaRegistrada = registroOcorrenciaService.registrar(entregaId, ocorrenciaRequest.getDescricao());

        return ocorrenciaMapper.toDto(ocorrenciaRegistrada);
    }


}
