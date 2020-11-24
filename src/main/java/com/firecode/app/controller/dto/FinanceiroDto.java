package com.firecode.app.controller.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import lombok.Getter;
import lombok.Setter;

public class FinanceiroDto {

    @Getter
    @Setter
    private int id;
    @Getter
    @Setter
    private String data;
    @Getter
    @Setter
    private String valor;
    @Getter
    @Setter
    private String status;
    @Getter
    @Setter
    private String descricao;
    @Getter
    @Setter
    private String tipo;
    @Getter
    @Setter
    private String dataAceite;
    @Getter
    @Setter
    private String login;
    @Getter
    @Setter
    private String nome;
    @Getter
    @Setter
    private String dataSaque;
    @Getter
    @Setter
    private String meioRecebimento;
    @Getter
    @Setter
    private String valorSacado;
    @Getter
    @Setter
    private String valorRecebido;
    @Getter
    @Setter
    private String comentario;

    public List<FinanceiroDto> listExtract() {

        List<FinanceiroDto> list = new ArrayList<>();

        Random random = new Random();

        for (int i = 1; i < 100; i++) {
            FinanceiroDto dto = new FinanceiroDto();
            dto.setId(i);
            dto.setData("03/10/2020");
            dto.setValor("R$ " + String.valueOf(random.nextGaussian()));
            dto.setStatus("Cancelado");
            dto.setDescricao("Descrição " + i);
            dto.setTipo("Tipo " + i);
            list.add(dto);
        }

        return list;
    }

    public List<FinanceiroDto> listWithdraw() {

        List<FinanceiroDto> list = new ArrayList<>();

        Random random = new Random();

        for (int i = 1; i < 100; i++) {
            FinanceiroDto dto = new FinanceiroDto();
            dto.setId(i);
            dto.setDataSaque("10/10/2020");
            dto.setMeioRecebimento("Transferência Bancária");
            dto.setValorSacado("R$ " + String.valueOf(random.nextGaussian()));
            dto.setValorRecebido("R$ " + String.valueOf(random.nextGaussian()));
            dto.setStatus("Pago");
            dto.setComentario("Nenhum comentário");
            list.add(dto);
        }

        return list;
    }

}
