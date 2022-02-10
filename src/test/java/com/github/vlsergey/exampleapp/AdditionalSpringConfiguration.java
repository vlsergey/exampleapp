package com.github.vlsergey.exampleapp;

import org.springframework.context.annotation.Bean;

public class AdditionalSpringConfiguration {

    @Bean
    public QueryExecutionListeners queryExecutionListener() {
        return new QueryExecutionListeners();
    }

    @Bean
    public TestTxHelper testTxHelper() {
        return new TestTxHelper();
    }
}
