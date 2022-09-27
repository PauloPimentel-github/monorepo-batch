package com.phpimentel.envioemailjobbatch.step;

import com.phpimentel.envioemailjobbatch.domain.InteresseProdutoCliente;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.SimpleMailMessage;

import org.springframework.batch.item.ItemWriter;

@Configuration
public class EnvioEmailClienteStepConfig {

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Bean
    public Step envioEmailClienteStep(
            ItemReader<InteresseProdutoCliente> lerInteresseProdutoClienteReader,
            ItemProcessor<InteresseProdutoCliente, SimpleMailMessage> processarEmailProdutoClienteProcessor,
            ItemWriter<SimpleMailMessage> enviarEmailProdutoClienteWriter) {
        return this.stepBuilderFactory
                .get("envioEmailClienteStep")
                .<InteresseProdutoCliente, SimpleMailMessage>chunk(1)
                .reader(lerInteresseProdutoClienteReader)
                .processor(processarEmailProdutoClienteProcessor)
                .writer(enviarEmailProdutoClienteWriter)
                .build();
    }
}
