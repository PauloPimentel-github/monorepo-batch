package com.phpimentel.arquivolargurafixajobbatch.step;

import com.phpimentel.arquivolargurafixajobbatch.dominio.Cliente;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ArquivoLarguraFixaStepConfig {

    @Autowired
    public StepBuilderFactory stepBuilderFactory;

    @Bean
    public Step leituraArquivoLarguraFixaStep(ItemReader<Cliente> reader,
                                              ItemWriter<Cliente> writer) {
        return this.stepBuilderFactory
                .get("leituraArquivoLarguraFixaStep")
                .<Cliente, Cliente>chunk(1)
                .reader(reader)
                .writer(writer)
                .build();
    }
}
