package com.firecode.app.controller.dto;

import com.firecode.app.controller.util.FormatLocalDatetUtil;
import com.firecode.app.model.entity.ClienteEntity;
import com.firecode.app.model.entity.GeneroEntity;
import com.firecode.app.model.entity.PessoaEntity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

public class PerfilDto {

    @Getter
    @Setter
    @NotNull
    @NotBlank
    private String nome;
    @Getter
    @Setter
    @NotNull
    @NotBlank
    private String cpf;
    @Getter
    @Setter
    @NotNull
    @NotBlank
    private String dataNascimento;
    @Getter
    @Setter
    @NotNull
    private int idGenero;
    @Getter
    @Setter
    @NotNull
    @NotBlank
    private String email;
    @Getter
    @Setter
    @NotNull
    @NotBlank
    private String telefone;
    @Getter
    @Setter
    private String carteiraBitcoin;
    @Getter
    @Setter
    @NotNull
    private int idBanco;
    @Getter
    @Setter
    @NotNull
    private int idTipoConta;
    @Getter
    @Setter
    @NotNull
    @NotBlank
    private String agencia;
    @Getter
    @Setter
    @NotNull
    @NotBlank
    private String numeroConta;
    @Getter
    @Setter
    private String genero;
    @Getter
    @Setter
    private String banco;
    @Getter
    @Setter
    private String tipoConta;

    public PessoaEntity atualizaPerfil(PessoaEntity pessoa, PerfilDto dto) {

        pessoa.getClienteEntity().setIdGenero(new GeneroEntity(dto.getIdGenero()));

        return pessoa;
    }

    public static PerfilDto converterObject(ClienteEntity cliente) {

        PerfilDto dto = new PerfilDto();
        dto.setNome(cliente.getIdPessoa().getNomeRasaosocial());
        dto.setCpf(cliente.getIdPessoa().getCpfCnpj());
        dto.setDataNascimento(FormatLocalDatetUtil.converterToLocalDate(cliente.getDataNascimento()));
        dto.setIdGenero(cliente.getIdGenero().getId());
        dto.setGenero(cliente.getIdGenero().getNome());
        dto.setEmail(cliente.getIdPessoa().getContatoEntity().getEmail());
        dto.setTelefone(cliente.getIdPessoa().getContatoEntity().getTelefone());
        
        if (cliente.getContaBancariaEntity() != null) {
            dto.setBanco(cliente.getContaBancariaEntity().getIdBanco().getNome());
            dto.setTipoConta(cliente.getContaBancariaEntity().getIdTipo().getNome());
            dto.setAgencia(cliente.getContaBancariaEntity().getAgencia());
            dto.setNumeroConta(cliente.getContaBancariaEntity().getNumero());
        }

        return dto;

    }

}
