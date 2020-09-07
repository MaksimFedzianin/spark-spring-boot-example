package com.example.sparkSpringBootExample.service;

import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;

public interface SparkParsingService {
    Dataset<Row> parse();
}
