package com.phpimentel.envioemailjobbatch.domain;

import lombok.Data;
import java.io.Serializable;

@Data
public class Cliente implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String nome;
    private String email;
}
