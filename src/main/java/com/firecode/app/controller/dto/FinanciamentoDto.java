package com.firecode.app.controller.dto;

import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

public class FinanciamentoDto {

    @Getter
    @Setter
    private int id;
    @Getter
    @Setter
    private String status;
    @Getter
    @Setter
    private String descricao;
    @Getter
    @Setter
    private String dataAceite;
    @Getter
    @Setter
    private String login;
    @Getter
    @Setter
    private String nome;

    public List<FinanciamentoDto> listPaymentSchedule() {

        List<FinanciamentoDto> list = new ArrayList<>();

        for (int i = 1; i < 100; i++) {
            FinanciamentoDto dto = new FinanciamentoDto();
            dto.setId(i);
            dto.setNome("Fernando Braga " + i);
            dto.setLogin("fmatheus " + i);
            dto.setDataAceite("24/01/2020 05:28:21");
            dto.setStatus("Em Aberto");
            list.add(dto);
        }

        return list;

    }

}
