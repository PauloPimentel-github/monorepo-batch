package com.phpimentel.envioemailjobbatch.domain;

import lombok.Data;
import java.io.Serializable;

@Data
public class InteresseProdutoCliente implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private Cliente cliente;
    private Produto produto;
}
