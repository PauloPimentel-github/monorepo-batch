package com.phpimentel.segundojobbatch.step;

import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ImprimeParImparStepConfig {

    private static final Integer CHUNK_SIZE = 1;

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Bean
    public Step imprimeParImparStep(
            ItemReader<Integer> reader,
            ItemProcessor<Integer, String> processor,
            ItemWriter<String> writer) {
        return this.stepBuilderFactory
                .get("imprimeParImparStep")
                .<Integer, String>chunk(CHUNK_SIZE)
                .reader(reader)
                .processor(processor)
                .writer(writer)
                .build();
    }
}
