package com.example.sparkSpringBootExample.service;

import com.example.sparkSpringBootExample.entity.BasicElement;
import com.example.sparkSpringBootExample.mapper.BasicElementMapper;
import com.mongodb.spark.MongoSpark;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Encoders;
import org.apache.spark.sql.Row;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class BasicElementServiceImpl implements BasicElementService {

    @Value("${fileName}")
    private String fileName;
    private final SparkParsingService sparkParsingService;
    //private final MyEntityMapper myEntityMapper;
    private final BasicElementMapper basicElementMapper;

    @Override
    public void save() {
        Dataset<Row> dataset = sparkParsingService.parse(fileName);
        //Dataset<MyEntity> mappedDataset = dataset.map(myEntityMapper, Encoders.bean(MyEntity.class));
        Dataset<BasicElement> mappedDataset = dataset.map(basicElementMapper, Encoders.bean(BasicElement.class));
        mappedDataset.foreach(entity -> log.info("entity is {}", entity));
        MongoSpark.save(mappedDataset);
    }
}
