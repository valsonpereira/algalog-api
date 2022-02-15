package com.algaworks.algalog.api.dto;

import com.algaworks.algalog.domain.model.Ocorrencia;
import com.algaworks.algalog.domain.model.StatusEntrega;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class EntregaDto {

    private Long id;
    private ClienteDto cliente;
    private List<OcorrenciaDto> ocorrencias;
    private DestinatarioDto destinatario;
    private BigDecimal taxa;
    private StatusEntrega status;
    private OffsetDateTime dataPedido;
}
