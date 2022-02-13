package com.algaworks.algalog.mapper;


import com.algaworks.algalog.api.dto.EntregaDto;
import com.algaworks.algalog.api.dto.request.EntregaRequest;
import com.algaworks.algalog.domain.model.Entrega;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Component
public class EntregaMapper {

    private ModelMapper modelMapper;

    public EntregaDto toDto(Entrega entrega){
        return modelMapper.map(entrega, EntregaDto.class);
    }

    public List<EntregaDto> toArrayAsAList(List<Entrega> entregas){
        return entregas.stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    public Entrega toEntity(EntregaRequest entregaRequest){
        return modelMapper.map(entregaRequest, Entrega.class);
    }
}
