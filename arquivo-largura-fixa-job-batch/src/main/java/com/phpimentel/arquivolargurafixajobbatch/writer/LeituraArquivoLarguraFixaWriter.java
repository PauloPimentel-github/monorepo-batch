package com.phpimentel.arquivolargurafixajobbatch.writer;

import com.phpimentel.arquivolargurafixajobbatch.dominio.Cliente;
import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LeituraArquivoLarguraFixaWriter {

    @Bean
    public ItemWriter<Cliente> imprimeWriter() {
        return itens -> itens.forEach(System.out::println);
    }
}
