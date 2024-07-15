package com.example.answeringservice.config;

import com.zaxxer.hikari.HikariDataSource;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.example.answeringservice.repository")
public class DataSourceConfig {
    @Bean
    @ConfigurationProperties("spring.datasource")
    public HikariDataSource customDataSource() {
        return DataSourceBuilder.create().type(HikariDataSource.class).build();
    }
}
