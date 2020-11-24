package com.firecode.app.controller.dto;

import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

public class IndicadoDto {

    @Getter
    @Setter
    private int id;
    @Getter
    @Setter
    private String nome;
    @Getter
    @Setter
    private String email;
    @Getter
    @Setter
    private String telefone;
    @Getter
    @Setter
    private String status;

    public List<IndicadoDto> list() {
        
        List<IndicadoDto> list = new ArrayList<>();

        for (int i = 1; i < 30; i++) {
            IndicadoDto dto = new IndicadoDto();
            dto.setId(i);
            dto.setNome("Fernando Matheus");
            dto.setEmail("fernando.matheuss@hotmail.com");
            dto.setTelefone("(21) 98196-4019");
            dto.setStatus("Cancelado");
            list.add(dto);
        }

        return list;
    }

}
