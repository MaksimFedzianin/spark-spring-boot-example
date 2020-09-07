package com.example.sparkSpringBootExample.service;

import com.example.sparkSpringBootExample.entity.MyEntity;
import com.example.sparkSpringBootExample.mapper.MyEntityMapper;
import com.mongodb.spark.MongoSpark;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Encoders;
import org.apache.spark.sql.Row;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class MyEntityServiceImpl implements MyEntityService {

    private final SparkParsingService sparkParsingService;
    private final MyEntityMapper myEntityMapper;

    @Override
    public void save() {
        Dataset<Row> dataset = sparkParsingService.parse();
        Dataset<MyEntity> mappedDataset = dataset.map(myEntityMapper, Encoders.bean(MyEntity.class));
        mappedDataset.foreach(myEntity -> log.info("myEntity is {}", myEntity));
        MongoSpark.save(mappedDataset);
    }
}
