package com.phpimentel.arquivodelimitadojobbatch.writer;

import com.phpimentel.arquivodelimitadojobbatch.dominio.Cliente;
import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LeituraArquivoDelimitadoWriter {

    @Bean
    public ItemWriter<Cliente> imprimeWriter() {
        return itens -> itens.forEach(System.out::println);
    }
}
