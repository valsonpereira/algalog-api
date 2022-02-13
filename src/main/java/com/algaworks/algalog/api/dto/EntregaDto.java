package com.algaworks.algalog.api.dto;

import com.algaworks.algalog.domain.model.StatusEntrega;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Getter
@Setter
public class EntregaDto {

    private Long id;
    private ClienteDto cliente;
    private DestinatarioDto destinatario;
    private BigDecimal taxa;
    private StatusEntrega statusEntrega;
    private OffsetDateTime dataPedido;
}
