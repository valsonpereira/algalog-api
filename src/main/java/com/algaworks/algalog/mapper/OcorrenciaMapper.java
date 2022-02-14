package com.algaworks.algalog.mapper;

import com.algaworks.algalog.api.dto.EntregaDto;
import com.algaworks.algalog.api.dto.OcorrenciaDto;
import com.algaworks.algalog.domain.model.Entrega;
import com.algaworks.algalog.domain.model.Ocorrencia;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Component
public class OcorrenciaMapper {

    private ModelMapper modelMapper;

    public OcorrenciaDto toDto(Ocorrencia ocorrencia){
        return modelMapper.map(ocorrencia, OcorrenciaDto.class);
    }

    public List<OcorrenciaDto> toArrayAsAList(List<Ocorrencia> ocorrencias ){
        return ocorrencias.stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

}
