package com.example.sparkSpringBootExample.mapper;

import com.example.sparkSpringBootExample.entity.BasicElement;
import org.apache.spark.api.java.function.MapFunction;
import org.apache.spark.sql.Row;

public interface BasicElementMapper extends MapFunction<Row, BasicElement> {
}
