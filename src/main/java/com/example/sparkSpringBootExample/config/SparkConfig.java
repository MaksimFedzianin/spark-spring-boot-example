package com.example.sparkSpringBootExample.config;

import org.apache.spark.sql.SparkSession;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SparkConfig {

    @Value("${spark.app.name}")
    private String appName;
    @Value("${spark.master}")
    private String masterUri;
    @Value("${spark.mongodb.input.uri}")
    private String inputUri;
    @Value("${spark.mongodb.output.uri}")
    private String outputUri;

    @Bean
    public SparkSession sparkSession() {
        return SparkSession
                .builder()
                .appName(appName)
                .config("spark.master", masterUri)
                .config("spark.mongodb.input.uri", inputUri)
                .config("spark.mongodb.output.uri", outputUri)
                .getOrCreate();
    }

}
