package com.phpimentel.envioemailjobbatch.reader;

import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.batch.item.database.builder.JdbcCursorItemReaderBuilder;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.phpimentel.envioemailjobbatch.domain.Cliente;
import com.phpimentel.envioemailjobbatch.domain.InteresseProdutoCliente;
import com.phpimentel.envioemailjobbatch.domain.Produto;

import java.sql.SQLException;
import javax.sql.DataSource;
import java.sql.ResultSet;
import org.springframework.jdbc.core.RowMapper;

@Configuration
public class LerInteresseProdutoClienteReaderConfig {

    private static final String SQL = "select * from interesse_produto_cliente join cliente on(cliente = cliente.id) join produto on(produto = produto.id)";

    @Bean
    public JdbcCursorItemReader<InteresseProdutoCliente> lerInteresseProdutoClienteReader(
            DataSource dataSource) {
        return new JdbcCursorItemReaderBuilder<InteresseProdutoCliente>()
                .name("lerInteresseProdutoClienteReader")
                .dataSource(dataSource)
                .sql(SQL)
                .rowMapper(this.rowMapper())
                .build();
    }

    private RowMapper<InteresseProdutoCliente> rowMapper() {
        return new RowMapper<InteresseProdutoCliente>() {

            @Override
            public InteresseProdutoCliente mapRow(ResultSet rs, int rowNum) throws SQLException {
                if (rs.getRow() <= 9) {
                    throw new SQLException(String.format("Encerrando a execução - Cliente inválido %s", rs.getString("email")));
                } else {
                    Cliente cliente = new Cliente();
                    cliente.setId(rs.getLong("id"));
                    cliente.setNome(rs.getString("nome"));
                    cliente.setEmail(rs.getString("email"));

                    Produto produto = new Produto();
                    produto.setId(rs.getLong(6));
                    produto.setNome(rs.getString(7));
                    produto.setDescricao(rs.getString("descricao"));
                    produto.setPreco(rs.getDouble("preco"));

                    InteresseProdutoCliente interesseProdutoCliente = new InteresseProdutoCliente();
                    interesseProdutoCliente.setCliente(cliente);
                    interesseProdutoCliente.setProduto(produto);
                    return interesseProdutoCliente;
                }
            }
        };
    }
}
