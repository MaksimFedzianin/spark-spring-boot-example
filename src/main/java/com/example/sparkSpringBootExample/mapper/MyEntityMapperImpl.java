package com.example.sparkSpringBootExample.mapper;

import com.example.sparkSpringBootExample.entity.MyEntity;
import org.apache.spark.sql.Row;
import org.springframework.stereotype.Component;

@Component
public class MyEntityMapperImpl implements MyEntityMapper {

    @Override
    public MyEntity call(Row value) throws Exception {
        return MyEntity.builder()
                .id((int) Double.parseDouble(value.<String>getAs("id").replace(",", ".")))
                .name(value.<String>getAs("name"))
                .column(value.<String>getAs("col"))
                .build();
    }
}
