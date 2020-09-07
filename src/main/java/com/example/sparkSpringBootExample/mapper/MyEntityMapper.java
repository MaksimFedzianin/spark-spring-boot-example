package com.example.sparkSpringBootExample.mapper;

import com.example.sparkSpringBootExample.entity.MyEntity;
import org.apache.spark.api.java.function.MapFunction;
import org.apache.spark.sql.Row;

import java.io.Serializable;

public interface MyEntityMapper extends MapFunction<Row, MyEntity> {

    @Override
    MyEntity call(Row value) throws Exception;
}
