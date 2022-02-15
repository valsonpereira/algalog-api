package com.algaworks.algalog.api.controller;

import com.algaworks.algalog.api.dto.OcorrenciaDto;
import com.algaworks.algalog.api.dto.request.OcorrenciaRequest;
import com.algaworks.algalog.domain.model.Entrega;
import com.algaworks.algalog.domain.model.Ocorrencia;
import com.algaworks.algalog.domain.service.BuscaEntregaService;
import com.algaworks.algalog.domain.service.RegistroOcorrenciaService;
import com.algaworks.algalog.mapper.OcorrenciaMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Api(value = "Ocorrencia")
@AllArgsConstructor
@RestController
@RequestMapping("/entregas/{entregaId}/ocorrencias")
public class OcorrenciaController {

    private RegistroOcorrenciaService registroOcorrenciaService;
    private OcorrenciaMapper ocorrenciaMapper;
    private BuscaEntregaService buscaEntregaService;

    @ApiOperation(value = "Resgistrar uma ocorrencia em uma entrega")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public OcorrenciaDto registrar(@PathVariable Long entregaId,
                                   @Valid @RequestBody OcorrenciaRequest ocorrenciaRequest){

        Ocorrencia ocorrenciaRegistrada = registroOcorrenciaService.registrar(entregaId, ocorrenciaRequest.getDescricao());

        return ocorrenciaMapper.toDto(ocorrenciaRegistrada);
    }
    @ApiOperation(value = "Consultar todas ocorrencias de uma determinada entrega")
    @GetMapping
    public List<OcorrenciaDto> listar(@PathVariable Long entregaId){

        Entrega entrega = buscaEntregaService.buscar(entregaId);

        return ocorrenciaMapper.toArrayAsAList(entrega.getOcorrencias());


    }
}
