package com.example.sparkSpringBootExample.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class SparkParsingServiceImpl implements SparkParsingService {

    @Value("${fileName}")
    private String fileName;
    @Value("fileDataAddress")
    private String dataAddress;
    private final SparkSession sparkSession;

    @Override
    public Dataset<Row> parse() {
        Dataset<Row> dataset = sparkSession.read()
                .format("com.crealytics.spark.excel")
                .option("useHeader", "true")
                .option("inferSchema", "false")
                .option("dataAddress", dataAddress)
                .load(fileName);
        dataset.show(1000);
        return dataset;
    }
}
