package com.firecode.app.controller.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import lombok.Getter;
import lombok.Setter;

public class PedidoDto {

    @Getter
    @Setter
    private int id;
    @Getter
    @Setter
    private String categoria;
    @Getter
    @Setter
    private String dataSolicitacao;
    @Getter
    @Setter
    private String valor;
    @Getter
    @Setter
    private int pontos;
    @Getter
    @Setter
    private String status;

    public List<PedidoDto> list() {
        List<PedidoDto> list = new ArrayList<>();

        Random random = new Random();

        for (int i = 1; i < 100; i++) {
            PedidoDto dto = new PedidoDto();
            dto.setId(i);
            dto.setCategoria("Investimento");
            dto.setDataSolicitacao("03/10/2020");
            dto.setValor("R$ " + String.valueOf(random.nextGaussian()));
            dto.setPontos(random.nextInt(100));
            dto.setStatus("Cancelado");
            list.add(dto);
        }

        return list;
    }

}
