package com.algaworks.algalog.mapper;

import com.algaworks.algalog.api.dto.EntregaDto;
import com.algaworks.algalog.api.dto.request.ClienteRequest;
import com.algaworks.algalog.api.dto.request.EntregaRequest;
import com.algaworks.algalog.domain.model.Cliente;
import com.algaworks.algalog.domain.model.Entrega;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class ClienteMapper {

    private ModelMapper modelMapper;

    public Cliente toEntity(ClienteRequest clienteRequest){
        return modelMapper.map(clienteRequest, Cliente.class);
    }
}
