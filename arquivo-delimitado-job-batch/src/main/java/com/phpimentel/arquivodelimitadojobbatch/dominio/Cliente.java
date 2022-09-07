package com.phpimentel.arquivodelimitadojobbatch.dominio;

import lombok.Data;
import lombok.ToString;

@ToString
@Data
public class Cliente {

    private String nome;
    private String sobrenome;
    private Integer idade;
    private String email;
}
